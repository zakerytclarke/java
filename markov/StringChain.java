/**
 * String Chain
 * @author Zakery Clarke
 * @class CS-251-002
 * @date 11/7/17
 */
import java.util.*;

/**
 * Object to represent Markov Chain
 */

public class StringChain {
    private final int ORDER;
    private final String NONWORD = "";
    
    /**Map of prefixes to suffixes*/
    private HashMap<Prefix, Suffix> stringChain;
    
    /**Strings from file*/
    private ArrayList<String> input = null;
    
    /**
     * Constructor for String Chain
     * @param order Markov Chain Order
     */
    public StringChain(int order){
        this.ORDER = order;
        this.stringChain = new HashMap<Prefix, Suffix>();
    }
    
    /**
     * Iterates over the input text and reads it into an array
     * @param itemIter the input text 
     */
    public void addItems(Iterator<String> itemIter){
        if(this.input == null){
            this.input = new ArrayList<String>(10);
        }
        
        for(int i = 0; i < this.ORDER; i++){
            this.input.add(0, NONWORD);
        }
        
        while(itemIter.hasNext()){
            this.input.add(itemIter.next());
        }
        for(int i = 0; i < this.ORDER; i++){
            this.input.add(NONWORD);
        }
        buildHashMap();
    }
    
    /**
     * Creates the map of prefix to suffix combinations
     */
    private void buildHashMap(){
        
        ArrayList<String> sArray;
        Prefix prefix;
        Suffix suffix;
        String keyString = "";
        
        for(int i = 0; (i+this.ORDER) < input.size(); i++){
            keyString = "";
            for(int j = i; j < (this.ORDER + i); j++){
                keyString = keyString+input.get(j);
            }
            
            prefix = new Prefix(keyString);
            
            if(stringChain.containsKey(prefix)){
                stringChain.get(prefix).addSuffix(input.get(this.ORDER + i));
            }else{
                sArray = new ArrayList<String>();
                sArray.add(input.get(this.ORDER + i));
                suffix = new Suffix(keyString, sArray);
                stringChain.put(prefix, suffix);
            }
        }
    }
    
    /**
     * The generated list created by the Markov Chain 
     * @param n the amount of words to print
     * @param random the random number generator
     * @return the list of randomly generated words
     */
    public List<String> generate(int numwords, Random random){
        
        List<String> generatedList = new ArrayList<String>();
        Prefix prefixKey;
        String keyName = "";
        
        for(int i = 0; i < this.ORDER; i++){
            keyName = keyName + NONWORD;
        }
        
        prefixKey = new Prefix(keyName);
        generatedList.add(stringChain.get(prefixKey).getSuffix(random));

        
        for(int i = 1; (i < numwords) && (i < ORDER); i++){
            keyName = "";
            for(int j = 0; j < (ORDER-i); j++){ //get rid of - i maybe
                keyName = keyName + NONWORD;
            }
            for(int k = 0; k < i; k++){
                keyName = keyName + generatedList.get(k);
            }
            prefixKey = new Prefix(keyName);
            generatedList.add(stringChain.get(prefixKey).getSuffix(random));
        }
        
        for(int i = ORDER; i < numwords; i++){
            keyName = "";
            for(int j = i-ORDER; j < i; j++){
                keyName = keyName + generatedList.get(j);
            }
            
            prefixKey = new Prefix(keyName);
            generatedList.add(stringChain.get(prefixKey).getSuffix(random));
        }
        return generatedList;
        
    }
    
    /**
     * This class is for the prefix object
     */
    private class Prefix{
        /** This is the name of the prefix*/
        private String p;
        
        /**
         * Constructs a new prefix object with name
         * @param prefix name of prefix
         */
        private Prefix(String prefix){
            this.p = prefix;
        }
        
        /**
         * equals method for prefixes within mpa
         * @param o the object 
         */
        @Override
        public boolean equals(Object o){
            if(this == o){
                return true;
            }
            if(o == null || getClass() != o.getClass()){
                return false;
            }
            
            Prefix p1 = (Prefix) o;
            
            if(!p.equals(p1.p)){
                return false;
            }else{
                return true;
            }
        }
        
        /**
         * Hashcodes for prefixes
         */
        @Override
        public int hashCode(){
            return p.hashCode();
        }
    }
    
    /**
     * Suffix Object
     */
    private class Suffix{
        private String p;//Prefix
        private ArrayList<String> sArray;//Array of suffixes
        
        /**
         * Creates a new suffix object
         * @param prefix the name of the prefix
         * @param suffixArray the array of the suffixes
         */
        private Suffix(String prefix, ArrayList<String> suffixArray){
            this.p = prefix;
            this.sArray = suffixArray;
        }
        
        /**
         * Gets a random
         * @param random the random number for the suffix
         * @return the random suffix
         */
        public String getSuffix(Random random){
            return sArray.get(random.nextInt(sArray.size()));
        }
        
        /**
         * This method is to add a new prefix for the suffix array
         * @param prefix to be added to the suffix array
         */
        public void addSuffix(String prefix){
            this.sArray.add(prefix);
        }
        
        /**
         * Ewuals override for suffixes
         * @param o the suffix
         */
        @Override
        public boolean equals(Object o){
            if(this == o){
                return true;
            }
            if(o == null || getClass() != o.getClass()){
                return false;
            }
            
            Suffix s1 = (Suffix) o;
            
            if(!p.equals(s1.p)){
                return false;
            }else if(!sArray.equals(s1.sArray)){
                return false;
            }else{
                return true;
            }
        }
        
        /**
         * Suffix Hashcode
         * @return the suffix hashcode
         */
        @Override
        public int hashCode(){
            return (37 * sArray.hashCode()) + p.hashCode();
        }
    }


}
