package dataProvider;

import org.testng.annotations.DataProvider;

import java.util.Random;
import java.util.UUID;

public class ussdDataProvider {


    public static String getRandomDoubleBetweenRange(){

        Random rand = new Random();
        int num = rand.nextInt(900000000) + 1000000000;
        String result = Integer.toString(num);
        return result;
    }

    @DataProvider(name = "ussdBaseData", parallel = true)
    public Object[] createMD5TestData() {
        String  msisdn;
        String sessioID;
        Random r = new Random();
        Double number = Math.random() * ( 10000 - 500 );
        return new String[][] {
                {getRandomDoubleBetweenRange(), UUID.randomUUID().toString(),"1","1","*737#"},
                {getRandomDoubleBetweenRange(), UUID.randomUUID().toString(),"1","1","*737#"},
                {getRandomDoubleBetweenRange(), UUID.randomUUID().toString(),"1","1","*737#"},
                {getRandomDoubleBetweenRange(), UUID.randomUUID().toString(),"1","1","*737#"},
                {getRandomDoubleBetweenRange(), UUID.randomUUID().toString(),"1","1","*737#"},
                {getRandomDoubleBetweenRange(), UUID.randomUUID().toString(),"1","1","*737#"},
                {getRandomDoubleBetweenRange(), UUID.randomUUID().toString(),"1","1","*737#"},
                {getRandomDoubleBetweenRange(), UUID.randomUUID().toString(),"1","1","*737#"},


        };
    }
}
