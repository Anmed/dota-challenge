package gg.bayes.challenge.repositories;

import gg.bayes.challenge.db.model.HeroKillRecord;
import gg.bayes.challenge.repositories.projections.HeroKill;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface HeroKillRepository extends CrudRepository<HeroKillRecord, Long> {

    @Query(value = "Select killer_name as hero, Count(killer_name) as kills from hero_kills where match_id=?1" +
            " GROUP BY killer_name", nativeQuery = true)
    List<HeroKill> matchKills(Long matchId);

}
