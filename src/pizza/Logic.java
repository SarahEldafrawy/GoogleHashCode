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
		for (int i = 0; i < pizzaYummy.length; i++) {
			for (int j = 0; j < pizzaYummy[0].length; j ++){
				if (visitedCells[i][j]) {
					continue;
				}
				Point startPoint = new Point (i, j);
				Point endPoint = BFS(startPoint);
				Slice currentSlice = new Slice (startPoint , endPoint);
				if (isValidSlice(currentSlice)){
					removeSliceFromPizza(currentSlice);
					slices.add(currentSlice);
				}
			}
		}
		// TODO -- Bassant

			//check visited wala la2*
			//start POint ll slice*
			//start BFS to construct return end Point*
				//check valid slice --> method*
					//check number of cells--> in isValidSlice function*
					// if valid return Slice if not return null*
			//if not null add it in List of Slices
			//after getArea() check for full slice to set it
			//set Slice cells visited
	}

	/**
	 * @param currentSlice
	 */
	private void removeSliceFromPizza(Slice currentSlice) {
		// TODO Auto-generated method stub
		for(int i = 0; i < currentSlice.getHeight(); i++) {
			for (int j = 0; j < currentSlice.getWidth(); j++) {
				visitedCells[i][j] = true;
			}
		}

	}

	/**
	 * @param currentSlice
	 * @return
	 */
	private boolean isValidSlice(Slice currentSlice) {
		// TODO Auto-generated method stub -Bassant

		return false;
	}

	private Point BFS(Point startPoint) {

		//set local visited in BFS that differs from the global one
		//check collected area with maximum numbers of cells  --> getArea method
		// TODO BFS algorithms --Alaa
		return null;
	}

	private void sliceExtender() {

		// SARA SARA SARA SARA SARA
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
