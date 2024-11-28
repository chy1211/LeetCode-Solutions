public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        // 步驟1:如果
        if (s == null || s.length() == 0) {
            return "";
        }

        // 步驟1:轉換輸入字串以處理偶數長度的迴文
        StringBuilder transformed = new StringBuilder();
        transformed.append('#');
        for (int i = 0; i < s.length(); i++) {
            String c = s.substring(i, i + 1);
            transformed.append(c).append('#');
        }
        String t = transformed.toString();

        // 步驟2:初始化變數
        int n = t.length();
        int[] p = new int[n]; // 用來儲存以每個字符為中心的迴文半徑
        int center = 0, right = 0; // 當前最右迴文的中心和右邊界

        int maxLen = 0; // 最長迴文的長度
        int maxCenter = 0; // 最長迴文的中心

        // 步驟3:以每個字符為中心展開迴文
        for (int i = 0; i < n; i++) {
            // 當前中心的鏡像索引
            int mirror = 2 * center - i;

            // 步驟3.1:初始化 p[i]
            if (i < right) {
                p[i] = Math.min(right - i, p[mirror]);
            }

            // 步驟3.2:嘗試展開以 `i` 為中心的迴文
            while (i + p[i] + 1 < n && i - p[i] - 1 >= 0 && 
                   t.charAt(i + p[i] + 1) == t.charAt(i - p[i] - 1)) {
                p[i]++;
            }

            // 步驟3.3:如果以 `i` 為中心的迴文超過了 `right`，更新中心和右邊界
            if (i + p[i] > right) {
                center = i;
                right = i + p[i];
            }

            // 步驟3.4:如果找到更長的迴文，更新 maxLen 和 maxCenter
            if (p[i] > maxLen) {
                maxLen = p[i];
                maxCenter = i;
            }
        }

        // 步驟4:從原始字串中提取最長迴文子字串
        int start = (maxCenter - maxLen) / 2; // 映射迴原始字串的索引
        return s.substring(start, start + maxLen);
    }
    public static void main(String[] args){
        LongestPalindromicSubstring soulution = new LongestPalindromicSubstring();
        String s = "babad";
        System.out.println(soulution.longestPalindrome(s));       
    }
}