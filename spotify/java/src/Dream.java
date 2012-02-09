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
       
        int dreamOffset  = 0;
        
        for (int i = 0; i < lines; i++) {
            String type = io.getWord();
            //System.err.println("[type] " + type);
            
            if (type.equals("E")) {
                dreamOffset = 0;
                ArrayList event = new ArrayList<String>();
                
                event.add(io.getWord());
                event.add("r");
                events.add(event);
                
                eventCounter++;

                if (eventCounter > 29) {
                    events.remove(eventCounter - 30);
                }
            }
            else if (type.equals("D")) {
                int dream = io.getInt();
                
                int lastIndex = events.size() - (1 + dreamOffset);
                for (int j = dream; j > 0; j--) {
                    //System.err.println(lastIndex + " to d.");

                    if (lastIndex >= 0) {
                        ArrayList<String> event = events.get(lastIndex--);
                        event.set(1, "d");
                        dreamOffset++;
                    }
                    //lastIndex--;
                }
            }
            else if (type.contains("S")) {
                //System.err.println("Processing scenerio...");
                
                ArrayList<String> scenes = new ArrayList<String>();
                int count = io.getInt();
                for (int j = 0; j < count; j++) {
                    scenes.add(io.getWord());
                }
                
                io.println(feasible(scenes, dreamOffset));
            }
        }
        
        //for (ArrayList<String> e : events) {
        //    io.println(e.get(0) + " " + e.get(1));
        //}
        io.close();
    }
    
    public static int getPos(String name) {
        for (int i = eventCounter - 1; i >= 0; i--) {
            ArrayList<String> e = events.get(i);
            
            if (name.equals(e.get(0))) {
                return i;
            }
        }
        return -1;   
    }
    
    public static String feasible(ArrayList<String> scenes, int dream) {
        for (ArrayList<String> e : events) {
            System.err.println(e.get(0) + " " + e.get(1));
        }
        
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
                            dreamValue = position > dreamValue ? position : dreamValue;
                            //System.err.println("[dreamvalue] " + dreamValue);
                            match++;
                        }
                        else {
                            
                        }
                    }
                    else {
                        match++;
                    }
                }
            }       
        }
        
        //System.err.println("[match] " + match);
        if (match == scenes.size()) {
            if (dreamValue > -1) {
                return events.size() - (dreamValue + dream) + " Just A Dream";
            }
            else {
                return "Yes";
            }
        }
        
        return "Plot Error";
    }
}