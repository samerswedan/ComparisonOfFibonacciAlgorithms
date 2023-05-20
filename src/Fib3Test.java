import java.math.BigInteger;
import java.util.Arrays;

public class Fib3Test {

    public static BigInteger Fib2(BigInteger n) {

        BigInteger i = BigInteger.ONE;
        BigInteger j = BigInteger.ZERO;

        for (int k = 1; k <= n.intValue(); k++){
            j = i.add(j);
            i = j.subtract(i);

            System.out.println("k: "+ k + " | j: " + j + " | i: " + i);

        }
        return j;


    }

    public static void main(String[] args){

        for (int n = 0; n <= 5; n++){
            //Fib2(BigInteger.valueOf(n));
            System.out.println(Fib2(BigInteger.valueOf(n)));
        }
    }
    };


