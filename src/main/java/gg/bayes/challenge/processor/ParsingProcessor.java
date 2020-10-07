package gg.bayes.challenge.processor;

import gg.bayes.challenge.parsers.LogParser;

public interface ParsingProcessor {

    LogParser selectParser(String line);
    void saveCreatedItems();
}
