package de.bw.coronacheck.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import de.bw.coronacheck.models.Alarmstufe;
import de.bw.coronacheck.models.Lebensbereich;
import de.bw.coronacheck.service.CoronaCheckService;

@RestController
public class CoronaCheckController {

  private final Logger logger = LoggerFactory.getLogger(CoronaCheckController.class);

  @Autowired
  private CoronaCheckService coronaCheckService;

  @GetMapping("/getCurrentAlarmstufe")
  public ResponseEntity<Alarmstufe> getCurrentAlarmstufe() {
    try {
      logger.info("Load current Alarmstufe");
      final Alarmstufe currentAlarmstufe = coronaCheckService.getCurrentAlarmstufe();
      logger.info("Loading current Alarmstufe successful");
      return ResponseEntity.ok().body(currentAlarmstufe);
    } catch (Exception exception) {
      logger.error(exception.getMessage(), exception);
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
  }

  @GetMapping("/getLebensbereiche")
  public ResponseEntity<List<Lebensbereich>> getLebensbereiche() {
    try {
      logger.info("Load Lebensbereiche");
      final List<Lebensbereich> lebensbereiche = coronaCheckService.getLebensbereiche();
      logger.info("Loading Lebensbereiche successful");
      return ResponseEntity.ok().body(lebensbereiche);
    } catch (Exception exception) {
      logger.error(exception.getMessage(), exception);
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
  }

  @GetMapping("/getMassnahmeByLebensbereich/{lebensbereichId}")
  public ResponseEntity<String> getMassnahmeByLebensbereich(@PathVariable("lebensbereichId") String lebensbereichId) {
    try {
      logger.info("Load Massnahme");
      long lebensbereichIdLong = Long.parseLong(lebensbereichId);
      final String massnahme = coronaCheckService.getMassnahmeByLebensbereich(lebensbereichIdLong);
      logger.info("Loading Massnahme successful");
      return ResponseEntity.ok().body(massnahme);
    } catch (NumberFormatException numberFormatException) {
      logger.error(numberFormatException.getMessage(), numberFormatException);
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    } catch (Exception exception) {
      logger.error(exception.getMessage(), exception);
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
  }

}