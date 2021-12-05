package de.bw.coronacheck.models;

public class Alarmstufe {
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
