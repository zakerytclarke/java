/**
 * @author Zakery Clarke
 * CS251-002
 * 9/18/2017
 * Class that defines the cookie object
 */
public class Cookie extends Dessert{
	private int cookienumber;
	private double cookiepriceperdozen;
	/**
	 * Constructor for Cookie
	 * @param name the name of the cookie
	 * @param number the number of cookies
	 * @param priceperdozenthe price per one dozen cookies
	 */
	Cookie(String name, int number, double priceperdozen) {
		super(name);
		cookienumber=number;
		cookiepriceperdozen=priceperdozen;
		}
	/**
	 * @return the number of cookies
	 */
	public int getItemCount(){
		return cookienumber;
	}
	/**
	 * @return the price for a dozen cookies
	 */
	public double getPricePerDozen(){
		return cookiepriceperdozen;
	}
	/**
	 * @return the cost for the number of cookies
	 */
	@Override
	public double getCost() {
		return cookiepriceperdozen/12*cookienumber;
	}
}
