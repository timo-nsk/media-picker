package com.mediapicker;

import com.mediapicker.web.OfflineAppRegister;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class MediaverseBackendApplication {

  private final OfflineAppRegister offlineAppRegister;

  public MediaverseBackendApplication(OfflineAppRegister offlineAppRegister) {
    this.offlineAppRegister = offlineAppRegister;
  }

  public static void main(String[] args) {
    SpringApplication.run(MediaverseBackendApplication.class, args);
  }

  @Profile("dev")
  @Bean
  public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
    return args -> {
      this.offlineAppRegister.setupApplication();
    };
  }

}
