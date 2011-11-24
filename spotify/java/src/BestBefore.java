import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class BestBefore {
    public static void main(String[] argv) {
        try {

            // Date formats to try.
            ArrayList<String> formats = new ArrayList<String>();
            formats.add("yy/MM/dd");
            formats.add("yy/dd/MM");
            formats.add("MM/dd/yy");
            formats.add("MM/yy/dd");
            formats.add("dd/MM/yy");
            formats.add("dd/yy/MM");
            
            // Read the line of input.
            // Expected: n/n/n
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            String s          = in.readLine();

            // Split into the 3 parts.
            String[] parts = s.split("/");
            int[] iParts   = new int[parts.length];

            int i = 0;
            for (String p : parts) {
                iParts[i++] = Integer.parseInt(p);
            }
            
            // Add 4 digit year formats if one of the parts is 4 characters.
            if (parts[0].length() == 4) {
                formats.add("yyyy/MM/dd");
                formats.add("yyyy/dd/MM");
            }
            else if (parts[1].length() == 4) {
                formats.add("MM/yyyy/dd");
                formats.add("DD/yyyy/MM");
            }
            else if (parts[2].length() == 4) {
                formats.add("MM/dd/yyyy");
                formats.add("dd/MM/yyyy");
            }
           
            // O pad the parts to at least 2 digits to
            // allow for a year of 0.
            String ns = 
                String.format("%02d", iParts[0])  + "/" +
                String.format("%02d", iParts[1]) + "/" +
                String.format("%02d", iParts[2]);
            
            Date minDate = null;
            
            // Loop throught the formats, finding valid dates,
            // and capturing the minimum.
            Calendar c = Calendar.getInstance();
            for (String f : formats) {
                SimpleDateFormat format = new SimpleDateFormat(f);
                c.set(2000, 0, 1, 0, 0, 0);
                format.set2DigitYearStart(c.getTime());
                format.setLenient(false);
                
                try {
                    Date d = format.parse(ns);
                    
                    c.setTime(d);
                    int year = c.get(Calendar.YEAR);
                    
                    // All 2 digit dates are in the 21st century.
                    if (year < 100) {
                        c.set(Calendar.YEAR, year + 2000);
                    }
                   
                    if (minDate == null || c.getTime().before(minDate)) {
                        minDate = c.getTime();
                    }
                }
                catch (ParseException e) {
                }
            }
            
            if (minDate != null) {
                DateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
                System.out.println(fm.format(minDate));
            }
            else {
                System.out.println(s + " is illegal");
            }
    
        } catch (IOException ex) {
            //Logger.getLogger(BestBefore.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
