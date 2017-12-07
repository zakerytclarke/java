/** Zakery Clarke
*   CS251-002
*   9/26/2017
*   Lab 4 Exceptions
*/ 
public class InsufficientFundsException extends Exception {
    private static final long serialVersionUID=1l;
    double globalshortfall;// the amount of money an account is short
    /**
     * Constructor that throws the exception
     * @param shortfall the amount of money the account is short by
     */
    public InsufficientFundsException (double shortfall) {
        super ("You need more money!");   //throw the exception
        globalshortfall=shortfall;
    }
    /**
     * @return the amount the account is short by
     */
    public double getShortfall() {
        return globalshortfall;
    }
    
}
