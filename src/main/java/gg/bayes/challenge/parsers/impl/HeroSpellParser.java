package gg.bayes.challenge.parsers.impl;

import gg.bayes.challenge.db.model.HeroCastedSpellRecord;
import gg.bayes.challenge.db.model.MatchRecord;
import gg.bayes.challenge.repositories.HeroSpellRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class HeroSpellParser extends TypicalLogParserImpl {
    private static final int ABILITY_NAME_GROUP_ID = 3;

    public HeroSpellParser(@Value("${patterns.hero.spell}") String pattern, HeroSpellRepository repository) {
        super(pattern, repository);
    }

    @Override
    public void parse(MatchRecord matchRecord) {
        log.debug("Parsing hero casting spell record {}", currentlyExecutingLine);
        HeroCastedSpellRecord heroSpellRecord = HeroCastedSpellRecord.builder()
                .match(matchRecord)
                .heroName(matcher.group(HERO_GROUP_ID))
                .abilityName(matcher.group(ABILITY_NAME_GROUP_ID))
                .timestamp(super.getTimeStamp(matcher.group(TIMESTAMP_GROUP_ID)))
                .build();
        listToSave.add(heroSpellRecord);
    }


}
