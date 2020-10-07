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
@Table(name = "hero_kills")
@AllArgsConstructor
@NoArgsConstructor
public class HeroKillRecord extends TypicalRecord {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private MatchRecord match;

    private String killerName;

    private String victimName;

    private Integer timestamp;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HeroKillRecord that = (HeroKillRecord) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(match, that.match) &&
                Objects.equals(killerName, that.killerName) &&
                Objects.equals(victimName, that.victimName) &&
                Objects.equals(timestamp, that.timestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, match, killerName, victimName, timestamp);
    }

    @Override
    public String toString() {
        return "HeroSlayRecord{" +
                "id=" + id +
                ", match=" + match +
                ", killerName='" + killerName + '\'' +
                ", victimName='" + victimName + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
