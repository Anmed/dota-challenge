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
@Table(name = "hero_bought_item")
@AllArgsConstructor
@NoArgsConstructor
public class HeroItemRecord extends TypicalRecord {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private MatchRecord match;

    private String heroName;

    private String itemName;

    private Integer timestamp;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HeroItemRecord that = (HeroItemRecord) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(match, that.match) &&
                Objects.equals(heroName, that.heroName) &&
                Objects.equals(itemName, that.itemName) &&
                Objects.equals(timestamp, that.timestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, match, heroName, itemName, timestamp);
    }

    @Override
    public String toString() {
        return "HeroItemRecord{" +
                "id=" + id +
                ", match=" + match +
                ", hero='" + heroName + '\'' +
                ", itemName='" + itemName + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
