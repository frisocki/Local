/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.TreeSet;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
     
/**
 *
 * @author jdurkee
 */
public class Memory {
    static Kattio io = new Kattio(System.in, System.out);
    static TreeSet<String> l = new TreeSet<String>(); 
    
    static Pattern p   = Pattern.compile("(10|20)");
    static Pattern p10 = Pattern.compile("(10)");
    static Pattern p20 = Pattern.compile("(20)");
    
     public static void main(String[] argv) {
         
        String s = io.getWord();
        char[] ch = s.toCharArray();

        Matcher m = p.matcher(s);
        int j = 0;
                int c10 = 0;
                        int c20 = 0;
                        io.println(s);
        while (s.matches(".*(10|20).*")) {
            
        Matcher m10 = p10.matcher(s);
        int i = 0;

        
        while (m10.find(i)) {
            i = m10.end();
            int start = m10.start();
            
            if (ch[start] == '1' && ch[start+1] == '0') {
                ch[start] = '0';
                ch[start+1] = '2';
            }
            
            c10++;
         }
        io.println(ch);
        //io.println(c10);
        //io.println(c);
        
        Matcher m20 = p20.matcher(new String(ch));
        i = 0;
        while (m20.find(i)) {
            i = m20.end();
            int start = m20.start();
            
            if (ch[start] == '2' && ch[start+1] == '0') {
                ch[start] = '1';
                ch[start+1] = '2';
            }
            
            c20++;
         }
        io.println(ch);
        //io.println(c);
        
        s = new String(ch);
        }
        io.println(c10);
        io.println(c20);
        
        //f(s);
        
        /*
        //while (s.matches(".*(10|20).*")) {
            for (int i = 0; i < s.length() - 1; i++) {
            
                String c = Character.toString(ar[i]) + Character.toString(ar[i+1]);

                TreeSet<String> t = new TreeSet<String>();
                t.add(c);
                
                if (c.equals("10")) {
                    char c1 = ar[i];
                    char c2 = ar[i+1];
                    ar[i] = '0';
                    ar[i+1] = '2';
                    
                    //t.add("02");
                    //a.add(new String(ar));
                    //ar[i] = c1;
                    //ar[i+1] = c2;
                }
                else if (c.equals("20")) {
                    char c1 = ar[i];
                    char c2 = ar[i+1];
                    ar[i] = '1';
                    ar[i+1] = '2';
                   
                    //t.add("12");
                    //a.add(new String(ar));
                    //ar[i] = c1;
                    //ar[i+1] = c2;
                }
                
                p.add(i, t);
                
                //s = new String(ar);
            }
        //}
        
            io.println(p);*/
            
            
            /*for (TreeSet<String> t : p) {
                io.println(t);
                for (int i = 0; i < p.size(); i++) {
                    
                }

                //for (int i = 0; i < t.size(); i++) {
                //    for (int j = 0; j < t.size(); j++) {
                //        io.println(t.
                //    }
                //} 
            }*/
            /*
        for (String ss : a) {
            int v = 0;
            char[] c = ss.toCharArray();
            for (int i = c.length; i > 0; i--) {
                //io.println("\n*****\n");
                //io.println(Math.pow(2,c.length - i));
                double t = Integer.parseInt(Character.toString(c[i-1])) * Math.pow(2, c.length - i);
                //io.println(Integer.parseInt(Character.toString(c[i-1])));
                //io.println(t);
                v += t;
            }
            io.println(ss + " " + v);
        }
             * */
             
        io.println(l);
        io.println(l.size() % 1000000009);
        io.close();
    }
     
    public static void f(String s) {
        if (l.contains(s)) {
            return;
        }
        //io.println("\n***** " + s + " *****\n");
                
        //char[] c = s.toCharArray();
        //io.println(c);
            
        for (int i = 0; i < s.length() - 1; i++) {
            char[] c = s.toCharArray();
            //io.println(c);
        
            boolean match = false;
            if (c[i] == '1' && c[i+1] == '0') {
                c[i] = '0';
                c[i+1] = '2';
                match = true;
            }
            else if (c[i] == '2' && c[i+1] == '0') {
                c[i] = '1';
                c[i+1] = '2';
                match = true;
            }
            
        //Matcher m = p.matcher(s);
        
        //int i = 0;
        //while (m.find(i)) {
            //i = m.end();
            //int start = m.start();
            
            //io.println("start: " + m.start());
            //io.println("end: " + m.end());
            
            //c = s.toCharArray();
            //io.println(c);
            
        //if (m.matches())
            //if (m.group(1).equals("10")) {
            //    c[start]   = '0';
            //    c[start+1] = '2';
            //}
            
            //if (m.group(1).equals("20")) {
            //    c[start]   = '1';
            //    c[start+1] = '2';
            //}
            
            if (match) {
                
            //io.println(c);
            f(new String(c));
                    }

            //io.println(0 + " group: " + m.group(0));
            //io.println(1 + " group: " + m.group(1));
            //
        //for (int i = 1; i <= m.groupCount(); i++) {
        //    io.println(i + " group: " + m.group(i));
        //}
           
        }
        
        l.add(s);
    }
}

/*
 * 101010
 * 021010
 * 020210
 * 020202
 * 100202
 * 101002
 * 100210
 * 101002
 * 
 * AAA
 * AAB
 * ABA
 * ABB
 * BAA
 * BBA
 * BAB
 * BBB
 * 
 * AA
 * AB
 * BA
 * BB

 * 
 * 1+2
1002
0210
0202 

0122
// 1 2 4 8  16
// 2 4 8 16 32
 * 
 */