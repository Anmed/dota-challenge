package gg.bayes.challenge.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import gg.bayes.challenge.repositories.projections.HeroDealtDamage;
import lombok.Data;

@Data
public class HeroDamage {
    private String target;
    @JsonProperty("damage_instances")
    private Integer damageInstances;
    @JsonProperty("total_damage")
    private Integer totalDamage;

    public HeroDamage(HeroDealtDamage damage) {
        this.target = damage.getTarget();
        this.damageInstances = damage.getDamageInstances();
        this.totalDamage = damage.getTotalDamage();
    }
}
