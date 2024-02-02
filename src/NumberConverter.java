import java.util.Arrays;

public class NumberConverter {
    int[] digits; //an array containing numbers that represent an index of it's corresponding value in the values array
    int base;
    String[] values = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "+", "/"};

    public NumberConverter(String number, int base) {
        digits = new int[number.length()];
        String[] tempArr = number.split("");
        for (int i = 0; i < tempArr.length; i++){
            for (int j = 0; j < values.length; j++){
                if (tempArr[i].equals(values[j])){
                    digits[i] = j;
                }
            }
        }
        this.base = base;
    }

    public int[] numToArr(String numberAsString){
        int[] arr = new int[numberAsString.length()];
        for (int i = 0; i < numberAsString.length(); i++) {
            arr[i] = Integer.parseInt(numberAsString.substring(i,i+1));
        }
        return arr;
    }

    public int arrToNum(int[] arr) {
        String o = "";
        for (int j : arr) {
            o += j;
        }
        return Integer.parseInt(o);
    }

    public String arrToStr(String[] arr) {
        String o = "";
        for (String j : arr) {
            o += j;
        }
        return o;
    }

    public boolean validBase(){
        return base > 1 && base < 65;
    }

    public boolean validDigits(){
        String[] tempValues = new String[base];
        for (int i = 0; i < tempValues.length; i++){
            tempValues[i] = values[i];
        }
        for (int digit : digits){
            boolean validDigit = false;
            for (String value : tempValues){
                if (value.equals(values[digit])){
                    validDigit = true;
                }
            }
            if (!validDigit){
                return false;
            }
        }
        return true;
    }

    public static String[] reverse(String[] numList){
        String[] newNumList = new String[numList.length];
        for (int i = 0; i < numList.length; i++){
            newNumList[i] = numList[i];
        }
        for (int i = 0; i < numList.length; i++) {
            newNumList[numList.length - 1 - i] = numList[i];
        }
        return newNumList;
    }

    public int[] convertToDecimal() {
        int decimalNum = 0;
        for (int i = 0; i < digits.length; i++){
            decimalNum += (int) (digits[i] * Math.pow(base, digits.length - 1 - i));
        }
        return numToArr(Integer.toString(decimalNum));
    }

    public String[] convertToBinary() {
        int decimalNum = arrToNum(convertToDecimal());
        String binaryNum = "";
        int remainder;
        while (decimalNum != 0){
            remainder = decimalNum % 2;
            binaryNum += remainder;
            decimalNum /= 2;
        }
        return reverse(binaryNum.split(""));
    }

    public String[] convertToOctal() {
        int decimalNum = arrToNum(convertToDecimal());
        String octalNum = "";
        int remainder;
        while (decimalNum != 0){
            remainder = decimalNum % 8;
            octalNum += remainder;
            decimalNum /= 8;
        }
        return reverse(octalNum.split(""));
    }

    public String[] convertToHex() {
        int decimalNum = arrToNum(convertToDecimal());
        String hexNum = "";
        int remainder;
        while (decimalNum != 0){
            remainder = decimalNum % 16;
            hexNum += values[remainder];
            decimalNum /= 16;
        }
        return reverse(hexNum.split(""));
    }

    public String[] convertUpTo64(int newBase){
        int decimalNum = arrToNum(convertToDecimal());
        String newNum = "";
        if (newBase == 1){
            for (int i = 0; i < decimalNum; i++){
                newNum += "1";
            }
            return reverse(newNum.split(""));
        }

        int remainder;
        while (decimalNum != 0){
            remainder = decimalNum % newBase;
            newNum += values[remainder];
            decimalNum /= newBase;
        }
        return reverse(newNum.split(""));
    }
}