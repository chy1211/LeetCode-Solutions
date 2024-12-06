public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        // 步驟0:初始化變數
        int sLenth = s.length();
        int pLenth = p.length();

        // 步驟1:建立 dp 陣列，dp[i][j] 表示 s 的前 i 個字符與 p 的前 j 個字符是否匹配
        boolean[][] dp = new boolean[sLenth + 1][pLenth + 1];

        // 步驟2:初始化 dp 陣列
        dp[0][0] = true;

        // 步驟3:初始化第一行，處理模式中包含 '*' 的情況
        for (int j = 1; j <= pLenth; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }

        // 步驟4:填充 dp 陣列
        for (int i = 1; i <= sLenth; i++) {
            for (int j = 1; j <= pLenth; j++) {
                // 當模式字符為 '.' 或與字串字符相同時
                if (p.charAt(j - 1) == '.' || p.charAt(j - 1) == s.charAt(i - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } 
                // 當模式字符為 '*' 時
                else if (p.charAt(j - 1) == '*') {
                    // '*' 可以匹配零個前面的元素
                    dp[i][j] = dp[i][j - 2];
                    // '*' 可以匹配一個或多個前面的元素
                    if (p.charAt(j - 2) == '.' || p.charAt(j - 2) == s.charAt(i - 1)) {
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                }
            }
        }
        return dp[sLenth][pLenth];
    }
    public static void main(String[] args) {
        RegularExpressionMatching rem = new RegularExpressionMatching();
        System.out.println(rem.isMatch("aa", "a"));
        System.out.println(rem.isMatch("aa", "a*"));
        System.out.println(rem.isMatch("ab", ".*"));
        System.out.println(rem.isMatch("aab", "c*a*b"));
        System.out.println(rem.isMatch("mississippi", "mis*is*p*."));
    }
}
