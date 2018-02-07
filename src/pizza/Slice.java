package pizza;

import java.awt.Point;

public class Slice {
	private int tomato; 
	private int mashrum;
	private int numOfCells;
	//TODO set full slice as a marker
	private Point leftUpperCorner;
	private Point rightDownCorner;
	public Slice (Point leftUpperCorner, Point rightDownCorner) {
		this.leftUpperCorner = leftUpperCorner;
		this.rightDownCorner = rightDownCorner;
	}

	public int getTomato() {
		return tomato;
	}
	public void setTomato(int tomato) {
		this.tomato = tomato;
	}
	public int getMashrum() {
		return mashrum;
	}
	public void setMashrum(int mashrum) {
		this.mashrum = mashrum;
	}
	public int getNumOfCells() {
		return numOfCells;
	}
	public void setNumOfCells(int numOfCells) {
		this.numOfCells = numOfCells;
	}
	public int  getHeight(){
		//TODO Slice-Height
		return 0;

	}
	public int getWidth(){
		//TODO slice_width
		return 0;

	}
	public Point getLeftUpperCorner() {
		return leftUpperCorner;
	}
	public void setLeftUpperCorner(Point leftUpperCorner) {
		this.leftUpperCorner = leftUpperCorner;
	}
	public Point getRightDownCorner() {
		return rightDownCorner;
	}
	public void setRightDownCorner(Point rightDownCorner) {
		this.rightDownCorner = rightDownCorner;
	}
	
}
