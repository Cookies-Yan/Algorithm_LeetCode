package leetCode.array_04;

import java.util.List;

public class E_422_ValidWordSquare {
    /**
     * Time O(n * word.length()(max))
     * Space O(1)
     * @param words
     * @return
     */
    public boolean validWordSquare(List<String> words) {
        for (int i = 0; i < words.size(); i++) {
            for (int j = 0; j < words.get(i).length(); j++) {
                if (j >= words.size() || i >= words.get(j).length()) { // 列大于行
                    return false;
                }
                if (words.get(i).charAt(j) != words.get(j).charAt(i)) {
                    return false;
                }
            }
        }
        return true;
    }
}
