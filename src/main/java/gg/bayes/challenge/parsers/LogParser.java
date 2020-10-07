package gg.bayes.challenge.parsers;

import gg.bayes.challenge.db.model.MatchRecord;

public interface LogParser {

    /**
     * Taking parsed line,breaking a string into tokens and saving it to db
     * @param matchRecord id of the match that is being processed
     */
    void parse(MatchRecord matchRecord);

    /**
     * @param line string line to be parsed
     * @return  decision whether this parser can handle this string
     */
    boolean canHandleLine(String line);

    /**
     * Saving currently parsed items in db
     */
    void saveProgress();
}
