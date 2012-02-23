/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jdurkee
 */
public class Trollhunt {
    public static void main(String[] argv) {
        Kattio io = new Kattio(System.in, System.out);
        
        int b = io.getInt();
        int k = io.getInt();
        int g = io.getInt();
        
        int per_day = k / g;
        int days    = b / per_day;
        
        int c = 0;
        while (b > 0) {
            b -= per_day;
            
            c++;
            if (b == 1) {
                break;
            }
        }
        io.println(c);
        
        io.close();
    }
}
