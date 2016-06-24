/**
 * Copyright (c) 天畅伟业科技有限公司 
 * 本著作物的著作权归天畅伟业有限公司所有。
 */
package com.tianchang.thread;

/**
 * <pre>
 * <b>.</b>
 * <b>Description:计算输出其他线程锁计算的数据</b> 
 * 
 * <b>Author:</b> zhouhong
 * <b>Date:</b> 2016年6月23日 下午2:42:13
 * <b>Copyright:</b> Copyright &copy;2006-2026 天畅 Co., Ltd. All rights reserved.
 * <b>Changelog:</b>
 *   Ver   Date                  Author              Detail
 *   ----------------------------------------------------------------------
 *   1.0   2016-06-01 下午2:42:13   zhouhong       new file.
 * </pre>
 */
public class TestThreadC {
    public static void main(String[] args) {
        ThreadB b = new ThreadB();
        b.start();
        // 线程A拥有b对象上的锁。线程为了调用wait()或notify()方法，该线程必须是那个对象锁的拥有者
        synchronized (b) {
            try {
                System.out.println("等待对象b完成计算。。。");
                // 当前线程A等待
                b.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("b对象计算的总和是：" + b.total);
        }
    }
}
