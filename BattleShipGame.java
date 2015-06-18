package common;

import java.util.ArrayList;

public class BattleShipGame{

	private static final int N = 10;
	
	enum AttackResponse{
		MISS, HIT, SINK, END;
	}
	
	public class Cord{
		
		private int x;
		private int y;
		private int val;
		private Ship ship;
		
		public Cord(int x, int y){
			this.x = x;
			this.y = y;
			val = 0;
			ship = null;
		}
		
		public int getRow(){
			return x;
		}
		
		public int getCol(){
			return y;
		}
		
		public int getVal(){
			return val;
		}
		
		public void setVal(int val){
			this.val = val;
		}
		
		public Ship getShip(){
			return ship;
		}
		
		public void setShip(Ship ship){
			this.ship = ship;
		}
	
	}
	
	public class Ship{
		
		private ArrayList<Cord> parts;
		private int id;
		
		public Ship(int id){
			parts = new ArrayList<Cord>();
			this.id = id;
		}
		
		public void addParts(Cord c){
			parts.add(c);
		}
		
		public void removePart(Cord c){
			int index = parts.indexOf(c);
			parts.remove(index);
		}
		
		public boolean hasSunk(){
			return parts.size() == 0;
		}
		
		public int getID(){
			return id;
		}
		
		public ArrayList<Cord> getParts(){
			return parts;
		}
		
	}
	
	public class Board{
	
		Cord[][] board;
		ArrayList<Ship> ships;
		
		public Board(){
			board = new Cord[N][N];
			for (int i = 0; i < N; i++){
				for (int j = 0; j < N; j++){
					board[i][j] = new Cord(i, j);
				}
			
			}
		}
		
		public void addShip(Ship newShip){
			
			for (Cord c : newShip.getParts()){
				c.setVal(1);
				c.setShip(newShip);
			}
		}
		
		public boolean checkHit(Cord c){
			return c.val == 1;
		}
		
		public void removePart(Cord c){
			Ship curShip = c.getShip();
			if (curShip == null){
				return;
			}
			
			curShip.removePart(c);
			c.setVal(0);
			c.setShip(null);
			
			if (hasShipShunk(curShip)){
				int index = ships.indexOf(curShip);
				ships.remove(index);
			}
		}
		
		public Ship getShip(Cord c){
			return c.getShip();
		}
		
		public boolean hasShipShunk(Ship curShip){
			return curShip.hasSunk();
		}
		
		public boolean isGameEnd(){
			return ships.size() == 0;
		}
	
	}
	
	public class Player {

		private Board board;
		private int id;
			
		public Player(int id){
			this.id = id;
			board = new Board();
		}
		
		public Board getBoard(){
			return board;
		}
		
		public int getID(){
			return id;
		}
		
		public AttackResponse Attack(Board board, Cord c){
		
			if (!board.checkHit(c)){
				return AttackResponse.MISS;
			}
			
			Ship curShip = c.getShip();
			board.removePart(c);
			
			if (board.isGameEnd()){
				return AttackResponse.END;
			}
			
			if (board.hasShipShunk(curShip)){
				return AttackResponse.SINK;
			}
			
			else{
				return AttackResponse.HIT;
			}
			
		}
		
		
	}	

}
