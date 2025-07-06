package org.ccnuiot.bigevent;

import org.junit.jupiter.api.Test;

public class ThreadLocalTest {

    @Test
    public void testThreadLocalSetAndGet() {
        //提供一个ThreadLocal对象
        ThreadLocal tl = new ThreadLocal();

        //开启两个线程
        new Thread(() -> {
            tl.set("Thread1");
            System.out.println(Thread.currentThread().getName() + ": " + tl.get());
        }, "blue").start();

        new Thread(() -> {
            tl.set("Thread2");
            System.out.println(Thread.currentThread().getName() + ": " + tl.get());
        }, "green").start();
    }
}
