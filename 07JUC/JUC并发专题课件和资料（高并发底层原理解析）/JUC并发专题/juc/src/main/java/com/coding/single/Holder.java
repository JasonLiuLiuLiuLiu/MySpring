package com.coding.single;

import java.util.concurrent.RecursiveTask;

public class Holder {
    private Holder(){

    }

    public static Holder getInstance(){
        return InnerClass.HOLDER;
    }

    private static class InnerClass {
        private static final Holder HOLDER = new Holder();
    }
}
