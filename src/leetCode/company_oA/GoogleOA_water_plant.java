package leetCode.company_oA;

public class GoogleOA_water_plant {

    public static int solution(int[] plants, int capacity1, int capacity2) {

        int res = 0;
        int n = plants.length;

        if (plants == null || n == 0) return 0;
        if (n == 1) return 1;
        if (n > 1) res = 2;

        int rest1 = capacity1;
        int rest2 = capacity2;
        int head = 0;
        int tail = n - 1;

        while (head < tail) {


            if(rest1 < plants[head]) {
                rest1 = capacity1;
                res += 1;
            }

            if(rest2 < plants[tail]) {
                rest2 = capacity2;
                res += 1;
            }

            rest1 -= plants[head++];
            rest2 -= plants[tail--];

            if (head == tail){

                if(rest1 + rest2 < plants[head]) {
                    return res++;

                } else {
                    return res;
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {

        int[] plants = new int[]{2, 4, 5, 1, 2};
        int res = solution(plants, 5, 7);
        System.out.println(res);


    }

}