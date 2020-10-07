package gg.bayes.challenge.service.impl;

import gg.bayes.challenge.parsers.MatchParser;
import gg.bayes.challenge.repositories.HeroDamageRepository;
import gg.bayes.challenge.repositories.HeroItemRepository;
import gg.bayes.challenge.repositories.HeroKillRepository;
import gg.bayes.challenge.repositories.HeroSpellRepository;
import gg.bayes.challenge.rest.model.HeroDamage;
import gg.bayes.challenge.rest.model.HeroItems;
import gg.bayes.challenge.rest.model.HeroKills;
import gg.bayes.challenge.rest.model.HeroSpells;
import gg.bayes.challenge.service.MatchService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class MatchServiceImpl implements MatchService {

    private final MatchParser matchParser;
    private final HeroKillRepository heroKillRepository;
    private final HeroSpellRepository heroSpellRepository;
    private final HeroItemRepository heroItemRepository;
    private final HeroDamageRepository heroDamageRepository;

    @Override
    public Long ingestMatch(String payload) {
        return matchParser.parseMatch(payload);
    }

    @Override
    public List<HeroKills> getMatchStats(Long matchId) {
        return  heroKillRepository.matchKills(matchId).
                stream().map(HeroKills::new).collect(Collectors.toList());
    }

    @Override
    public List<HeroSpells> getCastedSpellsByHero(Long matchId, String heroName) {
        return heroSpellRepository.heroSpells(matchId, heroName).
                stream().map(HeroSpells::new).collect(Collectors.toList());
    }

    @Override
    public List<HeroItems> getPurchaseSummary(Long matchId, String heroName) {
        return heroItemRepository.getPurchaseSummary(matchId, heroName).
                stream().map(HeroItems::new).collect(Collectors.toList());
    }

    @Override
    public List<HeroDamage> getDamageDoneByHero(Long matchId, String heroName) {
        return heroDamageRepository.getDamageDealtByHero(matchId, heroName).
                stream().map(HeroDamage::new).collect(Collectors.toList());
    }
}
