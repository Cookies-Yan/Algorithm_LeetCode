package leetCode.math_03;

public class E_415_AddStrings {
    public static String addStrings(String nums1, String nums2){

        int i = nums1.length() - 1;
        int j = nums2.length() - 1;
        int carry = 0;
        String res = "";
        while(i >= 0 || j >= 0){
            if(i >= 0){
                carry += nums1.charAt(i--) - '0';
            }
            if(j >= 0){
                carry += nums2.charAt(j--) - '0';
            }
            res = Integer.toString(carry % 10) + res;
            carry /= 10;
        }
        return carry != 0 ? "1" + res : res;
    }

    /**
     * 相似方法; 更快
     * Time O(m + n)
     * Space O(n)
     * @param
     */
    public String addStrings2(String num1, String num2) {

        StringBuilder sb = new StringBuilder();
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int remainder = 0;
        while (i >= 0 || j >= 0) {
            int sum = remainder;
            if (i >= 0) sum += num1.charAt(i--) - '0';
            if (j >= 0) sum += num2.charAt(j--) - '0';
            sb.append(sum % 10);
            remainder = sum / 10;
        }
        if (remainder != 0) {
            sb.append(remainder);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String nums1 = "1234";
        String nums2 = "1289";
        System.out.println(addStrings(nums1, nums2));
        String a = "0";
        String b = "1";
        char h = '0';
        char y = '1';
        int c = 1;
        int d = 2;
        String e = a + c;
        int f = h + y;
    }

}


