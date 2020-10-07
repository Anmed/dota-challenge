package gg.bayes.challenge.parsers.impl;

import gg.bayes.challenge.db.model.MatchRecord;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Parser that taking care of all the stuff that is not crucial for as at this moment
 */
@Slf4j
@Component
public class TrashParser extends TypicalLogParserImpl {

    public TrashParser(@Value("${patterns.hero.trash}") String pattern) {
        super(pattern);
    }

    @Override
    public void parse(MatchRecord matchRecord) {
        log.debug("this was considered as not interesting for as at the moment {}", currentlyExecutingLine);
    }

}
