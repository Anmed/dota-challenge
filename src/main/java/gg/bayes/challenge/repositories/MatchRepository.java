package gg.bayes.challenge.repositories;

import gg.bayes.challenge.db.model.MatchRecord;
import org.springframework.data.repository.CrudRepository;

public interface MatchRepository extends CrudRepository<MatchRecord, Long> {
}
