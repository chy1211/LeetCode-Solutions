public class RomantoInteger {
    public int romanToInt(String s) {
        // 定義羅馬數字符號及其對應的數值
        int[] values = {1000, 500, 100, 50, 10, 5, 1};
        String[] symbols = {"M", "D", "C", "L", "X", "V", "I"};

        int result = 0;
        int prevValue = 0;

        // 循環處理輸入的羅馬數字符號
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int value = 0;

            // 獲取當前羅馬數字符號對應的數值
            for (int j = 0; j < symbols.length; j++) {
                if (symbols[j].charAt(0) == c) {
                    value = values[j];
                    break;
                }
            }

            // 如果當前數值大於前一個數值，則減去前一個數值的兩倍
            if (value > prevValue) {
                result += value - 2 * prevValue;
            } else {
                result += value;
            }

            prevValue = value;
        }

        return result;
    }
    public static void main(String[] args) {
        RomantoInteger obj = new RomantoInteger();
        System.out.println(obj.romanToInt("III"));
    }
}
