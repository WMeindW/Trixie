package cz.daniellinda.trixie.database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CastObceRep extends JpaRepository<CastObce, Long> {
}
