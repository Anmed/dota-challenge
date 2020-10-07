package gg.bayes.challenge.repositories;

import gg.bayes.challenge.db.model.HeroItemRecord;
import gg.bayes.challenge.repositories.projections.HeroItem;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface HeroItemRepository extends CrudRepository<HeroItemRecord, Long> {

    @Query(value = "SELECT item_name as item, timestamp\n" +
            "from hero_bought_item\n" +
            "where hero_name= ?2 and match_id = ?1", nativeQuery = true)
    List<HeroItem> getPurchaseSummary(Long matchId, String heroName);
}
