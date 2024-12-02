public class StringtoIntegerATOI {
    public int myAtoi(String s) {
        // 步驟0:初始化變數
        int sign = 1;
        int index = 0;
        int result = 0;

        // 步驟1:去除前導空格
        s = s.trim();

        // 步驟2:處理空字符串
        if (s.length() == 0) {
            return 0;
        }

        // 步驟3:處理正負號
        if (s.charAt(index) == '+' || s.charAt(index) == '-') {
            sign = s.charAt(index) == '+' ? 1 : -1;
            index++;
        }

        // 步驟4:轉換數字並避免溢位
        while (index < s.length()) {
            // 檢查字符是否為數字
            char c = s.charAt(index);
            if (c < '0' || c > '9') {
                break;
            }
            // 轉換字符為數字 (ASCII碼表) '0' -> 48, '1' -> 49, ..., '9' -> 57
            int digit = c - '0';
            // 檢查溢位
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && digit > 7)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            // 更新結果及索引
            result = result * 10 + digit;
            index++;
        }
        return sign * result;
    }
    public static void main(String[] args){
        StringtoIntegerATOI solution = new StringtoIntegerATOI();
        String s = "42";
        System.out.println(solution.myAtoi(s));
    }
}
