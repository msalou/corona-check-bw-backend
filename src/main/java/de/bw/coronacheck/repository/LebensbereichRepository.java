package de.bw.coronacheck.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import de.bw.coronacheck.models.Lebensbereich;

@Repository
public interface LebensbereichRepository extends JpaRepository<Lebensbereich, Long> {
}