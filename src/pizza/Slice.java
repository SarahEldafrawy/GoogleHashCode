package pizza;

import java.awt.Point;

public class Slice {
	private int tomato;
	private int mashrum;
	private int numOfCells;
	private boolean fullSlice = false;
	private Point upperLeftCorner;
	private Point lowerRightCorner;
	public Slice (Point upperLeftCorner, Point lowerRightCorner) {
		this.upperLeftCorner = upperLeftCorner;
		this.lowerRightCorner = lowerRightCorner;
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
		return Math.abs(upperLeftCorner.x + lowerRightCorner.x) + 1;

	}
	public int getWidth(){
		return Math.abs(upperLeftCorner.y + lowerRightCorner.y) + 1;

	}
	public int getArea() {
		return  getHeight() * getWidth();
	}
	public boolean isSliceFull() {
		return fullSlice;
	}
	public void setFullSlice() {
		//TODO you must set full slice when the slice is done if it's full
		fullSlice = true;
	}
	public Point getLeftUpperCorner() {
		return upperLeftCorner;
	}
	public void setLeftUpperCorner(Point leftUpperCorner) {
		this.upperLeftCorner = leftUpperCorner;
	}
	public Point getRightDownCorner() {
		return lowerRightCorner;
	}
	public void setRightDownCorner(Point rightDownCorner) {
		this.lowerRightCorner = rightDownCorner;
	}

}
