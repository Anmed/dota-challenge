package gg.bayes.challenge.db.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "match")
public class MatchRecord {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column(name = "execution_time", columnDefinition = "TIMESTAMP")
   private final LocalDateTime executionTime = LocalDateTime.now();

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      MatchRecord match = (MatchRecord) o;
      return id.equals(match.id) &&
              executionTime.equals(match.executionTime);
   }

   @Override
   public int hashCode() {
      return Objects.hash(id, executionTime);
   }

   @Override
   public String toString() {
      return "Match{" +
              "id=" + id +
              ", executionTime=" + executionTime +
              '}';
   }
}

