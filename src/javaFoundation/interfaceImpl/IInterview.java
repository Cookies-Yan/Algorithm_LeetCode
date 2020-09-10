package javaFoundation.interfaceImpl;

public interface IInterview {  //接口只包含方法

    //接口中没有准确的变量一般都是常量，所以public static final是默认的，可以不加。
    public static final int b = 1;

    int a = 1;

    //在接口中不实现方法的，只进行声明.在实现接口的类中具体实现方法
    void fail();

    void success();

    //JAVA 1.8之后新增的接口方法：default static
    default void temp() {
        System.out.println("Cool");
    }

    static void temp2 (){
        System.out.println("Cool2");
    }
}
