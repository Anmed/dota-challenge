package gg.bayes.challenge.processor.impl;

import gg.bayes.challenge.exceptions.LogParserException;
import gg.bayes.challenge.parsers.LogParser;
import gg.bayes.challenge.processor.ParsingProcessor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class ParsingProcessorImpl implements ParsingProcessor {

    private final List<LogParser> logParsers;

    public ParsingProcessorImpl(List<LogParser> logParsers) {
        this.logParsers = logParsers;
    }

    @Override
    public LogParser selectParser(String line) {
        log.debug("Choosing parser that can handle this sophisticated string {}", line);
        for(LogParser logParser : logParsers){
            if(logParser.canHandleLine(line)){
                log.debug("The chosen one is {}", logParser.getClass().getName());
                return logParser;
            }
        }
        throw  new LogParserException(String.format("No proper parser found for line %s", line));
    }

    @Override
    public void saveCreatedItems() {
        logParsers.forEach(LogParser::saveProgress);
    }
}
