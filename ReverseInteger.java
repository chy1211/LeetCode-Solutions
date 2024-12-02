public class ReverseInteger {
    public int reverse(int x) {
        int reversed = 0;
        while (x != 0) {
            int pop = x % 10;
            x = x / 10;
            // int 的最大值為 2147483647，最小值為 -2147483648
            // 如果 reversed > Integer.MAX_VALUE/10，那麼 reversed * 10 + pop 會溢位
            // 如果 reversed == Integer.MAX_VALUE/10 且 pop > 7，那麼 reversed * 10 + pop 會溢位
            if (reversed > Integer.MAX_VALUE/10 || (reversed == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            // 如果 reversed < Integer.MIN_VALUE/10，那麼 reversed * 10 + pop 會溢位
            // 如果 reversed == Integer.MIN_VALUE/10 且 pop < -8，那麼 reversed * 10 + pop 會溢位
            if (reversed < Integer.MIN_VALUE/10 || (reversed == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            reversed = reversed * 10 + pop;
        }
        return reversed;
    }
    public static void main(String[] args){
        ReverseInteger solution = new ReverseInteger();
        int x = 123;
        System.out.println(solution.reverse(x));
    }
}
