package de.bw.coronacheck.repository;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import de.bw.coronacheck.models.AlarmstufeHistory;

@Repository
public interface AlarmstufeHistoryRepository extends JpaRepository<AlarmstufeHistory, Long> {

     @Query(value = "FROM AlarmstufeHistory WHERE :todayDate BETWEEN gueltigAb AND gueltigBis")
     public AlarmstufeHistory findAlarmstufeByDate(@Param("todayDate") final LocalDateTime todayDate);

}