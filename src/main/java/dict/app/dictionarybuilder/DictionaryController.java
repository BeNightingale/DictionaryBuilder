package dict.app.dictionarybuilder;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/dict")
@Slf4j
public class DictionaryController {

    private final DictionaryRepository dictionaryRepository;

    private final DictionaryService dictionaryService;


    @GetMapping("/dictionaries_count")
    public long getDeliveriesCount() {
        return dictionaryService.giveDictionaries().stream().mapToInt(d -> 1).count();
     //   return dictionaryRepository.findAll().stream().mapToInt(d -> 1).count();
    }

    @GetMapping("/dictionary_add")
    public String addDictionary() {
        return dictionaryService.createDictWithPositions().toString();
    }
    @GetMapping("/pos")
    public String fintPos() {
        return dictionaryService.getPosition(12);
    }

}
