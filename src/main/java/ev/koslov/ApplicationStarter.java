package ev.koslov;

import ev.koslov.config.MainConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

public class ApplicationStarter extends SpringBootServletInitializer{
    public static void main(String[] args) {
        SpringApplication.run(MainConfig.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        builder.sources(MainConfig.class);
        return builder;
    }
}
