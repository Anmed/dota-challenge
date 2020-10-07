package gg.bayes.challenge.rest.model;

import gg.bayes.challenge.repositories.projections.HeroItem;
import lombok.Data;

@Data
public class HeroItems {
    private String item;
    private Long timestamp;

    public HeroItems(HeroItem item) {
        this.item = item.getItem();
        this.timestamp = item.getTimestamp();
    }
}
