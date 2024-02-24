package dict.app.dictionarybuilder;

import dict.app.dictionarybuilder.model.Dictionary;
import dict.app.dictionarybuilder.model.Position;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.util.Set;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

@SpringBootTest
class DictionaryBuilderApplicationTests {
    @Autowired
    ApplicationContext applicationContext;
    @Autowired
    DictionaryService dictionaryService;
    @Autowired
    DictionaryRepository dictionaryRepository;
    @Autowired
    PositionRepository positionRepository;


    @Test
    void contextLoads() {
    }

    @Test
    void cc() {
//       String[] aa = applicationContext.getBeanDefinitionNames();
//       Arrays.stream(aa).forEach(b -> System.out.println(b));
      //  List<Dictionary> list = dictionaryService.giveDictionaries();
      //  assertNotNull(list);
        Dictionary dictionary = new Dictionary();
//        dictionary.setDictionaryName("PŁEĆ");
//        dictionary.setCreated(LocalDateTime.now());

        Dictionary dictionaryFound = dictionaryRepository.findById(5).orElse(null);
//        Position positionK = positionRepository.findById(5).orElse(null);
//        Position positionM = positionRepository.findById(6).orElse(null);
//        dictionaryFound.setPositionSet(Set.of(positionM, positionK));
        assertNotNull(dictionaryFound);
        Set<Position> p = dictionaryFound.getPositionSet();
    }

}
