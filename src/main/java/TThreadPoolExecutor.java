import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class TThreadPoolExecutor extends TExecutorService {

    /**
     * 线程池状态，false：未关闭，true 已关闭
     */
    private AtomicBoolean ctl = new AtomicBoolean();

    @Override
    public void execute() {
        // 启动一个新线程，模拟 ThreadPoolExecutor.execute
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//
//            }
//        }).start();

        // 改成sleep
        try {
            // 显式的 sleep 1 ns，主动切换线程
            TimeUnit.NANOSECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 模拟 ThreadPoolExecutor，启动新建线程后，循环检查线程池状态，验证是否会在 finalize 中 shutdown
        // 如果线程池被提前 shutdown，则抛出异常
        for (int i = 0; i < 1_000_000; i++) {
            if(ctl.get()){
                throw new RuntimeException("reject!!!["+ctl.get()+"]");
            }
        }
    }

    @Override
    public void shutdown() {
        ctl.compareAndSet(false,true);
    }
}