package practice.saito.SpringBatch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(scanBasePackages = {"practice.saito.*"})
@EnableScheduling
public class Application {
  public static void main(String[] args) {
    var app = new SpringApplication(Application.class);
    app.setWebApplicationType(WebApplicationType.NONE);
    app.run(args);
  }
}
