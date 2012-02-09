/**
 *
 * @author jdurkee
 */
public class Register {
    public static void main(String[] argv) {
        Kattio io = new Kattio(System.in, System.out);
        
        int[] max = {1,2,4,6,10,12,16,18};
        
        int value = 0;
        
        int[] registers = new int[8];
        for (int i=0; i<8; i++) {
            registers[i] = io.getInt();
        }
        
        outer: 
        for (int i=0; i<registers.length; ) {
            //System.err.println("[I] " + i);
            if (max[i] == registers[i]) {
                //System.err.println("[Found Max] " + i);
                for (int j=i+1; j<registers.length; j++) {
                    //System.err.println("[J] " + j);
                    //System.err.println("[J value S] " + registers[j]);
                    if (registers[j] < max[j]) {
                        registers[j]++;
                        //System.err.println("[J value E] " + registers[j]);
                        //System.err.println("[New I] " + i);
                        for (int k=j-1; k>=0; k--) {
                            registers[k] = 0;
                        }
                        //registers[j-1] = 0;
                        i = 0;
                        
                        value++;
                        //p(registers);
                        continue outer;
                    }
                }
                i++;
                continue;
            }
            //System.err.println("[Register S] " + registers[i]);
            registers[i]++;
            //System.err.println("[Register E] " + registers[i]);
            value++;
            //p(registers);
        }
        
        io.println(value);
        
        io.close();
    }
    
    public static void p(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.err.print(a[i] + " ");
        }
        System.err.println();
    }
}