// Samer Swedan

// Calculates the nth fibonacci number using the linear differential recursive Fib3 algorithm and writes the result to a text file.
// Also records the time taken to compute the nth fibonacci number.

import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;


public class Fib3Class {
    // initialize the array
    static int MAXFIB = 100001;
    static BigInteger[] f = new BigInteger[MAXFIB];


    /**
     *
     * @param  n the nth fibonacci number to be calculated
     * @return f[n] the nth fibonacci number
     */
    public static BigInteger Fib3(int n) {

    // set base cases
    f[0] = BigInteger.valueOf(0);
    f[1] = f[2] = BigInteger.valueOf(1);


        if(n < 3){
            return f[n];
        }


        if (f[n] != null)
            return f[n];

        int k = n % 2;

        if(k == 1){
            k = (n + 1) / 2;
        }

        else {
            k = n / 2;
        }


        f[n] = (n % 2) == 1 ? (Fib3(k).multiply(Fib3(k))

                .add(Fib3(k - 1).multiply(Fib3(k - 1))))

                : (BigInteger.valueOf(2).multiply(Fib3(k - 1)).add(Fib3(k))).multiply(Fib3(k));

        return f[n];
    }

    // calculate the nth fibonacci number and record the time taken
    // and write the result to a text file
    public static void main(String[] args) {


        try {
            FileWriter Fib3FileWriter = new FileWriter("Fib3Results.txt");

            //generate up to F(5000) Fibonacci number
            for (int n = 0; n <= 5000; n++) {
                long start = System.nanoTime();
                BigInteger Fib3result = Fib3(n);
                long end = System.nanoTime();

                Fib3FileWriter.write(n + "th Fibonacci number: " + Fib3result + "| Time taken: " +
                        (end - start) + "\n");
            }
            Fib3FileWriter.write("Calculation Finished!");
            Fib3FileWriter.close();

        } catch (IOException e){
            System.out.println("Error creating the file");
        }

    }
    }

