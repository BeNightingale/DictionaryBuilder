package dict.app.dictionarybuilder;

import dict.app.dictionarybuilder.model.Dictionary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DictionaryRepository extends JpaRepository<Dictionary, Integer> {

    List<Dictionary> findAll();
}
