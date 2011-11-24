import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class BestBefore {
    public static void main(String[] argv) {
        try {
            String[] formats = {
                "yy/MM/dd",
                "yyyy/MM/dd",
                "yy/dd/MM",
                "yyyy/dd/MM",
                "MM/dd/yy",
                "MM/dd/yyyy",
                "MM/yy/dd",
                "MM/yyyy/dd",
                "dd/MM/yy",
                "dd/MM/yyyy",
                "dd/yy/MM",
                "dd/yyyy/MM",
            };
            
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            String s          = in.readLine();

            String[] parts = s.split("/");
            String ns =
                String.format("%02d", Integer.parseInt(parts[0])) + "/" +
                String.format("%02d", Integer.parseInt(parts[1])) + "/" +
                String.format("%02d", Integer.parseInt(parts[2]));
            
            Date minDate = null;
            
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
                    
                    if (year < 100) {
                        c.set(Calendar.YEAR, year + 2000);
                    }
                   
                    if (minDate == null || c.getTime().before(minDate)) {
                        minDate = c.getTime();
                    }
                }
                catch (ParseException e) {
                    //System.out.println("Not a valid date [" + s + "][" + f + "]");
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
