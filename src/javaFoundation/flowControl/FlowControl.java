package javaFoundation.flowControl;

public class FlowControl {
    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        if(a == 1){
            System.out.println("1");
        } else if (a == 2){
            System.out.println("2");
        } else if (a == 3){
            System.out.println("3");
        } else{
            System.out.println("--");
        }
        System.out.println(a == 1 ? "true" : "false");

        switch(a) {
            case 1:
                System.out.println(1);
                break;
            case 2:
                System.out.println(1);
                break;
            case 3:
                System.out.println(1);
                break;
            default:
                System.out.println("--");
                break;

        }
    }


}
