package betweenTwoSets;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'getTotalX' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER_ARRAY b
     */

    public static int getTotalX(List<Integer> a, List<Integer> b) {
    // Write your code here
    	Collections.sort(a);
        Collections.sort(b);
        ArrayList<Integer> totalInt = new ArrayList<Integer>();
            
            
            for (int i = 0; i < a.size(); i++) {
                for (int j = 1; j <= b.get(0); j++) {
                    if (j % a.get(i) == 0) {
                        totalInt.add(j);
                    }
                }
            }
            
            LinkedHashSet<Integer> hashSet = new LinkedHashSet<>(totalInt);
            ArrayList<Integer> cleanedList = new ArrayList<>(hashSet);
            Collections.sort(cleanedList);

            for (int i = 0; i < b.size(); i++) {
                int num = b.get(i);
                for (int j = 0; j < cleanedList.size(); j++) {
                    if (num % cleanedList.get(j) != 0) {
                        cleanedList.remove(j);
                    } 
                }
            }
            
            for (int i = 0; i < a.size(); i++) {
                int num2 = a.get(i);
                for (int j = 0; j < cleanedList.size(); j++) {
                    if (cleanedList.get(j) % num2 != 0) {
                        cleanedList.remove(j);
                        --j;
                    }
                }
            }

            for (int i = 0; i < b.size(); i++) {
                for (int j = 0; j < cleanedList.size(); j++) {
                    if (b.get(i) % cleanedList.get(j) != 0) {
                        cleanedList.remove(j);
                        --j;
                    }
                }
            }
       
       
            int intsBetweenSets = cleanedList.size();
            return intsBetweenSets;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> brr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int total = Result.getTotalX(arr, brr);

        bufferedWriter.write(String.valueOf(total));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
