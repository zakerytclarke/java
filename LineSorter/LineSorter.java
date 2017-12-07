/**
 * LineSorter
 * @author Zakery Clarke
 * @class CS-251-002
 * @date 10/25/17
 */
import java .io .*;
import java.util.*;
/**
 * Sorts the lines in the file passed in as the first argument and outputs it to the second
 *
 */
public class LineSorter implements Comparator<String>{
    public static void main ( String [] args )
            throws IOException {
        List<String> stringlist=new ArrayList<String>();
        /*
         * The list to store the lines from the file in
         */
        LineSorter linesort=new LineSorter();
        /*Creates a new linesorter
         * 
         */
        BufferedReader in = null ;
        BufferedWriter out = null ;
        try {
            in = new BufferedReader(new FileReader(args[0]));
            String line ;   
            while (( line = in. readLine ()) != null ) {
              stringlist.add(line);//adds the next line of the file into the collection
            }
            Collections.sort(stringlist,linesort);//sorts the collections
            out = new BufferedWriter (new FileWriter(args[1]));
            for(String outline : stringlist) {
                out.write(outline);//writes a line to the output file
                out.newLine();
            }
            
        } finally {
            if (in != null ) { in. close (); }
            if ( out != null ) { out. close (); }
        }
    }

    @Override
    public int compare(String o1, String o2) {
        
        return o2.length()-o1.length();//returns the length of each line
    }
}