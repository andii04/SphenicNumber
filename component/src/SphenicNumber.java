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

        /*
        ArrayList<BigInteger> EvilNumbers = new ArrayList<>();


        for(;rangeFrom.compareTo(rangeTo)<=0; rangeFrom = rangeFrom.add(BigInteger.ONE))
        {

            //if(rangeFrom.mod(BigInteger.TWO) != BigInteger.ZERO)
            //{
            BigInteger count = new BigInteger("0");
            String s = rangeFrom.toString(2);
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i)=='1') {
                    count = count.add(BigInteger.ONE);

                }

            }
            if(count.mod(BigInteger.TWO) == BigInteger.ZERO)
            {
                EvilNumbers.add(rangeFrom);
                System.out.println(rangeFrom);
            }


            // }


        }
        */
        return null;
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