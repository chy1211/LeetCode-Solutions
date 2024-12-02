public class ZigzagConversion {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        // 建立每行的字符串
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        // 初始化變數
        int currentRow = 0;
        boolean goingDown = false;

        // 遍歷字串
        for (char c : s.toCharArray()) {
            rows[currentRow].append(c);
            // 判斷是否要改變方向(到達邊界)
            if (currentRow == 0 || currentRow == numRows - 1) {
                goingDown = !goingDown;
            }
            currentRow += goingDown ? 1 : -1;
        }

        // 組合答案
        StringBuilder answer = new StringBuilder();
        for (StringBuilder row : rows) {
            answer.append(row);
        }

        return answer.toString();
    }

    public static void main(String[] args) {
        ZigzagConversion solution = new ZigzagConversion();
        String s = "PAYPALISHIRING";
        int numRows = 3;
        System.out.println("read line by line: " + solution.convert(s, numRows));
    }
}