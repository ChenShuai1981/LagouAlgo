import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicReference;

public class CompletionServiceExample {
    public static void main(String[] args) throws Exception {
        // 创建线程池
        ExecutorService executor = java.util.concurrent.Executors.newFixedThreadPool(3);
        // 创建 CompletionService
        CompletionService<Integer> cs = new ExecutorCompletionService<>(executor);
        AtomicReference<Integer> m = new AtomicReference<>(Integer.MAX_VALUE);
        // 异步向电商 S1 询价
        cs.submit(()->getPriceByS1());
        // 异步向电商 S2 询价
        cs.submit(()->getPriceByS2());
        // 异步向电商 S3 询价
        cs.submit(()->getPriceByS3());
        // 将询价结果异步保存到数据库
        // 并计算最低报价
        for (int i=0; i<3; i++) {
            Integer r = cs.take().get();
            executor.execute(()-> save(r));
            m.getAndUpdate(v->Integer.min(v, r));
        }
        System.out.println(m.get());
        executor.shutdown();
    }

    private static void save(Integer r) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static Integer getPriceByS1() throws InterruptedException {
        Thread.sleep(2000);
        return 2;
    }

    private static Integer getPriceByS2() throws InterruptedException {
        Thread.sleep(3000);
        return 3;
    }

    private static Integer getPriceByS3() throws InterruptedException {
        Thread.sleep(1000);
        return 1;
    }
}
