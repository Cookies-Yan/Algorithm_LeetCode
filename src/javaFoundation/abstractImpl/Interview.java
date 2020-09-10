package javaFoundation.abstractImpl;

public abstract class Interview {
    //每个公司的都是不一样的，只声明不实现
    public abstract void fail();
    //只声明不实现，所以不能实例化
    public abstract void success();

    public void before() {
        System.out.println("刷题");
    }

    public void after() {
        System.out.println("H1B");
    }
}
