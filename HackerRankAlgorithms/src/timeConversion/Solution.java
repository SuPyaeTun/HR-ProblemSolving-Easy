package timeConversion;
import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the timeConversion function below.
     */
    static String timeConversion(String s) {

        String result = "";
        String am = "AM";
        String pm = "PM";

        String[] split = s.split(":");
        String amPm = split[2].substring(2);

        int hour = Integer.parseInt(split[0]);
        int min = Integer.parseInt(split[1]);
        int sec = Integer.parseInt(split[2].substring(0, 2));
    
        DecimalFormat ft = new DecimalFormat("00");
        
        if (amPm.equals(am)) {
            if (hour == 12) {
                hour = 00;
            }
            result = ft.format(hour) + ":" + ft.format(min) + ":" + ft.format(sec);
        } else {
            if (hour < 12) {
                hour = hour + 12;
            }
            
            result = ft.format(hour) + ":" + ft.format(min) + ":" + ft.format(sec);
        }
        return result;
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scan.nextLine();

        String result = timeConversion(s);

        bw.write(result);
        bw.newLine();

        bw.close();
    }
}
