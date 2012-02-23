import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Comparator;
import java.util.TreeMap;
import java.io.IOException;

/**
 *
 * @author jdurkee
 */
public class CatCoat {
    
    static char[] M_black   = {'B','-','D','-','o'};
    static char[] M_blue    = {'B','-','d','d','o'};
    static char[] M_choc    = {'b','b','D','-','o'};
    static char[] M_lilac   = {'b','b','d','d','o'};
    
    static char[] M_red   = {'-','-','D','-','O'};
    static char[] M_cream = {'-','-','d','d','O'};
    
    static char[] F_black   = {'B','-','D','-','o','o'};
    static char[] F_blue    = {'B','-','d','d','o','o'};
    static char[] F_choc    = {'b','b','D','-','o','o'};
    static char[] F_lilac   = {'b','b','d','d','o','o'};
    
    static char[] F_red   = {'-','-','D','-','O','O'};
    static char[] F_cream = {'-','-','d','d','O','O'};
    
    static char[] F_brtort = {'B','-','D','-','O','o'};
    static char[] F_bctort = {'B','-','d','d','O','o'};
    static char[] F_crtort = {'b','b','D','-','O','o'};
    static char[] F_lctort = {'b','b','d','d','O','o'};
    
    static HashMap<String, char[]> M_genes = new HashMap<String, char[]>();
    static HashMap<String, char[]> F_genes = new HashMap<String, char[]>();
    static HashMap<String, String> names   = new HashMap<String, String>();
    
    public static void main(String[] argv) {
        Kattio io = new Kattio(System.in, System.out);
        
        M_genes.put("Black", M_black);
        M_genes.put("Blue", M_blue);
        M_genes.put("Chocolate", M_choc);
        M_genes.put("Lilac", M_lilac);
        M_genes.put("Red", M_red);
        M_genes.put("Cream", M_cream);
        
        for (Entry<String, char[]> e : M_genes.entrySet()) {
            names.put(new String(e.getValue()), e.getKey());
        }
        
        F_genes.put("Black", F_black);
        F_genes.put("Blue", F_blue);
        F_genes.put("Chocolate", F_choc);
        F_genes.put("Lilac", F_lilac);
        F_genes.put("Red", F_red);
        F_genes.put("Cream", F_cream);
        F_genes.put("Black-Red Tortie", F_brtort);
        F_genes.put("Blue-Cream Tortie", F_bctort);
        F_genes.put("Chocolate-Red Tortie", F_crtort);
        F_genes.put("Lilac-Cream Tortie", F_lctort);
        
        for (Entry<String, char[]> e : F_genes.entrySet()) {
            names.put(new String(e.getValue()), e.getKey());
        }
        //System.err.println(names);
        
        String mother = "";
        String father = "";
        try {
         mother = io.getR().readLine();
         father = io.getR().readLine();
        }
        catch (IOException e) {}
        
        
        
        
        char[] f_genes = F_genes.get(mother);
        char[] m_genes = M_genes.get(father);
        
        //System.err.println("[mother] " + mother);
        //System.err.println(f_genes);
        
        //System.err.println("[father] " + father);
        //System.err.println(m_genes);
        
        HashSet<String> mom = getParent(f_genes, "mother");
        HashSet<String> dad = getParent(m_genes, "father");
        
        ArrayList<String> black  = new ArrayList<String>();
        ArrayList<String> dilute = new ArrayList<String>();
        ArrayList<String>  f_red  = new ArrayList<String>();
        ArrayList<String>  m_red  = new ArrayList<String>();
        
                
        int total = 0;
        HashMap<String, Integer> offspring = new HashMap<String, Integer>();
        for (String m : mom) {
            for (String d : dad) {
                total += mate(m, d, offspring);
            }
        }
        
        ValueComparator bvc =  new ValueComparator(offspring);
        TreeMap<String,Integer> sorted_map = new TreeMap<String, Integer>(bvc);
        sorted_map.putAll(offspring);
        
        double t = 0;
        int c = 0;
        
        for (Entry e : sorted_map.entrySet()) {
            //System.err.println("[type / size] " + e.getValue() + " / " + total);
            c += (Integer)e.getValue();
            double p = (Integer)e.getValue() / new Double(total);
            t += p;
            //System.err.println(e.getKey() + " " + p);
            io.println(e.getKey() + " " + String.format("%.9f", p));
        }
        
        io.close();
        
    }

