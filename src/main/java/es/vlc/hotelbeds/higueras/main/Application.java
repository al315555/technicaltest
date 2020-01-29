package es.vlc.hotelbeds.higueras.main;

import es.vlc.hotelbeds.higueras.controller.ItemController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"es.vlc.hotelbeds.higueras.service", "es.vlc.hotelbeds.higueras.controller"})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
