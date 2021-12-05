package de.bw.coronacheck.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import de.bw.coronacheck.models.Alarmstufe;
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
      return ResponseEntity.ok().header("Content-Language", "DE").body(currentAlarmstufe);
    } catch (Exception exception) {
      logger.error(exception.getMessage(), exception);
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
  }

}