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
@Table(name = "hero_dealt_damage")
@AllArgsConstructor
@NoArgsConstructor
public class HeroDealtDamageRecord extends TypicalRecord {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private MatchRecord match;

    private String heroName;

    private String targetHero;

    private String damageSource;

    private Integer damage;

    private Integer timestamp;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HeroDealtDamageRecord that = (HeroDealtDamageRecord) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(match, that.match) &&
                Objects.equals(heroName, that.heroName) &&
                Objects.equals(targetHero, that.targetHero) &&
                Objects.equals(damage, that.damage) &&
                Objects.equals(damageSource, that.damageSource) &&
                Objects.equals(timestamp, that.timestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, match, heroName, targetHero, damage, timestamp, damageSource);
    }

    @Override
    public String toString() {
        return "HeroDealtDamageRecord{" +
                "id=" + id +
                ", match=" + match +
                ", heroName='" + heroName + '\'' +
                ", targetHero='" + targetHero + '\'' +
                ", damage=" + damage +
                ", timestamp=" + timestamp +
                ", damageSource=" + damageSource +
                '}';
    }
}
