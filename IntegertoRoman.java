public class IntegertoRoman {
    public String intToRoman(int num) {
        // 定義羅馬數字符號及其對應的數值
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder roman = new StringBuilder();

        // 循環處理輸入的整數
        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                num -= values[i];
                roman.append(symbols[i]);
            }
        }

        return roman.toString();
    }

    public static void main(String[] args) {
        IntegertoRoman obj = new IntegertoRoman();
        System.out.println(obj.intToRoman(3749)); // 輸出: MMMDCCXLIX
    }
}
