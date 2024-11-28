public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            int count = 0;
            for (int j = i; j < s.length(); j++) {
                if (s.substring(i, j).contains(s.substring(j, j + 1))) {
                    break;
                }
                count++;
            }
            if (count > max) {
                max = count;
            }
        }
        return max;
    }
    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters solution = new LongestSubstringWithoutRepeatingCharacters();
        String s = "abcabcbb";
        System.out.println("Length of longest substring without repeating characters: " + solution.lengthOfLongestSubstring(s));
    }
}
