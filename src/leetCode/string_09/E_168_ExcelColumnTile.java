package leetCode.string_09;

public class E_168_ExcelColumnTile {
    /**
     * Because we always use 'A' + n%26, 'A' is virtually stand for 1 at here, we have to deduct 1 before doing this operation.
     * eg. if n%26 == 1 now, we definitely need to append A at current iteration, however, 'A' + 1 will give us 'B',
     * so we need 'A' + 0 to get correct result.
     *
     * toString()是由stringBuilder转成string
     * @param n
     * @return
     */
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();

        while (n > 0) {
            n--;
            sb.append((char)('A' +  n % 26));
            n /= 26;
        }
        return sb.reverse().toString();
    }
}
