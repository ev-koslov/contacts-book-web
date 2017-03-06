package ev.koslov.config;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

/**
 * Created by voron on 24.10.2016.
 */

@SpringBootApplication
@ComponentScan("ev.koslov")
//ignoring resourceNotFound. In this case parameters should be overridden
//@PropertySource(value = "file:${configFile}", ignoreResourceNotFound = true)
public class MainConfig {



    //Configuring message source, which handles messages using current locale and message code
    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasenames("classpath:validation_errors", "classpath:page_locale");
        messageSource.setDefaultEncoding("cp1251");
        return messageSource;
    }
}
