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

        ArrayList<BigInteger> SphenicNumbers = new ArrayList<>();


        for(;rangeFrom.compareTo(rangeTo)<=0; rangeFrom = rangeFrom.add(BigInteger.ONE))
        {
            BigInteger temp = new BigInteger("1");
            for (BigInteger i = new BigInteger("2"); i.compareTo(rangeFrom)<=0 ; i = i.add(BigInteger.ONE)) {
                temp = temp.multiply(i);
            }
            if (checkPrime(temp.add(BigInteger.ONE))|| checkPrime(temp.subtract(BigInteger.ONE)))
            {
                System.out.println(rangeFrom);
                SphenicNumbers.add(rangeFrom);
            }

        }

        return null;
    }


    //gibt naechste Zahl zurueck welche eine Primzahl ist
    private BigInteger getNextPrime(BigInteger number){
        if(number.mod(BigInteger.TWO).equals(BigInteger.ZERO)) number = number.subtract(BigInteger.ONE);
        do{
            number = number.add(BigInteger.TWO);
        }while(!checkPrime(number));

        return number;
    }

    //sucht die Distincten Primzahlen und gibt diese zurueck
    private ArrayList<Integer> getDistinctPrimes(BigInteger number){
        ArrayList<Integer> distinctPrimes = new ArrayList<>();
        BigInteger count = new BigInteger("2");

        while (!number.equals(BigInteger.ONE)){
            if(number.mod(count).equals(BigInteger.ZERO)){
                number = number.divide(count);
                if(!distinctPrimes.contains(count.intValue())) distinctPrimes.add(count.intValue());

                continue;
            }

            count = getNextPrime(count);

        }

        return distinctPrimes;
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