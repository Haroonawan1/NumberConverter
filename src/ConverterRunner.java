import java.util.Scanner;
import java.util.Arrays;

class ConverterRunner {
    public static void main(String[] args) {
        System.out.println("Welcome to the Number Converter!");
        System.out.println("--------------------------------");
        System.out.print("Enter the base of your number (2, 8, 10, 16): ");

        Scanner s = new Scanner(System.in);
        String choice = s.nextLine();
        int base = Integer.parseInt(choice);

        System.out.print("Enter your number: ");
        String number = s.nextLine();
        int n = Integer.parseInt(number);

        s.close();
        NumberConverter nc = new NumberConverter(n, base);

        if (NumberConverter.validBase(base) && nc.validDigits()){
            int[] digits = nc.getDigits();
            System.out.println("--------------------------------");
            System.out.println("Base 16 : " + nc.arrToStr(nc.convertToHex()));
            System.out.println("Base 10 : " + nc.arrToNum(nc.convertToDecimal()));
            System.out.println("Base 8  : " + nc.arrToNum(nc.convertToOctal()));
            System.out.println("Base 2  : " + nc.arrToNum(nc.convertToBinary()));
            System.out.println("--------------------------------");

        }
        else {
            System.out.println("--------------------------------");
            System.out.println("Your input was not valid!");
        }
    }
}

