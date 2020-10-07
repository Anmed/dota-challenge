package gg.bayes.challenge.parsers.impl;

import gg.bayes.challenge.db.model.MatchRecord;
import gg.bayes.challenge.parsers.MatchParser;
import gg.bayes.challenge.repositories.MatchRepository;
import gg.bayes.challenge.processor.ParsingProcessor;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.StringReader;

@Component
public class MatchParserImpl implements MatchParser {

    private final MatchRepository matchRepository;
    private final ParsingProcessor parsingProcessor;

    public MatchParserImpl(MatchRepository repository, ParsingProcessor parsingProcessor) {
        this.matchRepository = repository;
        this.parsingProcessor = parsingProcessor;
    }

    @Override
    public Long parseMatch(String payload) {
        MatchRecord matchRecord = matchRepository.save(new MatchRecord());
        new BufferedReader(new StringReader(payload))
                .lines().forEach(line -> parsingProcessor.selectParser(line).parse(matchRecord));
        parsingProcessor.saveCreatedItems();
        return matchRecord.getId();
    }
}
