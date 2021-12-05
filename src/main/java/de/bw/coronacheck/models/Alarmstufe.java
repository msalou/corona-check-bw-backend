package de.bw.coronacheck.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Alarmstufe {
    @Id
    @GeneratedValue
    private Long id;
    private String label;
    private String description;

    public Long getId() {
        return this.id;
    }

    public String getLabel() {
        return this.label;
    }

    public String getDescription() {
        return this.description;
    }
}
