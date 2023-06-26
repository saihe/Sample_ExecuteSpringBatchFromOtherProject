package practice.saito.SpringBatch.batch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import practice.saito.SpringBatch.Application;

import java.util.Arrays;
import java.util.Optional;

@Component("wrapperJob")
@ConditionalOnProperty(value = { "batch.execute" }, havingValue = "sample")
public class Sample implements CommandLineRunner, ExitCodeGenerator {
  @Autowired(required = false)
  @Qualifier("originalJob")
  private practice.saito.SpringBootBatch.batch.Sample job;

  @Override
  public void run(String... args) {
    var c = new AnnotationConfigApplicationContext(Application.class);
    Arrays.stream(c.getBeanDefinitionNames()).forEach(System.out::println);
    Optional.ofNullable(job).ifPresent(practice.saito.SpringBootBatch.batch.Sample::execute);
  }

  @Override
  public int getExitCode() {
    return 0;
  }
}
