package pizza;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Stack;

import queues.Queue;

public class Logic implements ILogic{
	private ArrayList<Slice> slices;
	private PizzaStructure pizzaStructure;
	private boolean [][] visitedCells;
	private char[][] pizzaYummy;
	private int maximumNumberofCells;
	private int row;
	private int col;
	public Logic (PizzaStructure pizzaStructure) {
		this.pizzaStructure =pizzaStructure;
		this.pizzaYummy = pizzaStructure.getPizza();
		this.maximumNumberofCells = pizzaStructure.getMaxNumOfCells();
		row = pizzaYummy.length;
		col = pizzaYummy[0].length;
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
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j ++){
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

		boolean[][] visited = new boolean[row][col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				visited[i][j] = visitedCells[i][j];
			}
		}

		Queue<Point> queue = new Queue<Point>();
		queue.enqueue(startPoint);
		Point currentPoint = startPoint;
		Point endPoint = null;

		Character endPointSybmol = getEndPointSymbol(startPoint);
		while (!(queue.isEmpty())) {
			currentPoint = (Point) queue.dequeue();
			visited[currentPoint.x][currentPoint.y] = true;
			int[] y = {0, 0, -1, 1};
			int[] x = {1, -1, 0, 0};
			if (pizzaYummy[currentPoint.x][currentPoint.y] == endPointSybmol) {
				endPoint = new Point(currentPoint.x, currentPoint.y);
				break;
			}
			for (int i = 0; i < x.length; i++) {
				int rowNum = currentPoint.x + x[i];
				int colNum = currentPoint.y + y[i];
				if (rowNum < row && colNum < col
				&& rowNum >= 0 && colNum >= 0
				&& !visited[rowNum][colNum]) {
					Point point = new Point(colNum, rowNum);
					queue.enqueue(point);
				}
			}
		}
		// TODO elly byshta3'l fel BFS ya5od balo men el null hena
		if (endPoint == null) {
			return null;
		}
		//TODO ana shyfa goz2 el area kolo yt7t fel validate slice
		Slice newSlice = new Slice(startPoint, endPoint);
		if (newSlice.getArea() > maximumNumberofCells) {
			return null;
		}
		return endPoint;
	}

	private Character getEndPointSymbol(Point startPoint) {
		if (pizzaYummy[startPoint.x][startPoint.y] == 'T') {
			return 'M';
		}
		return 'L';
	}

	private void loopCellsSliceExtender() {
		int[] unvisitedCells = new int[0]; //TODO get correct list from pizza structure

        for (int i =0; i< unvisitedCells.length; i++) {
			Point cell = new Point(0, 0); //= list.get(i)
			Point closestCellInSlice = new Point(cell.x, cell.y - 1);
//          if (up) it makes a rectangle add it
			Slice slice = getSlice(closestCellInSlice);
			if (validSlice(slice, cell, closestCellInSlice)) {
				continue;
			}

//          if (left)
			closestCellInSlice = new Point(cell.x-1, cell.y);
			slice = getSlice(closestCellInSlice);
			if (validSlice(slice, cell, closestCellInSlice)) {
				continue;
			}
//          if (right)
			closestCellInSlice = new Point(cell.x+1, cell.y);
			slice = getSlice(closestCellInSlice);
			if (validSlice(slice, cell, closestCellInSlice)) {
				continue;
			}

//          if (down)
            closestCellInSlice = new Point(cell.x, cell.y+1);
			slice = getSlice(closestCellInSlice);
			if (validSlice(slice, cell, closestCellInSlice)) {
				continue;
			}
		}
	}

	private Slice getSlice(Point cell) {
		for (int i=0; i < slices.size(); i++) {
			if (containsCell(slices.get(i),cell)) {
				return slices.get(i);
			}
		}
		return null;
	}

	private boolean containsCell (Slice slice, Point cell) {
		Point upperLeft = slice.getLeftUpperCorner();
		Point downRight = slice.getRightDownCorner();
		if (downRight.getX() >= cell.getX() && upperLeft.getX() <= cell.getX()) {
			if (downRight.getY() >= cell.getY() && upperLeft.getY() <= cell.getY()) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	private boolean validSlice(Slice slice, Point unvisitedCell, Point closestCellInSlice) {
		int length;
		int sliceHeight = slice.getHeight();
		int sliceWidth = slice.getWidth();
		int sliceArea =  sliceHeight*sliceWidth;
		Stack<Point> stack = new Stack<>();
		if (sliceArea == maximumNumberofCells) {
			return false;
		}
		if (closestCellInSlice.y == slice.getLeftUpperCorner().y) {
			length = sliceWidth;
		} else if (closestCellInSlice.x == slice.getRightDownCorner().x) {
			length = sliceHeight;
		} else {
			return false;
		}
		if (sliceArea+length > maximumNumberofCells) {
			return false;
		}
		//check direction
		for (int i = 0; i < length; i++) {
			if (!visitedCells[i][i]) { //TODO condition with directions
				return false;
			} else {
				stack.add(new Point(i,i)); // TODO add correct location
			}
		}
		for (int i = 0; i < stack.size(); i++) {
			//TODO add cells in slice and set the cells visited
		}
		return true;

	}

}
