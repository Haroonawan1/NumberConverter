import java.util.Scanner;

class ConverterRunner {
    public static void main(String[] args) {
        System.out.println("Welcome to the Number Converter!");
        System.out.println("  1. Convert a common base number into other common bases");
        System.out.println("  2. Convert a base 10 number into any base from 1 to 64");
        System.out.print("Your Choice: ");

        Scanner s = new Scanner(System.in);
        String choice = s.nextLine();

        if (choice.equals("1")){
            System.out.println("--------------------------------");
            System.out.print("Enter the base of your number (2, 8, 10, 16): ");
            int base = Integer.parseInt(s.nextLine());

            System.out.print("Enter your number: ");
            String number = s.nextLine();

            s.close();
            NumberConverter nc = new NumberConverter(number, base);

            if (nc.validBase() && nc.validDigits()){
                System.out.println("--------------------------------");
                String[] conversions = new String[4];
                conversions[0] = "Base 16 : " + nc.arrToStr(nc.convertToHex());
                conversions[1] = "Base 10 : " + nc.arrToNum(nc.convertToDecimal());
                conversions[2] = "Base 8  : " + nc.arrToStr(nc.convertToOctal());
                conversions[3] = "Base 2  : " + nc.arrToStr(nc.convertToBinary());
                for (String conversion : conversions){
                    String str = "Base " + base;
                    if (!conversion.contains(str)){
                        System.out.println(conversion);
                    }
                }
            }
            else {
                System.out.println("--------------------------------");
                System.out.println("Your input was not valid!");
            }
        }

        if (choice.equals("2")){
            System.out.println("--------------------------------");
            System.out.print("Enter your base 10 number: ");
            String decimalNum = s.nextLine();
            System.out.print("Enter the base you want to convert to: ");
            int base = Integer.parseInt(s.nextLine());

            NumberConverter nc = new NumberConverter(decimalNum, 10);
            if (nc.validBase() && nc.validDigits()){
                System.out.println("--------------------------------");
                System.out.println("Base " + base + " : " + nc.arrToStr(nc.convertUpTo64(base)));
            }
            else {
                System.out.println("--------------------------------");
                System.out.println("Your input was not valid!");
            }
        }
    }
}

