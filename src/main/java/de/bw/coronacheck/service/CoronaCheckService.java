package de.bw.coronacheck.service;

import org.springframework.stereotype.Service;

import de.bw.coronacheck.models.Alarmstufe;

@Service
public class CoronaCheckService {

    public Alarmstufe getCurrentAlarmstufe() {
        final Alarmstufe alarmstufe = new Alarmstufe();
        alarmstufe.setLabel("Alarmstufe II");
        alarmstufe.setDescription("Beschreibung II");
        return alarmstufe;
    }

}
