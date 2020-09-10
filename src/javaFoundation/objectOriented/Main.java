package javaFoundation.objectOriented;

public class Main {
    public static void main(String[] args) {

//        SingleDog code1 = new SingleDog("Alex", "male","SDE");
//        SingleDog code2 = new SingleDog("Alex", "male","SDE");
//        SingleDog.time = "85";
//        Coder code = new Coder();
//        code.getGender();
//        Coder code3 = new Coder("Alex","male","SDE", "996", 10);
//        Coder code = new Coder();
//        code.work();
//        System.out.println(code.getClass());
        SingleDog coder = new Coder(); //向上转型
        SingleDog teacher = new Teacher();

        teacher.work(); //不能调用子类的

        Coder coder2 = (Coder)coder;
        coder2.cs();

        if(coder instanceof Coder){ //当前的对象coder是否属于Coder类，是，返回true

        }
        if(coder instanceof Teacher){

        }
    }
}
