package linkedin;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.Semaphore;
import java.util.LinkedList;

public class BlockingQueue<T> {
	
	ReentrantLock lock;
	Semaphore emptySem;
	Semaphore fullSem;
	
	
	final LinkedList<T> queue;
	final int capacity;
	
	public BlockingQueue(int capacity){
		lock =new ReentrantLock();
		emptySem = new Semaphore(10);
		fullSem = new Semaphore(0);
		
		queue = new LinkedList<T>();
		this.capacity = capacity;
	}
	
	
	public void put(T obj){
		
		try{
			emptySem.acquire();
			lock.lock();
			
			queue.offer(obj);
			
			lock.unlock();
			fullSem.release();
			
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		
		
	}
	
	public T take(){
		
		try{
			
			fullSem.acquire();
			
			lock.lock();
			
			T res = queue.poll();
			
			lock.unlock();
			
			emptySem.release();
			
			return res;
		}catch(InterruptedException e){
			e.printStackTrace();
			return null;
		}
		
	}
	
	

}
