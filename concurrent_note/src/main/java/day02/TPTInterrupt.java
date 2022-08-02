package day02;

import lombok.extern.slf4j.Slf4j;

/*
两阶段终止模式
 */
@Slf4j(topic = "c.TPTInterrupt")
class TPTInterrupt {
    private Thread thread;

    public void start(){
        thread = new Thread(() -> {
            while(true) {
                Thread current = Thread.currentThread();
                if(current.isInterrupted()) {
                    log.debug("料理后事");
                    break;
                }
                try {
                    //对应两阶段，该线程处于sleep等状态，被打断，打断标记为false，抛出异常，再次打断，标记为true
                    Thread.sleep(1000);
                    //该线程处于正常运行状态，被打断，则打断标记为true，
                    log.debug("将结果保存");
                } catch (InterruptedException e) {
                    current.interrupt();
                }

            }
        },"监控线程");
        thread.start();
    }

    public void stop() {
        thread.interrupt();
    }

    public static void main(String[] args) throws InterruptedException {
        TPTInterrupt t = new TPTInterrupt();
        t.start();
        Thread.sleep(3500);
        log.debug("stop");
        t.stop();
    }
}