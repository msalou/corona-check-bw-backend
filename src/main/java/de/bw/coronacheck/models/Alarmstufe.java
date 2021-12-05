package de.bw.coronacheck.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Alarmstufe {
    @Id
    @GeneratedValue
    private String label;
    private String description;

    public String getLabel() {
        return this.label;
    }

    public String getDescription() {
        return this.description;
    }

    public void setLabel(final String label) {
        this.label = label;
    }

    public void setDescription(final String description) {
        this.description = description;
    }
}
