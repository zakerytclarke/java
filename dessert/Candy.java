/**
 * @author Zakery Clarke
 * CS251-002
 * 9/18/2017
 * Class that defines the Candy Object
 */
public class Candy extends Dessert {
	private double candyweight;
	private double candypriceperpound;
	/**
	 * The Constructor for the Candy Class
	 * @param name the name of the candy
	 * @param weight the weight of the candy
	 * @param priceperpound the price per pound for the cookie
	 */
	Candy(String name, double weight, double priceperpound) {
		super(name);
		candyweight=weight;
		candypriceperpound=priceperpound;
	}
	/**
	 * @return the weight of the candy
	 */
	public double getWeightInPounds(){
		return candyweight;
	}
	/**
	 * @return the price per pound for the candy
	 */
	public double getPricePerPound(){
		return candypriceperpound;
	}
	/**
	 * @return the cost for the candy
	 */
	@Override
	public double getCost() {
		return candyweight*candypriceperpound;
	}
}