package gg.bayes.challenge.parsers.impl;

import gg.bayes.challenge.db.model.MatchRecord;
import gg.bayes.challenge.db.model.TypicalRecord;
import gg.bayes.challenge.parsers.LogParser;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalTime;
import java.time.temporal.ChronoField;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TypicalLogParserImpl implements LogParser {

    protected CrudRepository repository;
    protected final Pattern pattern;
    protected Matcher matcher;
    protected String currentlyExecutingLine;
    List<TypicalRecord> listToSave = new ArrayList<>();
    protected static final int TIMESTAMP_GROUP_ID = 1;
    protected static final int HERO_GROUP_ID = 2;

    public TypicalLogParserImpl(String pattern) {
        this.pattern = Pattern.compile(pattern);
    }

    public TypicalLogParserImpl(String pattern, CrudRepository repository) {
        this(pattern);
        this.repository = repository;
    }

    @Override
    public void parse(MatchRecord matchRecord) {

    }

    public boolean canHandleLine(String line) {
        matcher = pattern.matcher(line);
        boolean resultOfVerification = matcher.find();
        if (resultOfVerification) {
            this.currentlyExecutingLine = line;
        }
        return resultOfVerification;
    }

    @Override
    public void saveProgress() {
        if (listToSave.size() > 0) {
            repository.saveAll(listToSave);
            listToSave.clear();
        }
    }

    /**
     * converting string to millis of the day
     *
     * @param time string representation of time, expecting to receive time in HH:mm:ss.SSS format
     * @return time from start of the day in Millis
     */
    protected int getTimeStamp(String time) {
        return LocalTime.parse(time).get(ChronoField.MILLI_OF_DAY);
    }
}
