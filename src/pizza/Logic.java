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
//		sliceExtender();
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

	private void loopCellsSliceExtender() {
//	    it has list of unvisited cells

//        for each in unvisited cells

//            if (up) it makes a rectangle add it
//                 Slice slice = getSlice(new Point(9,9));
//                 validSlice(slice, unvisitedCells.get(i), closestCellInSlice);

//            if not check (left)
//                 Slice slice = getSlice(new Point(9,9));
//                 validSlice(slice, unvisitedCells.get(i), closestCellInSlice);
//            if not check (right)
//                 Slice slice = getSlice(new Point(9,9));
//                 validSlice(slice, unvisitedCells.get(i), closestCellInSlice);

//            if not check (down)
//                 Slice slice = getSlice(new Point(9,9));
//                 validSlice(slice, unvisitedCells.get(i), closestCellInSlice);

//            default leave it

	}

	private Slice getSlice(Point cell) {
//	    it has list of slices
//        for each slice
//            check if it contains cell
		return null;
	}

	private boolean validSlice(Slice slice, Point unvisitedCell, Point closestCellInSlice) {
		//check cell position
		//get width or height
		//check for maximum number of cells by getArea() [full slice]
		//getSliceArea() then add width or height if the exceed maximum number return false
		//loop for same length of cells and check visited or not
		//if they are unvisited
		//add cells in the slice (backwards loop)
		//return true
		return false;

	}

}
