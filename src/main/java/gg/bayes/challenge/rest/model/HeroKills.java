package gg.bayes.challenge.rest.model;

import gg.bayes.challenge.repositories.projections.HeroKill;
import lombok.Data;

@Data
public class HeroKills {
    private String hero;
    private Integer kills;

    public HeroKills(HeroKill kill) {
        this.hero = kill.getHero();
        this.kills = kill.getKills();
    }
}
