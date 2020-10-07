package gg.bayes.challenge.parsers.impl;

import gg.bayes.challenge.db.model.HeroDealtDamageRecord;
import gg.bayes.challenge.db.model.MatchRecord;
import gg.bayes.challenge.repositories.HeroDamageRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class HeroDamageParser extends TypicalLogParserImpl {
    private static final int TARGET_HERO_GROUP_ID = 3;
    private static final int DAMAGE_SOURCE_GROUP_ID = 4;
    private static final int DAMAGE_AMOUNT_GROUP_ID = 5;

    public HeroDamageParser(@Value("${patterns.hero.damage}") String pattern, HeroDamageRepository repository) {
        super(pattern, repository);
    }


    @Override
    public void parse(MatchRecord matchRecord) {
        log.debug("Parsing hero damage record {}", currentlyExecutingLine);
        HeroDealtDamageRecord heroDealtDamageRecord = HeroDealtDamageRecord.builder()
                .match(matchRecord)
                .heroName(matcher.group(HERO_GROUP_ID))
                .targetHero(matcher.group(TARGET_HERO_GROUP_ID))
                .damage(Integer.parseInt(matcher.group(DAMAGE_AMOUNT_GROUP_ID)))
                .damageSource(matcher.group(DAMAGE_SOURCE_GROUP_ID))
                .timestamp(super.getTimeStamp(matcher.group(TIMESTAMP_GROUP_ID)))
                .build();
        listToSave.add(heroDealtDamageRecord);
    }
}
