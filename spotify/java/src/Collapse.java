import java.util.HashMap;
import java.util.ArrayList;

/**
 *
 * @author jdurkee
 */
public class Collapse {
    public static void main(String[] argv) {
        Kattio io = new Kattio(System.in, System.out);
        
        int islands = io.getInt();
        io.getInt();
        io.getInt();
        
        ArrayList<HashMap<Integer, Integer>> is = new ArrayList<HashMap<Integer, Integer>>();
        
        ArrayList<ArrayList<Integer>> cross = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> total = new ArrayList<Integer>();
               
        for (int i = 2; i <= islands; i++) {
            int t       = io.getInt();
            int sources = io.getInt();
            
            HashMap<Integer, Integer> h = new HashMap<Integer, Integer>();
            int amount = 0;
            for (int j = 0; j < sources; j++) {
                int isle   = io.getInt();
                
                if (isle != 1) {
                    amount += io.getInt();
                }
                
                ArrayList<Integer> a = cross.get(isle);
                if (a == null) {
                    a = new ArrayList<Integer>();
                }
                a.add(i);
                
                //h.put(isle, amount);     
            }
            total.add(i, amount);
            
            //is.add(h);
        }
        
        io.close();
    }
}

