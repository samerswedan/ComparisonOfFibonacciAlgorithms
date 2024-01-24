// Samer Swedan

// Calculates the nth fibonacci number using the iterative Fib2 algorithm and writes the result to a text file.
// Also records the time taken to compute the nth fibonacci number.
import java.io.FileWriter;
import java.io.IOException;
import  java.math.BigInteger;


public class IterativeMethod {
    private static final int MAXFIB = 5000;
    /**
     *
     * @param  n the nth fibonacci number to be calculated
     * @return n the nth fibonacci number
     */
    public static BigInteger Fib2(BigInteger n) {

        BigInteger i = BigInteger.ONE;   // int i = 1
        BigInteger j = BigInteger.ZERO;  //int j = 0

        for (int k = 1; k <= n.intValue(); k++){
            j = i.add(j);
            i = j.subtract(i);

        }
        return j;

    }

    // calculate the nth fibonacci number and record the time taken
    // and write the result to a text file
    public static void main(String[] args){
        try {
            FileWriter Fib2FileWriter = new FileWriter("IterativeMethodResults.txt");

            //generate up to F(5000) Fibonacci number
            for (int n = 0; n <= MAXFIB; n++) {
                long start = System.nanoTime();
                BigInteger Fib2result = Fib2(BigInteger.valueOf(n));
                long end = System.nanoTime();

                Fib2FileWriter.write(n + "th Fibonacci number: " + Fib2result + "| Time taken: " +
                        (end - start) + "\n");
            }
            Fib2FileWriter.write("Calculation Finished!");
            Fib2FileWriter.close();

        } catch (IOException e){
            System.out.println("Error creating the file");
        }

    }

}
