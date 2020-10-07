package gg.bayes.challenge.parsers.impl;

import gg.bayes.challenge.db.model.HeroKillRecord;
import gg.bayes.challenge.db.model.MatchRecord;
import gg.bayes.challenge.repositories.HeroDamageRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class HeroKillParser extends TypicalLogParserImpl {
    private static final int KILLER_HERO_GROUP_ID = 3;


    public HeroKillParser(@Value("${patterns.hero.kill}") String pattern, HeroDamageRepository heroDamageRepository) {
        super(pattern, heroDamageRepository);
    }

    @Override
    public void parse(MatchRecord matchRecord) {
        log.debug("Parsing hero kill record {}", currentlyExecutingLine);
        HeroKillRecord heroKillRecord = HeroKillRecord.builder()
                .match(matchRecord)
                .victimName(matcher.group(HERO_GROUP_ID))
                .killerName(matcher.group(KILLER_HERO_GROUP_ID))
                .timestamp(super.getTimeStamp(matcher.group(TIMESTAMP_GROUP_ID)))
                .build();
        listToSave.add(heroKillRecord);
    }

}
