
import java.util.concurrent.*;

public class Test {

    public static void main(String[] args) {
        // 创建线程池
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(10, 20, 5, TimeUnit.SECONDS, new LinkedBlockingQueue<>(10));
        // 执行任务
        long start = System.currentTimeMillis();
        System.out.println("kaishishijian "+start);
        for (int i = 0; i < 31; i++) {
            final int index = i;
            threadPool.execute(() -> {

                try {
                    Thread.sleep(1000);
                    System.out.println("已执行"+index+"个任务");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            });

        }
        long end = 0;
        while(threadPool.getCompletedTaskCount()<30){
            end = System.currentTimeMillis();

        }

        System.out.println("用时"+(end-start));
        System.out.println("用时"+(end-start));



    }

}
