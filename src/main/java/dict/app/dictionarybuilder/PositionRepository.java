package dict.app.dictionarybuilder;

import dict.app.dictionarybuilder.model.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionRepository extends JpaRepository<Position, Integer> {
}
