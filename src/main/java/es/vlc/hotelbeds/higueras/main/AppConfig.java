package es.vlc.hotelbeds.higueras.main;

import es.vlc.hotelbeds.higueras.service.CalculateService;
import es.vlc.hotelbeds.higueras.service.CalculateServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public CalculateService calculateService() {
        return new CalculateServiceImpl();
    }
}
