import java.math.BigInteger;
import java.util.ArrayList;

public class SphenicNumber {

    // static instance

    private static SphenicNumber instance = new SphenicNumber();

    public static SphenicNumber getInstance() {
        return instance;
    }

    // define port

    public Port port;

    private SphenicNumber() {
        port = new Port();
    }

    private ArrayList<BigInteger> calculateSphenicNumber(BigInteger rangeFrom, BigInteger rangeTo)
    {



        return null;
    }


    private boolean checkPrime(BigInteger number){
        //check via BigInteger.isProbablePrime(certainty)
        if (!number.isProbablePrime(5))
            return false;

        //check if even
        BigInteger two = new BigInteger("2");
        if (!two.equals(number) && BigInteger.ZERO.equals(number.mod(two)))
            return false;

        //find divisor if any from 3 to 'number'
        for (BigInteger i = new BigInteger("3"); i.multiply(i).compareTo(number) < 1; i = i.add(two)) { //start from 3, 5, etc. the odd number, and look for a divisor if any
            if (BigInteger.ZERO.equals(number.mod(i))) //check if 'i' is divisor of 'number'
                return false;
        }
        return true;
    }

    public class Port implements ISphenicNumber {


        @Override
        public ArrayList<BigInteger> execute(BigInteger rangeFrom, BigInteger rangeTo) {

            ArrayList<BigInteger> SphenicNumber = new ArrayList<>();
            //System.out.println("execute methode");
            return calculateSphenicNumber(rangeFrom, rangeTo);
        }
    }
}