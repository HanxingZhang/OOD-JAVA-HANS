import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CashRegister {

    public enum Coin {

        ONE_HUNDRED("ONE HUNDRED", 100),
        FIFTY("FIFTY", 50),
        TWENTY("TWENTY", 20),
        TEN("TEN", 10),
        FIVE("FIVE", 5),
        TWO("TWO", 2),
        ONE("ONE", 1),
        HALF_DOLLAR("HALF DOLLAR", 0.5),
        QUARTER( "QUARTER", 0.25),
        DIME( "DIME", 0.10),
        NICKEL( "NICKEL", 0.05),
        PENNY("PENNY", 0.01);

        private String name;
        private double value;

        Coin(String name, double value) {
            this.name = name;
            this.value = value;
        }

        public double getValue() {
            return this.value;
        }

        @Override
        public String toString() {
            return this.name;
        }

    }

    private static String findChange(float price, float cash) {
        if(cash < price) return "ERROR";
        if(cash == price) return "ZERO";
        double change = cash - price;

        StringBuilder sb = new StringBuilder();

        for(Coin c: Coin.values()) {
            while(change >= c.getValue()) {
                change = change - c.getValue();
                sb.append(c.name).append(',');
            }
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner fileScanner = (args.length > 0) ? new Scanner(new File(args[0]))
                : new Scanner(System.in);
        List<String> tokens = new ArrayList<>();
        int line = 0;
        while (fileScanner.hasNextLine()) {
            String read = fileScanner.nextLine();
            if(read == null || read.isEmpty() || line >= 2){ //if the line is empty
                break;  //exit the loop
            }
            if(!read.equalsIgnoreCase("")){
                tokens.add(read);
                line++;
            }
        }
        fileScanner.close();
        System.out.println(tokens.get(0));
        float price = Float.parseFloat(tokens.get(0));
        float cash = Float.parseFloat(tokens.get(1));
        System.out.println(findChange(price, cash));

//        while (fileScanner .hasNextLine()) {
//            String line = fileScanner.nextLine();
//            if(!line.equalsIgnoreCase("")) {
//                String elements[] = line.split(";");
//                float price = Float.parseFloat(elements[0]);
//                float cash = Float.parseFloat(elements[1]);
//                System.out.println(findChange(price, cash));
//            }
//        }
    }

}
