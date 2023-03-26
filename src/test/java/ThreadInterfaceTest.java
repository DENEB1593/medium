import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class ThreadInterfaceTest {

  // Runnable vs Callable
  // Callable has return Type
  // Runnable has no return Type

  @Test
  void testRunnableTask() {
    ExecutorService executorService = Executors.newFixedThreadPool(4);
    for (int i = 1; i <= 10; i++) {
      executorService.submit(
              new TaskRunnable(String.format("TASK %d", i))
      );
    }

    awaitTerminationAfterShutdown(executorService);

  }

  @Test
  void testCallableTask() {
    ExecutorService executorService = Executors.newFixedThreadPool(4);
    List<Future<Integer>> futures = new ArrayList<>();
    for (int i = 1; i <= 10; i++) {
      futures.add(
              executorService.submit(
                      new TaskCallable(String.format("%d", i)))
      );
    }

    futures.forEach(future -> {
      try {
        System.out.println("Result : " + future.get());
      } catch (InterruptedException | ExecutionException e) {
        throw new RuntimeException(e);
      }
    });
  }


  class TaskRunnable implements Runnable {

    private final String name;

    public TaskRunnable(String name) {
      this.name = name;
    }

    @Override
    public void run() {
      System.out.println(String.format("%s task running", this.name));
      try {
        Thread.sleep(1000);
        System.out.println(String.format("%s task finished", this.name));
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }

    }
  }

  class TaskCallable implements Callable<Integer> {

    private final String name;

    public TaskCallable(String name) {
      this.name = name;
    }

    @Override
    public Integer call() throws Exception {
      System.out.println(name + " is running");
      try {
        Thread.sleep(1000);
        System.out.println(name + " is completed");
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
      return (new Random().nextInt()) % 100;
    }
  }


  private static void awaitTerminationAfterShutdown(ExecutorService threadPool) {
    threadPool.shutdown();
    try {
      if (!threadPool.awaitTermination(60, TimeUnit.SECONDS)) {
        threadPool.shutdownNow();
      }
    } catch (InterruptedException ex) {
      threadPool.shutdownNow();
      Thread.currentThread().interrupt();
    }
  }
}
