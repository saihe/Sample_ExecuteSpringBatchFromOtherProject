package practice.saito.SpringBootBatch.batch;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Sample {
  @Scheduled(
    initialDelayString = "${batch.sample.schedule.initial}",
    fixedDelayString = "${batch.sample.schedule.delay}"
  )
  public void execute() {

    System.out.println("実行バッチ名：サンプル");
  }
}
