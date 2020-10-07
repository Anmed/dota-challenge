package gg.bayes.challenge.rest.model;

import gg.bayes.challenge.repositories.projections.HeroSpell;
import lombok.Data;

@Data
public class HeroSpells {
    private String spell;
    private Integer casts;

    public HeroSpells(HeroSpell spell) {
        this.spell = spell.getSpell();
        this.casts = spell.getCasts();
    }
}
