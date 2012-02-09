/**
 *
 * @author jdurkee
 */
public class Different {
    public static void main(String[] argv) {
        Kattio io = new Kattio(System.in, System.out);
        
        while(io.hasMoreTokens()) {
            io.println(Math.abs(io.getLong() - io.getLong()));
        }
        
        io.close();
    }
}
