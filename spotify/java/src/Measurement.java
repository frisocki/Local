import java.util.HashMap;
import java.util.ArrayList;

/**
 *
 * @author jdurkee
 */
public class Measurement {
    public static void main(String[] argv) {
        Kattio io = new Kattio(System.in, System.out);
        
        HashMap<String, Integer> positions = new HashMap<String, Integer>();
        positions.put("thou", 0);
        positions.put("th", 0);
        positions.put("inch", 1);
        positions.put("in", 1);
        positions.put("foot", 2);
        positions.put("ft", 2);
        positions.put("yard", 3);
        positions.put("yd", 3);
        positions.put("chain", 4);
        positions.put("ch", 4);
        positions.put("furlong", 5);
        positions.put("fur", 5);
        positions.put("mile", 6);
        positions.put("mi", 6);
        positions.put("league", 7);
        positions.put("lea", 7);
        
        //ArrayList<Integer> values = new ArrayList<Integer>();
        //values.add(0);
        //values.add(1000);
        //values.add(12);
        //values.add(3);
        //values.add(22);
        //values.add(10);
        //values.add(8);
        //values.add(3);
        
        double[] conversion = {0, 1000, 12, 3, 22, 10, 8, 3};
        
        double value = io.getDouble();
        int fromPos = positions.get(io.getWord());
        io.getWord();
        int toPos   = positions.get(io.getWord());
        
        //System.err.println("From Pos: " + fromPos);
        //System.err.println("To Pos: " + toPos);
        int distance = fromPos - toPos;
        //System.err.println("Distance: " + distance);
        if (distance > 0) {
            for(int i=0; i < Math.abs(distance); i++) {
                //value *= values.get(fromPos - i);
                value *= conversion[fromPos - i];
            }
        }
        else if(distance < 0) {
            for(int i=1; i <= Math.abs(distance); i++) {
                //System.err.println("Value S: " + value);
                //System.err.println("Factor: " + conversion[fromPos + i]);
                //value /= values.get(fromPos + i);
                
                value /= conversion[fromPos + i];
                //System.err.println("Value E: " + value);
                //System.err.println(conversion[fromPos + i]);
            }
        }
        
        io.println(value); 
        
        io.close();
    }
}