/*	Zakery Clarke
	CS251-002
	Lab 1 Fizzbuzz
*/
public class Fizzbuzz {
	
    public static void main(String[] args) {// amount of times to iterate, number for fizz, number for buzz
	int iterations=Integer.parseInt(args[0]);
	int a=Integer.parseInt(args[1]);//fizz
	int b=Integer.parseInt(args[2]);//buzz
    	for(int i=1;i<iterations+1;i++){
		String output="";
		if(i%a==0){
		output=output+"Fizz";//tests if number is divisible by fizz and outputs if true
		}
		if(i%b==0){
		output=output+"Buzz";//tests if number is divisible by buzz and outputs if true
		}
		if(output==""){
		output=Integer.toString(i);//if not divisible by either then output the number
		}
		System.out.println(output);
	}
    }

}