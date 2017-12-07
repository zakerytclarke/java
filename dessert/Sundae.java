/**
 * @author Zakery Clarke
 * CS251-002
 * 9/18/2017
 * Class that defines the Sundae object as a subset of the icecream class
 */

public class Sundae extends IceCream{
    private IceCream sundaeicecream;
	private Dessert sundaetopping;
	/**
	 * Constructor for the sundae object
	 * @param icecream the type of icecream as an object
	 * @param topping the topping as a dessert object
	 */
	Sundae(IceCream icecream, Dessert topping) {
		super(icecream.getName()+" topped with "+topping.getName(),icecream.getCost());
		sundaeicecream=icecream;
		sundaetopping=topping;
	}
	/**
	 * @return the cost of the sundae, factoring in the cost of the icecream and the cost of the topping
	 */
	@Override
	public double getCost() {
		return sundaeicecream.getCost()+sundaetopping.getCost();
	}
}
