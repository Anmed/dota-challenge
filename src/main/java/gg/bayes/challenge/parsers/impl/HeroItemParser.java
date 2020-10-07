package gg.bayes.challenge.parsers.impl;

import gg.bayes.challenge.db.model.HeroItemRecord;
import gg.bayes.challenge.db.model.MatchRecord;
import gg.bayes.challenge.repositories.HeroItemRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class HeroItemParser extends TypicalLogParserImpl {
    private static final int BOUGHT_ITEM_GROUP_ID = 3;

    public HeroItemParser(@Value("${patterns.hero.item}") String pattern, HeroItemRepository repository) {
        super(pattern, repository);
    }

    @Override
    public void parse(MatchRecord matchRecord) {
        log.debug("Parsing hero buying item record {}", currentlyExecutingLine);
        HeroItemRecord heroItemRecord = HeroItemRecord.builder()
                .match(matchRecord)
                .heroName(matcher.group(HERO_GROUP_ID))
                .itemName(matcher.group(BOUGHT_ITEM_GROUP_ID))
                .timestamp(super.getTimeStamp(matcher.group(TIMESTAMP_GROUP_ID)))
                .build();
        listToSave.add(heroItemRecord);
    }

}
