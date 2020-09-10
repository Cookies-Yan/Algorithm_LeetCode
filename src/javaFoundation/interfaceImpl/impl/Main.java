package javaFoundation.interfaceImpl.impl;

import javaFoundation.interfaceImpl.IInterview;

public class Main {

    public static void main(String[] args) {

        IInterview interview = new GoogleImpl();
        IInterview interview1 = new FacebookImpl();

    }
}
