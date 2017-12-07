/** Code to test various dessert classes */
public class DessertTest {
    public static void main(String[] args) {
        System.out.println("Let's play with desserts!");

        Candy candy = new Candy("Gummy Worms", 1.33, 0.89);
        double candyWeight = candy.getWeightInPounds();
        double candyPrice = candy.getPricePerPound();
        System.out.println(candyWeight + " pounds of " + candy.getName() +
                           " at $" + candyPrice + "/lb");
        
        
        Cookie cookie = new Cookie("Oatmeal Raisin Cookies", 4, 3.99);
        int cookieCount = cookie.getItemCount();
        double cookiePrice = cookie.getPricePerDozen();
        System.out.println(cookieCount + " " + cookie.getName() +
                           " at $" + cookiePrice + "/dozen");
        
        IceCream iceCream = new IceCream("Vanilla Ice Cream", 1.05);
        Candy topping = new Candy("Chocolate Sprinkles", 0.1, 2.49);
        Sundae candySundae = new Sundae(iceCream, topping);
        String sundaeName = candySundae.getName();
        System.out.println(sundaeName);
        
        Sundae cookieSundae = new Sundae(new IceCream("Strawberry Ice Cream", 1.25),
                                         new Cookie("Oreos", 5, 3.49));
        System.out.println(cookieSundae.getName());

        // A sundae can be topped with any dessert, even another sundae!
        Sundae sundaeSundae = new Sundae(iceCream, cookieSundae);
        System.out.println(sundaeSundae.getName());

        // Since a sundae is a kind of ice cream, we can base a sundae on another sundae.
        Sundae anotherSundae = new Sundae(candySundae, candy);
        System.out.println(anotherSundae.getName());
                
        System.out.println();

        System.out.println("Put some desserts into an array and loop over them");
        Dessert[] desserts = new Dessert[] {
            candy, cookie, iceCream, topping,
            candySundae, cookieSundae, sundaeSundae, anotherSundae,
            new Candy("Peanut Butter Fudge", 2.25, 3.99),
            new Cookie("Chocolate Chip Cookies", 3, 4.99),
            new Candy("Candy Corn",3.0, 1.09)
        };

        for(Dessert d : desserts) {
            String name = d.getName();
            double cost = d.getCost();
            System.out.printf("%s will cost $%.2f%n", name, cost);
        }
    }
}
        