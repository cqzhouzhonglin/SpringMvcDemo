/**
 * Copyright (c) 天畅伟业科技有限公司 
 * 本著作物的著作权归天畅伟业有限公司所有。
 */
package com.tianchang.thread;

/**
 * <pre>
 * <b>.</b>
 * <b>Description:线程B 同步方法 计算1+2+3 ... +100的和 </b> 
 * 
 * <b>Author:</b> zhouhong
 * <b>Date:</b> 2016年6月23日 下午2:39:02
 * <b>Copyright:</b> Copyright &copy;2006-2026 天畅 Co., Ltd. All rights reserved.
 * <b>Changelog:</b>
 *   Ver   Date                  Author              Detail
 *   ----------------------------------------------------------------------
 *   1.0   2016-06-01 下午2:39:02   zhouhong       new file.
 * </pre>
 */
public class ThreadB extends Thread {
    int total;

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Runnable#run()
     */
    @Override
    public synchronized void run() {
        for (int i = 0; i < 101; i++) {
            total += i;
        }
        // （完成计算了）唤醒在此对象监视器上等待的单个线程，在本例中线程A被唤醒
        notify();
    }
}
