package de.bw.coronacheck.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Lebensbereich {
    @Id
    @GeneratedValue
    private Long id;
    private String description;
    private String stepBasisstufe;
    private String stepWarnstufe;
    private String stepAlarmstufeI;
    private String stepAlarmstufeII;

    public void setId(final Long id) {
        this.id = id;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public Long getId() {
        return this.id;
    }

    public String getDescription() {
        return this.description;
    }

    public String getStepBasisstufe() {
        return this.stepBasisstufe;
    }

    public String getStepWarnstufe() {
        return this.stepWarnstufe;
    }

    public String getStepAlarmstufeI() {
        return this.stepAlarmstufeI;
    }

    public String getStepAlarmstufeII() {
        return this.stepAlarmstufeII;
    }
}