    public static int mate(String m, String d, HashMap<String, Integer> offspring) {
        LinkedList<String> black  = new LinkedList<String>();
        LinkedList<String> dilute = new LinkedList<String>();
        LinkedList<String>  red   = new LinkedList<String>();
        //ArrayList<String>  m_red  = new ArrayList<String>();
        

        //System.err.println("[mom] " + m);
        //System.err.println("[dad] " + d);
            //int ml = m.length();
            //int dl = d.length();
                
        //System.err.println("[dad] " + d);
        for (int i = 0; i < 2; i++) {
            int msize = 1 + i;

            for (int j = 0; j < 2; j++) {
                int dsize = 1 + j;

                String mom_g = m.substring(i,msize);
                String dad_g = d.substring(j,dsize);

                black.add(mom_g + dad_g);
            }
        }

        for (int i = 2; i < 4; i++) {
            int msize = 1 + i;
            for (int j = 2; j < 4; j++) {
                int dsize = 1 + j;

                String mom_g = m.substring(i,msize);
                String dad_g = d.substring(j,dsize);

                dilute.add(mom_g + dad_g);
            }
        }

        for (int i = 4; i < 6; i++) {
            int msize = 1 + i;

            for (int j = 4; j < 5; j++) {
                int dsize = 1 + j;

                String mom_g = m.substring(i,msize);
                String dad_g = d.substring(4,5);

                red.add(mom_g + dad_g);
            }
            red.add(m.substring(i,msize));
        }
                
        //System.err.println(black);
        //System.err.println(dilute);
       
        //int s = f_red.size();
        //for (int z = 0; z < s; z++) {
        //    f_red.add( f_red.get(z) );
        //}
        //f_red.addAll(m_red);
        //System.err.println(f_red);

        //s = m_red.size();
        //for (int z = 0; z < s; z++) {
        //    m_red.add( m_red.get(z) );
        //}
        //System.err.println(m_red);
        
        
        
        int total = 0;
                for (String b : black) {
                    for (String di : dilute) {
                        for (String r : red) {
                            
                            String bg = b;
                            String dg = di;
                            String rg = r;
                            //System.err.println("[pemale key] " + bg + dg + rg);

                            if (bg.startsWith("B") || (bg.endsWith("B")))  {
                                bg = "B-";
                            }
                            if (dg.startsWith("D") || (dg.endsWith("D"))) {
                                dg = "D-";
                            
                            }
                            if ((rg.equals("oO"))) {
                                rg = "Oo";
                            }
                            if (rg.equals("OO")) {
                                bg = "--";
                            }
                            if (rg.equals("O")) {
                                bg = "--";
                                if (dg.equals("DD")) {
                                    dg = "D-";
                                }
                            }
                            
                            String key = bg + dg + rg;
                

                            String name = names.get(key);
                            //System.err.println("[female key] " + key + " " + name);
                //if (name == null) {
                //   System.err.println("[null key] " + key);
                //}
                            int cc = 0;
                            if (offspring.containsKey(name)) {
                                cc = offspring.get(name);
                            }
                            offspring.put(name, cc + 1);
                            total += 1;
                        }
                    }
                }

                return total;

    }
    
    public static HashSet<String> getParent(char[] genes, String type) {
        
        //System.err.println("\n[GENES]\n");
        //System.err.println(genes);
        
        HashSet<String> black = new HashSet<String>();
        for (int i = 0; i < 1; i++) {
            if (genes[i] == '-' || genes[i+1] == '-') {
                if (genes[i] == '-' || genes[i+1] == '-') {
                    black.add("Bb");
                    black.add("BB");
                }
                if (genes[i] == '-' && genes[i+1] == '-') {
                    black.add("bb");
                }
                //if (genes[i+1] == '-') {
                //    black.add("BB");
                //    black.add("Bb");
                //}
            }
            else {
                black.add(Character.toString(genes[i]) + Character.toString(genes[i + 1]));
            }
        }
        //System.err.println(black);
        
        HashSet<String> dilute = new HashSet<String>();
        for (int i = 2; i < 3; i++) {
            if (genes[i] == '-' || genes[i+1] == '-') {
                if (genes[i] == '-' || genes[i+1] == '-') {
                    dilute.add("Dd");
                    dilute.add("DD");
                    
                }
                if (genes[i] == '-' && genes[i+1] == '-') {
                    dilute.add("dd");
                }
                //if (genes[i+1] == '-') {
                //    dilute.add("DD");
                //    dilute.add("Dd");
                //}
            }
            else {
                dilute.add(Character.toString(genes[i]) + Character.toString(genes[i + 1]));
            }
        }
        //System.err.println(dilute);
        
        boolean f_isRed = false;
        
        HashSet<String> red = new HashSet<String>();
        if (type.equals("mother")) {
            for (int i = 4; i < 5; i++) {
                if (genes[i] == 'O' && genes[i+1] == 'O') {
                    f_isRed = true;
                }

                if (genes[i] == '-' || genes[i+1] == '-') {
                    //if (genes[i] == '-') {
                        red.add("Oo");
                        red.add("OO");
                    //}
                    if (genes[i] == '-' && genes[i+1] == '-') {
                        red.add("oo");
                    }
                    //if (genes[i+1] == '-') {
                    //    red.add("OO");
                    //    red.add("Oo");
                    //}
                }
                else {
                    red.add(Character.toString(genes[i]) + Character.toString(genes[i + 1]));
                }
            }
        }
        else {
            if (genes[4] == 'O') {
                f_isRed = true;
                red.add("O");
            }
            else {
                red.add("o");
            }
        }
        //System.err.println(red);
        
        HashSet<String> parent = new HashSet<String>();
        for (String b : black) {
            for (String d : dilute) {
                for (String r : red) {
                    if (f_isRed) {
                        //b = "--";
                    }
                    //System.err.println(b + d + r);
                    parent.add(b + d + r);
                }
            }
        }
        //System.err.println("[parent]");
        //System.err.println(parent);
        return parent;
    }
    
    
}

class ValueComparator implements Comparator {

  Map base;
  public ValueComparator(Map base) {
      this.base = base;
  }

  public int compare(Object a, Object b) {
    if ((Integer)base.get(a) < (Integer)base.get(b)) {
      return 1;
    }
    else if ( base.get(a).equals(base.get(b)) ) {
      return ((String)a).compareTo((String)b);
    }
    else {
      return -1;
    }
  }
}
