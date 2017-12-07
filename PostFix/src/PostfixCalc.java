/**
 * Postfix Calculator Lab
 * @author Zakery Clarke
 * @class CS-251-002
 * @date 10/4/17
 */
import java.util.*;
public class PostfixCalc {
    private Stack<Double> doubleStack= new DoubleStack();//stack for the calculator 
    private Map<String, Operator> operatorMap=new HashMap<String,Operator>();
    /**
     * Stores double from input stream
     * @param next the number to be stored
     */
    public void storeOperand(double next) {
        doubleStack.push(next);
    }
    /**
     * Evaluates an operator from the input stream
     * @param next the operator to be evaluated
     */
    public void evalOperator(String next) {
        Operator op= operatorMap.get(next);
        List<Double> arguments = new ArrayList<Double>();
        for(int i=op.numArgs(); i>0; i--) {
            arguments.add(0,doubleStack.pop());
        }
        doubleStack.push(op.eval(arguments));
        
    }
    /**
     * BinaryOperator implementation for all operators
     * that take two arguments
     */
    private static abstract class BinaryOperators implements Operator{
        /**
         * @return the number of arguments the operation needs
         */
        public int numArgs() {
            return 2;
        }
        /**
         * @return the evaluation of the operand
         */
        public double eval(List<Double> args) {
            return evaluate(args.get(0),args.get(1));           
        }
        /**
         * 
         * @param arg1 the first argument for the operator
         * @param arg2 the second argument for the operator
         * @return the evaluated expression
         */
        public abstract double evaluate(double arg1,double arg2);
    }
    /**
     * Contains all the definitions for the Posstfix Calculator Operators
     */
    public PostfixCalc(){
        //addition
        Operator addition=new BinaryOperators() {
            public double evaluate(double arg1, double arg2) {
                return arg1+arg2;
            }
        };
        operatorMap.put("+",addition);
        operatorMap.put("add",addition);
        //subtraction
        Operator subtraction=new BinaryOperators() {
            public double evaluate(double arg1, double arg2) {
                return arg1-arg2;
            }
        };
        operatorMap.put("-", subtraction);
        operatorMap.put("sub", subtraction);
        //multiplication
        Operator multiplication=new BinaryOperators() {
            public double evaluate(double arg1, double arg2) {
                return arg1*arg2;
            }
        };
        operatorMap.put("*", multiplication);
        operatorMap.put("mul", multiplication);
        //division 
        Operator division=new BinaryOperators() {
            public double evaluate(double arg1, double arg2) {
                return arg1/arg2;
            }
        };
        operatorMap.put("/", division);
        operatorMap.put("div", division);
        //output operator
        Operator print=new Operator() {
            public int numArgs() {
                return 1;
            }
            public double eval(List<Double> args) {
                System.out.println(args.get(0));
                return args.get(0);
            
                //System.out.println(args.get(0));
                //return args.get(0);
            }
        };
        operatorMap.put("=", print);
        operatorMap.put("print", print);
       }
}
