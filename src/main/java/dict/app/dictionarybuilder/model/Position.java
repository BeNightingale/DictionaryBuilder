package dict.app.dictionarybuilder.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.proxy.HibernateProxy;

import java.util.Objects;


@Entity(name = "positions")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "position_id")
    private Integer positionId;

    @ManyToOne()
    @JoinColumn(name = "pos_dictionary_id")
    Dictionary dictionary;

    @Column(name = "position_name")
    String positionName;

    @Column(name = "position_value")
    String positionValue;

    @OneToOne()
    @JoinColumn(name = "dependent_position_id")
    Position dependentPosition;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Position position = (Position) o;
        return getPositionId() != null && Objects.equals(getPositionId(), position.getPositionId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }

    @Override
    public String toString() {
        return """
                Position:
                    positionId = %s,
                    dictionaryId = %s,
                    positionName = %s,
                    positionValue = %s,
                    dependentPositionId = %s.
                """.formatted(
                        this.positionId,
                        this.dictionary.dictionaryId,
                        this.positionName,
                        this.positionValue,
                        this.dependentPosition == null ? StringUtils.EMPTY : this.dependentPosition.positionId);
    }
}
