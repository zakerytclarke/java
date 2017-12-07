/**
 * Markov
 * @author Zakery Clarke
 * @class CS-251-002
 * @date 11/7/17
 */
import java.util.*;
import java.io.*;
import java.nio.file.*;

/**
 * Program that creates gibberish from Markov Chains
 * 
 */
public class Markov {
    
    /** Reg expr for words*/
    private static final String WORD_REGEX = "(?<=\\b\\s)";
    
    /** Reg expr for char*/
    private static final String CHAR_REGEX = "(?<=.)";
    
    private static final Random random = new Random();

    /**
     *
     * @param args order, number of times to iterate, word/char, inpout file
     */
    public static void main(String[] args) {
        
        //Parse the arguments
        int order = Integer.parseInt(args[0]);
        int count = Integer.parseInt(args[1]);
        String regex = CHAR_REGEX;
        if(args[2].equalsIgnoreCase("word")){
            regex = WORD_REGEX;
        }
        
        StringChain stringChain = new StringChain(order);
        
        for(int i = 3; i < args.length; ++i){
            String file = args[i];
            addFile(stringChain, regex, Paths.get(file));
        }
        
        for(String ms:stringChain.generate(count, random)){
            System.out.print(ms);
        }
        System.out.println();

    }
    
    /**
     * 
     * @param mc the Markov Chain
     * @param regex Regular expression for splitting input text
     * @param file Path to the text input
     */
    private static void addFile(StringChain mc, String regex, Path file){
        try{
            @SuppressWarnings("resource")
            Iterator<String> input = new Scanner(file).useDelimiter(regex);
            mc.addItems(input);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

}
