package dayOfTheProgrammer;

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

public class Solution {

    // Complete the dayOfProgrammer function below.
    static String dayOfProgrammer(int year) {
        String mm = "09";
        String yyyy = Integer.toString(year);
        String dd = "";
        
        if ( (1700 <= year) && (year <= 2700)) {
            // Julian Calendar
            if ((1700 <= year) && (year <= 1917)) {
                dd = "13";
                if (year % 4 == 0) {
                    dd = "12";
                }
            }

            // for 1918
            if (year == 1918) {
                dd = "26";
            }
            
            
            // Gregorian Calendar
            if ( (1919 <= year) && (year <= 2700)) {
                dd = "13";
                if (( (year % 400 == 0)|| ((year % 4 == 0) && (year % 100 != 0)))) {
                    dd = "12";
                }
            }
        }

        String output = dd + "." + mm +"."+ yyyy;
        return output;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int year = Integer.parseInt(bufferedReader.readLine().trim());

        String result = dayOfProgrammer(year);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

