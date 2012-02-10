import java.util.ArrayList;

/**
 *
 * @author jdurkee
 */
public class Dream {
    static ArrayList<ArrayList<String>> events = new ArrayList<ArrayList<String>>();
    static int eventCounter = 0;
    
    public static void main(String[] argv) {
        Kattio io = new Kattio(System.in, System.out);
        
        int lines = io.getInt();
        //System.err.println("[lines] " + lines);
       
        int dreamOffset  = 0;
        int dreamEvents  = 0;
        
        for (int i = 0; i < lines; i++) {
            String type = io.getWord();
            //System.err.println("[type] " + type);
            
            if (type.equals("E")) {
                dreamOffset = 0;
                
                ArrayList<String> event = new ArrayList<String>();
                
                event.add(io.getWord());
                event.add("r");
                events.add(event);
                
                eventCounter++;

                if (eventCounter > 40) {
                    //System.err.println("[eventCounter] " + eventCounter);
                    //System.err.println("[eventCounter - 31 " + (eventCounter - 31));
                    events.remove(0);
                }
            }
            else if (type.equals("D")) {
                int dream = io.getInt();
                
                for (int j = events.size() - 1; j >= 0; j--) {
                    
                    if (dream < 1) {
                        break;
                    }
                    
                    ArrayList<String> event = events.get(j);
                    if (event.get(1).equals("r")) {
                        event.set(1, "d");
                        dream--;
                    }
                }
                
            }
            else if (type.equals("S")) {
                //System.err.println("Processing scenerio...");
                
                ArrayList<String> scenes = new ArrayList<String>();
                int count = io.getInt();
                for (int j = 0; j < count; j++) {
                    scenes.add(io.getWord());
                }
                
                //System.err.println("[dream offset] " + dreamEvents);
                String s = feasible(scenes, dreamEvents, events.size());
                io.println(s);
                
                //io.flush();
                //System.out.println(s);
            }
        }
        
        //for (ArrayList<String> e : events) {
        //     io.println(e.get(0) + " " + e.get(1));
        //}
        io.close();
    }
    
    public static int getPos(String name) {
        for (int i = events.size() - 1; i >= 0; i--) {
            ArrayList<String> e = events.get(i);
            
            if (name.equals(e.get(0))) {
                return i;
            }
        }
        return -1;   
    }
    
    public static String feasible(ArrayList<String> scenes, int dream, int s) {
        //for (ArrayList<String> e : events) {
        //    System.err.println(e.get(0) + " " + e.get(1));
        //}
        
        int match = 0;
        
        int dreamValue = -1;
        int maxMatch   = -1;
        for (int i = 0; i < scenes.size(); i++) {
            boolean didHappen = true;
            
            String name = scenes.get(i);
            if (name.startsWith("!")) {
                didHappen = false;
                name = name.substring(1);
            }
            //System.err.println(name + " did" + (didHappen ? "" : " not") + " happen");
            
            int position = getPos(name);
            //System.err.println("[pos] " + position);
            if (didHappen) {
                if (position != -1) {
                    ArrayList event = events.get(position);
                    if (event.get(1).equals("r")) {
                       if (dreamValue == -1 || position < dreamValue) {
                           
                            maxMatch = position > maxMatch ? position : maxMatch;
                            //System.err.println("[maxmatch] " + maxMatch);
                            match++;
                        }
                    }
                }
            }
            else {
                if (position == -1) {
                    match++;
                }
                else {
                    ArrayList event = events.get(position);
                    if (event.get(1).equals("r")) {
                        if (maxMatch == -1 || position > maxMatch) {
                            //System.err.println("[position, dreamvalue] " + position + ", " + dreamValue);
                            if (dreamValue == -1) {
                                dreamValue = position;
                            }
                            else {
                                dreamValue = position < dreamValue ? position : dreamValue;
                            }
                            //dreamValue = position;
                            //System.err.println("[dreamvalue] " + dreamValue);
                            match++;
                        }
                    }
                    else {
                        match++;
                    }
                }
            }       
        }
        
        //System.err.println("[match] " + match);
        //System.err.println("[maxmatch] " + maxMatch);
        if (match == scenes.size()) {
            //System.err.println("[dreamValue] " + dreamValue);
            if (dreamValue > -1) {
                int existingDream = 0;
                for (int i = events.size() - 1; i >= dreamValue; i--) {
                    ArrayList<String> e = events.get(i);
                    if (e.get(1).equals("d")) {
                        existingDream++;
                    }
                }
                
                //System.err.println("[existingDream]" + existingDream);
                int d = s - (dreamValue + existingDream);
                return d + " Just A Dream";
            }
            else {
                return "Yes";
            }
        }
        
        return "Plot Error";
    }
}