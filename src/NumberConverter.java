public class NumberConverter {
    int[] digits;
    static int[] allowedBases;
    int base;

    public NumberConverter(int number, int base) {
        digits = numToArr(Integer.toString(number));
        this.base = base;
        allowedBases = new int[]{2, 8, 10};
    }

    public int[] numToArr(String numberAsString){
        int[] arr = new int[numberAsString.length()];
        for (int i = 0; i < numberAsString.length(); i++) {
            String single = numberAsString.substring(i,i+1);
            int d = Integer.parseInt(single);
            arr[i] = d;
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

    public int[] getDigits() {
        return digits;
    }

    public static boolean validBase(int input){
        for (int base : allowedBases){
            if (base == input){
                return true;
            }
        }
        return false;
    }

    public boolean validDigits(){
        for (int digit : digits){
            if(digit > base - 1){
                return false;
            }
        }
        return true;
    }

    public int[] convertToDecimal() {
        int decimalNum = 0;
        for (int i = 0; i < digits.length; i++){
            decimalNum += (int) (digits[i] * Math.pow(base, digits.length - 1 - i));
        }
        return numToArr(Integer.toString(decimalNum));
    }

    public int[] convertToBinary() {
        int decimalNum = arrToNum(convertToDecimal());
        String binaryNum = "";
        while (decimalNum != 0){
            int i = decimalNum;
            while (decimalNum < Math.pow(2, i)){
                i--;
            }
            binaryNum =
        }
    }

    public int[] convertToOctal() {
        return null;
    }
}

