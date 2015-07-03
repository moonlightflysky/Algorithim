package common;

public class InversePairs {
	
	public int invertPairs(int[] num){
		
		int[] count = new int[1];
		sort(num, count);
		return count[0];
		
		
	}
	
	private void merge(int[] a, int[] aux, int lo, int mid, int hi, int[] count){
		
		for (int k = lo; k <= hi; k++){
			aux[k] = a[k];
		}
		
		int i = lo, j = mid + 1;
		
		for (int k = lo; k <= hi; k++){
			
			if (i > mid)				a[k] = aux[j++];
			else if (j > hi)			a[k] = aux[i++];
			
			else if (aux[i] > aux[j]){
				
				a[k] = aux[j++];
				count[0] += mid - i + 1;
				//System.out.println(count[0]);
			}
			else						a[k] = aux[i++];
			
			
		}
	}
	
	private void sort(int[] a, int[] count){
		
		int N = a.length;
		int[] aux = new int[N];
		
		mergeSort(a, aux, 0, N - 1, count);
		
	}
	
	private void mergeSort(int[] a, int[] aux, int lo, int hi, int[] count){
		
		if (lo >= hi){
			return;
		}
		
		int mid = lo + (hi - lo)/2;
		
		//System.out.println(mid);
		mergeSort(a, aux, lo, mid, count);
		mergeSort(a, aux, mid + 1, hi, count);
		
		merge(a, aux, lo, mid, hi, count);
		
	}
	
	public static void main(String[] argv){
		
		int[] num = {7, 6, 5, 4};
		
		InversePairs test = new InversePairs();
		int res = test.invertPairs(num);
		System.out.println(res);
		
	}

}
