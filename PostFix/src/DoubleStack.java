/**
 * Postfix Calculator Lab
 * @author Zakery Clarke
 * @class CS-251-002
 * @date 10/4/17
 */
import java.util.*;
public class DoubleStack implements Stack<Double> {
    Deque<Double> stack=new LinkedList<Double>();
    /**
     * @return if the stack is empty or not
     */
    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return stack.isEmpty();
    }
    /**
     * Pushes a value onto the stack
     */
    @Override
    public void push(Double val) {
        stack.push(val);     
    }
    /**
     *@return value popped off the stack
     */
    @Override
    public Double pop() {
        // TODO Auto-generated method stub
        return stack.pop();
    }
    /**
     * @return value on the stack still
     */
    @Override
    public Double peek() {
        return stack.peek();
    }
}
