package javaFoundation.abstractImpl;

import javaFoundation.interfaceImpl.IInterview;

public class GoogleInter extends Interview implements IInterview {

    //在Interview声明了方法在这里要实现，否则不能继承
    @Override
    public void fail() {

    }

    @Override
    public void success() {
        TreeNode node = new TreeNode();
    }
    //内部类
    class TreeNode {
        int a;
        int b;
    }
}
