import java.util.ArrayList;
import java.util.TreeMap;
import java.io.IOException;
import java.io.BufferedReader;

/**
 *
 * @author jdurkee
 */
public class Dream {
    static TreeMap<String, Integer> eventName;
    static TreeMap<Integer, String> eventPosition;
    
    public static void main(String[] argv) {
        Kattio io = new Kattio(System.in, System.out);
        
        eventPosition = new TreeMap<Integer, String>();
        eventName     = new TreeMap<String, Integer>();
        BufferedReader rr = io.getR();

        try {
            // Get the number lines.
            rr.readLine();
            
            int ch;
            //System.err.println("[char] " + ch);
            while ((ch = rr.read()) != -1) {  
                if (ch == 69) {
                    // Read a space character.
                    rr.read();

                    String name = rr.readLine();
                
                    int s = eventPosition.size();
                    eventName.put(name, s);
                    eventPosition.put(s, name);
                }
                else if (ch == 68) {
                    // Read a space character.
                    rr.read();
                    
                    int dream = Integer.parseInt(rr.readLine());
                    
                    int c = eventPosition.size();

                    eventPosition.subMap(c - dream, c).clear();
                }
                else if (ch == 83) {
                    rr.read();

    
    //public static String feasible(String[] scenes) {
        /*System.err.println("\nFeasible...\n");
        int z = 0;
        for (Map.Entry e : eventPosition.entrySet()) {
           System.err.println(++z + " " + e.getKey() + " " + e.getValue());
        }*/
        
                    ArrayList<Integer> didHappens    = new ArrayList<Integer>();
        
                    boolean error = false;
        
                    int minDidNotHappen = -1;
        
                    String[] events = rr.readLine().split(" ");
        
                    int s = eventPosition.size();
                    for (int k = 1; k < events.length; k++) {
                        boolean didHappen = true;

                        //String name = io.getWord();
                        String name = events[k];
                        //System.err.println("[name] " + name);
                        if (name.startsWith("!")) {
                            didHappen = false;
                            name = name.substring(1);
                        }
                        //System.err.println(name + " did" + (didHappen ? "" : " not") + " happen");

                        int position = -1;
                        try {
                            position = eventName.get(name);
                            if (!eventPosition.get(position).equals(name)) {
                                position = -1;
                            }
                        }
                        catch (NullPointerException e) {
                            position = -1;
                        }

                        // If the event happened according to the scenerio,
                        // but was not listed as an event, or it was marked
                        // as just a dream, short circuit to plot error.
                        if (didHappen) {

                            if (position == -1) {
                                error = true;
                                break;
                            }

                            didHappens.add(position);                                                                                                                                                                                                                                                                                                                                                                                                              
                        }
                        // Get the max position of the did not happen events.
                        else {

                            if (position != -1) {
                                if (minDidNotHappen == -1 || position < minDidNotHappen) {
                                    minDidNotHappen = position;
                                }
                            }
                        }
                    }

                    if (error) {
                        io.println("Plot Error");
                        continue;
                    }

                    //System.err.println("Min did not happen: " + minDidNotHappen);
                    //System.err.println("Max did not happen: " + maxDidNothappen);

                    if (minDidNotHappen > -1) {
                        for (int k = 0; k < didHappens.size(); k++) {
                            if (minDidNotHappen != -1 && didHappens.get(k) >= minDidNotHappen) {
                                error = true;
                                break;
                            }
                        }
                    }
        
                    if (error) {
                        io.println("Plot Error");
                        continue;
                    }

                    if (minDidNotHappen > -1) {
                        io.println(s - minDidNotHappen + " Just A Dream");
                        continue;
                    }
                    io.println("Yes");

                }
            }
        }
        catch (IOException e) {}

        io.close();
    }
}