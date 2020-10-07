package gg.bayes.challenge.db.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Objects;

@Builder
@Getter
@Setter
@Entity
@Table(name = "hero_spell")
@AllArgsConstructor
@NoArgsConstructor
public class HeroCastedSpellRecord  extends TypicalRecord{
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private MatchRecord match;

    private String heroName;

    private String abilityName;

    private Integer timestamp;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HeroCastedSpellRecord heroSpell = (HeroCastedSpellRecord) o;
        return Objects.equals(id, heroSpell.id) &&
                Objects.equals(match, heroSpell.match) &&
                Objects.equals(heroName, heroSpell.heroName) &&
                Objects.equals(abilityName, heroSpell.abilityName) &&
                Objects.equals(timestamp, heroSpell.timestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, match, heroName, abilityName, timestamp);
    }

    @Override
    public String toString() {
        return "HeroSpell{" +
                "id=" + id +
                ", match=" + match +
                ", heroName='" + heroName + '\'' +
                ", abilityName='" + abilityName + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
