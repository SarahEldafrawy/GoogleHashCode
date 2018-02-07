package pizza;

public class PizzaStructure {
	private char[][] pizza;
	private int minOfAnyIngredient;
	private int maxNumOfCells;
	private int totalTomatoesInPizza;
	private int totalMashrumInPizza;
	//TODO set a map O(1)[access and removing] points of for all cells to remove visited ones 
	public PizzaStructure (char[][] pizza) {
		this.pizza = pizza;
	}

	public char[][] getPizza() {
		return pizza;
	}

	public int getMinOfAnyIngredient() {
		return minOfAnyIngredient;
	}

	public void setMinOfAnyIngredient(int minOfAnyIngredient) {
		this.minOfAnyIngredient = minOfAnyIngredient;
	}

	public int getMaxNumOfCells() {
		return maxNumOfCells;
	}

	public void setMaxNumOfCells(int maxNumOfCells) {
		this.maxNumOfCells = maxNumOfCells;
	}

	public int getTotalTomatoesInPizza() {
		return totalTomatoesInPizza;
	}

	public void setTotalTomatoesInPizza(int totalTomatoesInPizza) {
		this.totalTomatoesInPizza = totalTomatoesInPizza;
	}

	public int getTotalMashrumInPizza() {
		return totalMashrumInPizza;
	}

	public void setTotalMashrumInPizza(int totalMashrumInPizza) {
		this.totalMashrumInPizza = totalMashrumInPizza;
	}
	

	

}
