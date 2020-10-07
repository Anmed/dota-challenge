package gg.bayes.challenge.service;

import gg.bayes.challenge.rest.model.HeroDamage;
import gg.bayes.challenge.rest.model.HeroItems;
import gg.bayes.challenge.rest.model.HeroKills;
import gg.bayes.challenge.rest.model.HeroSpells;

import java.util.List;

public interface MatchService {
    Long ingestMatch(String payload);

    List<HeroKills> getMatchStats(Long matchId);

    List<HeroSpells> getCastedSpellsByHero(Long matchId, String heroName);

    List<HeroItems> getPurchaseSummary(Long matchId, String heroName);

    List<HeroDamage> getDamageDoneByHero(Long matchId, String heroName);

    // TODO add more methods as needed
}
