package gg.bayes.challenge.service.impl

import gg.bayes.challenge.parsers.MatchParser
import gg.bayes.challenge.repositories.HeroDamageRepository
import gg.bayes.challenge.repositories.HeroItemRepository
import gg.bayes.challenge.repositories.HeroKillRepository
import gg.bayes.challenge.repositories.HeroSpellRepository
import gg.bayes.challenge.repositories.projections.HeroKill
import gg.bayes.challenge.service.MatchService

import spock.lang.Specification

class MatchServiceImplTest extends Specification {

    private MatchService matchService
    private MatchParser matchParser
    private HeroKillRepository heroKillRepository
    private HeroSpellRepository heroSpellRepository
    private HeroItemRepository heroItemRepository
    private HeroDamageRepository heroDamageRepository
    private String testPayload
    private Long testMatchId


    void setup() {
        testPayload = "TEST"
        testMatchId = 1L
        matchParser = Mock(MatchParser)
        heroKillRepository = Mock(HeroKillRepository)
        heroSpellRepository = Mock(HeroSpellRepository)
        heroItemRepository = Mock(HeroItemRepository)
        heroDamageRepository = Mock(HeroDamageRepository)
        matchService = new MatchServiceImpl(matchParser, heroKillRepository,
                heroSpellRepository, heroItemRepository, heroDamageRepository)
    }

    def "IngestMatch"() {
        given:
        matchParser.parseMatch(testPayload) >> testMatchId
        when:
        def matchId = matchService.ingestMatch(testPayload)
        then:
        matchId == testMatchId
    }

    def "GetMatchStats"() {
        given:
        List<HeroKill> heroKills = new ArrayList<>()
        heroKillRepository.matchKills(testMatchId) >> heroKills
        when:
        def result = matchService.getMatchStats(testMatchId)
        then:
        result == heroKills
    }

    def "GetCastedSpellsByHero"() {
    }

    def "GetPurchaseSummary"() {
    }

    def "GetDamageDoneByHero"() {
    }
}
