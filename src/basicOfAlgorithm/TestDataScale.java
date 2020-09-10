package basicOfAlgorithm;

public class TestDataScale {

    public static void dataScale() {

        for (int i = 1; i < 11; i++) {
            //正常是10的8次方
            double num = Math.pow((double)10, (double)i);    //10,100,1000.....
            int sum = 0;

            System.out.println(num);
            long before = System.currentTimeMillis();
            for (int j = 0; j <= num; j++) {
                 sum += j;

            }
            long end = System.currentTimeMillis();

            long per = end - before;

            System.out.println("10^" + i + " : " + per);
        }
    }

    public static void main(String[] args) {

        dataScale();
    }
}
