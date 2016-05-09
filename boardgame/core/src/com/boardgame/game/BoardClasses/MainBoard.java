package com.boardgame.game.BoardClasses;

import com.boardgame.game.BoardClasses.BoardSpace;
import com.boardgame.game.PlayerClasses.Player;

import java.util.ArrayList;

/**
 * This class is used to keep track of the board, and all of its spaces
 * you can retrieve space information by findspace and passing the x,y coords
 *
 */
public class MainBoard {

	private ArrayList<BoardSpace> spaces= new ArrayList<BoardSpace>();
	private ArrayList<Player> players= new ArrayList<Player>();
	int xsize;
	int ysize;
	int turn=0;
	
	
	public MainBoard(BoardSpace[] spaces, Player[] players){
		for(int i =0; i<spaces.length;i++)
			this.spaces.add(spaces[i]);
		for(int i = 0;i<players.length;i++)
			this.players.add(players[i]);		
	}
	public MainBoard(){
		//for an empty board
	}
	public MainBoard(int x, int y){
		makeBoard(x,y);
		xsize = x;
		ysize = y;
	}
	public ArrayList<Player> getPlayers(){
		return players;
	}
	public int getXSize(){
		return xsize;
	}
	public int getYSize(){
		return ysize;
	}
	public void makeBoard(int x, int y){
		for(int i =0; i < x;i++)
		{
			for(int j =0; j < y;j++)
			{
				BoardSpace s = new BoardSpace(i,j,this);
				spaces.add(s);
			}
		}
	}

	public BoardSpace getSpaceAt(int x, int y){
		for(int i=0;i<spaces.size();i++){
			
			if(spaces.get(i).getX()==x&&spaces.get(i).getY()==y){
				return spaces.get(i);
			}
		}
		return null;
	}
	public ArrayList<BoardSpace> getBoardSpaces(){
		return spaces;
	}
	public void addPlayer(int x,int y,String name){
		BoardSpace s = getSpaceAt(x,y);
		Player pp = new Player(name);
		pp.setX(x);
		pp.setY(y);
		if(s != null){
			s.addObject(pp);
			pp.setSpaceon(s);
			players.add(pp);
		}else
		{
			System.out.println("S came out null "+ x+y );
		}
			
	}
	public void addPlayer(Player p){
		BoardSpace s = getSpaceAt(p.getX(),p.getY());
		s.addObject(p);
		if(s != null){
			s.addObject(p);
		p.setSpaceon(s);
		players.add(p);
		}
	}
}
