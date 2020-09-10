package leetCode.dynamic_18;

import java.util.HashSet;
import java.util.List;

public class M_139_WordBreak {
//用BackTracking
    public boolean wordBreak1(String s, List<String> wordDict) {
        return helper(s, new HashSet<>(wordDict), 0);
    }
    //这里用list，搜索复杂度是O（n）， HashSet是O（1）
    private boolean helper(String s, HashSet<String> wordDict, int index) {
        if(index == s.length()) {
            return true;
        }

        for (int i = index + 1; i <= s.length(); i++){
            if(wordDict.contains(s.substring(index, i)) && helper(s, wordDict, i)) {
                return true;
            }
        }

        return false;
    }
//优化 记忆化搜索 解法

    public boolean wordBreak2(String s, List<String> wordDict) {
        return helper(s, new HashSet<>(wordDict), 0, new Boolean[s.length()]);
    }
    //这里用list，搜索复杂度是O（n）， HashSet是O（1）

    /**
     * 初始化Boolean对象形式 全都是null, boolean初始化都是false;
     * @param s
     * @param wordDict
     * @param index
     * @param memo
     * @return
     */
    private boolean helper(String s, HashSet<String> wordDict, int index, Boolean[] memo) {
        if(index == s.length()) {
            return true;
        }
        if(memo[index] != null){
            return memo[index];
        }

        for (int i = index + 1; i <= s.length(); i++){
            if(wordDict.contains(s.substring(index, i)) && helper(s, wordDict, i, memo)) {
                memo[index] = true;
                return true;
            }
        }
        memo[index] = false;
        return false;
    }
//  DP解法
    public boolean wordBreak3(String s, List<String> wordDict) {
        /**
         * 初始化全是false;
         */
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for(int i = 1; i <= s.length(); i++) {
            for(int j = 0; j < i; j++){
                if(dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
    public static void main(String[] args) {

    }

}
