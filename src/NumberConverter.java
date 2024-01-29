public class NumberConverter {
    int[] digits;
    static int[] allowedBases;
    int base;

    public NumberConverter(int number, int base) {
        digits = numToArr(Integer.toString(number));
        this.base = base;
        allowedBases = new int[]{2, 8, 10, 16};
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

    public String arrToStr(String[] arr) {
        String o = "";
        for (String j : arr) {
            o += j;
        }
        return o;
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

    public int[] convertToBinary() {
        int decimalNum = arrToNum(convertToDecimal());
        String binaryNum = "";
        int remainder;
        while (decimalNum != 0){
            remainder = decimalNum % 2;
            binaryNum += remainder;
            decimalNum /= 2;
        }
        String[] tempArr = reverse(binaryNum.split(""));
        int[] binaryArr = new int[tempArr.length];
        for (int i = 0; i < binaryArr.length; i++){
            binaryArr[i] = Integer.parseInt(tempArr[i]);
        }
        return binaryArr;
    }

    public int[] convertToOctal() {
        int decimalNum = arrToNum(convertToDecimal());
        String octalNum = "";
        int remainder;
        while (decimalNum != 0){
            remainder = decimalNum % 8;
            octalNum += remainder;
            decimalNum /= 8;
        }
        String[] tempArr = reverse(octalNum.split(""));
        int[] octalArr = new int[tempArr.length];
        for (int i = 0; i < octalArr.length; i++){
            octalArr[i] = Integer.parseInt(tempArr[i]);
        }
        return octalArr;
    }

    public String[] convertToHex() {
        int decimalNum = arrToNum(convertToDecimal());
        String[] values = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};
        String hexNum = "";
        int remainder;
        while (decimalNum != 0){
            remainder = decimalNum % 16;
            hexNum += values[remainder];
            decimalNum /= 16;
        }
        String[] hexArr = hexNum.split("");
        return reverse(hexArr);
    }
}