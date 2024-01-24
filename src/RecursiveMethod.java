// Samer Swedan

// Calculates the nth fibonacci number using the recursive Fib1 algorithm and writes the result to a text file.
// Also records the time taken to compute the nth fibonacci number.
import java.io.IOException;
import  java.math.BigInteger;
import java.io.FileWriter;

public class RecursiveMethod {
    private static final int MAXFIB = 20;

    /**
     *
     * @param  n the nth fibonacci number to be calculated
     * @return n the nth fibonacci number
     */
   public static BigInteger Fib1(BigInteger n) {

       // if n < 2 then return n
      int compare = n.compareTo(BigInteger.TWO);
        if (compare < 0) {
            return n;
        }
        // otherwise calculate Fib1(n-1) + Fib1(n-2)
        else {
            return Fib1(n.subtract(BigInteger.ONE)).add(Fib1(n.subtract(BigInteger.TWO)) );
        }

    }
    // calculate the nth fibonacci number and record the time taken
    // and write the result to a text file
    public static void main(String[] args){
       try {
    FileWriter Fib1FileWriter = new FileWriter("RecursiveMethodResults.txt");

       
           //generate up to  F(54) Fibonacci number
        for (int n = 0; n <= MAXFIB; n++) {
            long start = System.nanoTime();
            BigInteger Fib1result = Fib1(BigInteger.valueOf(n));
            long end = System.nanoTime();

            Fib1FileWriter.write(n + "th Fibonacci number: " + Fib1result + "| Time taken: " +
                    (end - start) + "\n");
        }
           Fib1FileWriter.write("Calculation Finished!");
        Fib1FileWriter.close();

        } catch (IOException e){
            System.out.println("Error creating the file");
           }

        }
    }





