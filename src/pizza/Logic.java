package pizza;

import java.awt.Point;
import java.util.ArrayList;

public class Logic implements ILogic{
	private ArrayList<Slice> slices;
	private PizzaStructure pizzaStructure;
	private boolean [][] visitedCells;
	private char[][] pizzaYummy;
	public Logic (PizzaStructure pizzaStructure) {
		this.pizzaStructure =pizzaStructure;
		this.pizzaYummy = pizzaStructure.getPizza();
		int row = pizzaYummy.length;
		int col = pizzaYummy[0].length;
		this.visitedCells = new boolean[row][col];
		this.slices = new ArrayList<>();
	}
	
	@Override
	public ArrayList<Slice> solver() {
		BFSStep();
		sliceExtender();
		// TODO Auto-generated method stub
		
		return slices;
	}

	private void BFSStep() {
		//loop 3al array O(n^2)
			//check visited wala la2
			//start POint ll slice
			//start BFS to construct return end Point
				//check valid slice --> method
					//check number of cells
					// if valid return Slice if not return null
			//if not null add it in List of Slices 
			//after getArea() check for full slice to set it
			//set Slice cells visited
	}
	
	private Point BFS() {
		//set local visited in BFS that differs from the global one
		//check collected area with maximum numbers of cells  --> getArea method
		// TODO BFS algorithms
		return null;
	}
	
	private void sliceExtender() {
		//loop check unvisited cells in the structure created
			//check full slice 
		//after getArea() check for full slice to set it
		
		
		
		// TODO 
		//take each unvisited cell and loop for slices
		//if it is a rectangle
		//check for new cells that they are unvisited
		//if yes create the new cell
		//check maximum number of cells
	}
	
}
