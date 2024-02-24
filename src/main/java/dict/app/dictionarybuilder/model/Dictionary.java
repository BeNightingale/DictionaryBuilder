package dict.app.dictionarybuilder.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@Entity(name = "dictionaries")
@NoArgsConstructor
@AllArgsConstructor
@Data

public class Dictionary {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dictionary_id")
    int dictionaryId;

    @Column(name = "dictionary_name")
    String dictionaryName;

    @Column(name = "dictionary_created ")
    LocalDateTime created;

    @Column(name = "dictionary_description")
    String dictionaryDescription;

    @OneToMany(mappedBy = "dictionary", fetch = FetchType.EAGER)
    Set<Position> positionSet;

    @OneToOne()
    @JoinColumn(name = "parent_dictionary_id")
    Dictionary parentDictionary;

    @Override
    public String toString() {
        return """
                Dictionary:\s
                    dictionaryId = %s,
                    dictionaryName = %s,
                    dictionaryCreated = %s,
                    positionIdsSet = %s,
                    parentDictionaryId = %s.\s
                """
                        .formatted(this.dictionaryId, this.dictionaryName, this.created, this.toPositionIdsSet(),
                                this.parentDictionary == null ? StringUtils.EMPTY : this.parentDictionary.getDictionaryId());
    }

    private String  toPositionIdsSet() {
        if (CollectionUtils.isEmpty(this.getPositionSet())) {
            return StringUtils.EMPTY;
        }
        StringBuilder positionsIds = new StringBuilder();
        for (Position pos : this.getPositionSet()) {
            positionsIds.append(pos.getPositionId());
        }
        return positionsIds.toString();
    }
}
