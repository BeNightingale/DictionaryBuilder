package dict.app.dictionarybuilder;

import dict.app.dictionarybuilder.model.Dictionary;
import dict.app.dictionarybuilder.model.Position;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;
@Builder
@Data
public class DictionaryDto {

    int dictionaryId;
    String dictionaryName;
    LocalDateTime created;
    String dictionaryDescription;
    Set<Position> positionSet;
    Dictionary parentDictionary;

    public Dictionary toDictionary() {
        return new Dictionary(this.dictionaryId, this.dictionaryName, this.created, this.dictionaryDescription, this.positionSet, this.parentDictionary);
    }
}
