package leetCode.array_04;

public class E_434_NumberOfSegmentsInAString {

    /**
     * Time O(n) trim()时间复杂度是O(n)
     * Space O(1)
     * @param s
     * @return
     */
    public int countSegments(String s) {
        s = s.trim(); //去掉前后空格
        if (s.length() == 0) return 0;
        return s.split("\\s+").length; //'s'是space '+'是一个或多个空格的分割
    }
}
