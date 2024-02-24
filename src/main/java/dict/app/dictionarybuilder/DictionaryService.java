package dict.app.dictionarybuilder;

import dict.app.dictionarybuilder.model.Dictionary;
import dict.app.dictionarybuilder.model.Position;
import jakarta.transaction.Transactional;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

@Service
@NoArgsConstructor
@Getter
@Slf4j
public class DictionaryService {
     @Autowired
     DictionaryRepository dictionaryRepository;
     @Autowired
     PositionRepository positionRepository;

//    public DictionaryService(@Autowired DictionaryRepository dictionaryRepository) {
//        this.dictionaryRepository = dictionaryRepository;
//    }


    public List<Dictionary> giveDictionaries() {
        return dictionaryRepository.findAll();
    }

    @Transactional
    public Dictionary createDictWithPositions() {
        DictionaryDto dictionaryDto = DictionaryDto.builder()
                .dictionaryName("KRAJE")
                .created(LocalDateTime.now())
                .dictionaryDescription("państwa")
                .positionSet(new HashSet<>())
                .build();
    Dictionary dictionarySaved =  dictionaryRepository.save(dictionaryDto.toDictionary());
    Position position1 = new Position(null, dictionarySaved, "nazwa państwa", "Polska", null);
    Position position2 = new Position(null, dictionarySaved, "nazwa państwa", "Niemcy", null);
    Position positionS1 = positionRepository.save(position1);
    Position positionS2 = positionRepository.save(position2);
    dictionarySaved.getPositionSet().add(positionS1);
    dictionarySaved.getPositionSet().add(positionS2);
    dictionaryRepository.save(dictionarySaved);
        return dictionarySaved;
    }
    @Transactional
    public String getPosition (int dictId) {
        Dictionary dictionaryFound = dictionaryRepository.findById(dictId).orElse(null);
        if (dictionaryFound == null) {
            return "no dictionary";
        }
        Set<Position> setP = dictionaryFound.getPositionSet();
        if (setP==null){
            return "no positions1";
        }
        Position p = setP.stream().findFirst().orElse(null);
        if (p == null) {
            return "no positions2";
        }
        return p.toString();
    }
}
