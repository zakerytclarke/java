/**
 * @author Zakery Clarke
 * CS251-002
 * 9/18/2017
 * Class that defines the icecream object type
 */
public class IceCream extends Dessert{
	protected String icecreamname;
	protected double icecreamcost;
	/**
	 * Constructor for the Icecream class
	 * @param name the name of the icecream
	 * @param cost the cost of the icecream
	 */
	IceCream(String name, double cost) {
		super(name);
		icecreamname=name;
		icecreamcost=cost;
	}
	/**
	 * @return the cost of the icecream
	 */
	@Override
	public double getCost() {
		return icecreamcost;
	}

}
