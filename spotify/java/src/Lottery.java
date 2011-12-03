import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;

public class Lottery {
    public static void main(String[] argv) {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            String s          = in.readLine();

            // Split into the 4 parts.
            String[] parts = s.split("\\s");
            int[] iParts   = new int[parts.length];
            
            int i = 0;
            for (String p : parts) {
                iParts[i++] = Integer.parseInt(p);
            }
            
            int people  = iParts[0];
            int winners = iParts[1];
            //System.out.println("winners: " + winners);
            //System.out.println("people: " + people);
            
            //int tickets = iParts[2];
            int group   = iParts[3];
            //System.out.println("group[r]: " + group);
            
            int nonWinners = people - winners;

            if (nonWinners > 0) {
                nonWinners = nonWinners + (winners - group);
                //System.out.println("Non-winners: " + nonWinners);
            }
            
            //System.out.println(nonWinners + " choose " + winners);
            BigDecimal nwp = new BigDecimal(binomial(nonWinners, winners).doubleValue());
            nwp.setScale(9);
            //System.out.println("Non-winner prob: " + nwp);
            
            //System.out.println(people + " choose " + winners);
            BigDecimal tp  = new BigDecimal(binomial(people, winners).doubleValue());
            tp.setScale(9);
            //System.out.println("total prob: " + tp);
            
            //System.out.println(nwp / tp);
            
            BigDecimal probability = BigDecimal.ONE.subtract(nwp.divide(tp));
            System.out.println(String.format("%.10f", probability));
            
        } catch (IOException ex) {
            //Logger.getLogger(BestBefore.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    static BigInteger binomial(final int N, final int K) {
        BigInteger ret = BigInteger.ONE;
        for (int k = 0; k < K; k++) {
            ret = ret.multiply(BigInteger.valueOf(N-k))
                     .divide(BigInteger.valueOf(k+1));
        }
        return ret;
    }
}