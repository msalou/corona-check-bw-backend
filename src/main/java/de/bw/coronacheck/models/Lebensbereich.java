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
    private String step1Basisstufe;
    private String step2Warnstufe;
    private String step3AlarmstufeI;
    private String step4AlarmstufeII;

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
        return this.step1Basisstufe;
    }

    public String getStepWarnstufe() {
        return this.step2Warnstufe;
    }

    public String getStepAlarmstufeI() {
        return this.step3AlarmstufeI;
    }

    public String getStepAlarmstufeII() {
        return this.step4AlarmstufeII;
    }
}
