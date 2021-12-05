package de.bw.coronacheck.models;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class AlarmstufeHistory {
    @Id
    @GeneratedValue
    private Long id;
    private Long alarmstufeId;
    private LocalDateTime gueltigAb;
    private LocalDateTime gueltigBis;

    public Long getId() {
        return this.id;
    }

    public Long getAlarmstufeId() {
        return this.alarmstufeId;
    }

    public LocalDateTime getGueltigAb() {
        return this.gueltigAb;
    }

    public LocalDateTime getGueltigBis() {
        return this.gueltigBis;
    }
}
