package dict.app.dictionarybuilder;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    public DictionaryService dictionaryService() {
        return new DictionaryService();
    }
}
