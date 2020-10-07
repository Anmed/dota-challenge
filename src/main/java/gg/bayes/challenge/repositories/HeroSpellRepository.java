package gg.bayes.challenge.repositories;

import gg.bayes.challenge.db.model.HeroCastedSpellRecord;
import gg.bayes.challenge.repositories.projections.HeroSpell;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface HeroSpellRepository extends CrudRepository<HeroCastedSpellRecord, Long> {
    //spell, count(times) casts
    @Query(value = "Select ability_name as spell, Count(ability_name) as casts from hero_spell" +
            " where match_id=?1 and hero_name = ?2 GROUP BY ability_name", nativeQuery = true)
    List<HeroSpell> heroSpells(Long matchId, String heroName);
}