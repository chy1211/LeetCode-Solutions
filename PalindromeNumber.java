public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int reverse = 0;
        int original = x;
        while (x != 0) {
            reverse = reverse * 10 + x % 10;
            x /= 10;
        }
        return reverse == original;
    }
    public static void main(String[] args) {
        PalindromeNumber solution = new PalindromeNumber();
        int x = 121;
        System.out.println(solution.isPalindrome(x));
    }
}