import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.*;
import javax.swing.*;

public class Game implements HexGame{

	public int size;
	public int player;
	
	public void setSize(String str){
	
		int num = Integer.parseInt(str);
		
		if(num<6)	System.exit(0);
		
		size = num;
	
	}
	
	public int getSize(){	return size;}
	
	public void setPlayer(int num){	player = num;}
	
	public void reset(){
	
	
	
	}
	
	public void load(){
	
	
	
	}
	
	public void save(){
	
	
	
	}
	
	public void undo(){
	
	
	
	}

}
