package gg.bayes.challenge.repositories;

import gg.bayes.challenge.db.model.HeroDealtDamageRecord;
import gg.bayes.challenge.repositories.projections.HeroDealtDamage;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface HeroDamageRepository extends CrudRepository<HeroDealtDamageRecord, Long> {

    @Query(value = "SELECT target_hero as target, count(target_hero) as damageInstances, SUM(damage) as totalDamage\n" +
            "from HERO_DEALT_DAMAGE\n" +
            "where hero_name = ?2 and match_id=?1 \n" +
            "Group by target_hero", nativeQuery = true)
    List<HeroDealtDamage> getDamageDealtByHero(Long matchId, String heroName);
}
