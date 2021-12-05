package de.bw.coronacheck.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.bw.coronacheck.models.Alarmstufe;
import de.bw.coronacheck.repository.CoronaCheckRepository;

@Service
public class CoronaCheckService {

    @Autowired
    private CoronaCheckRepository coronaCheckRepository;

    public Alarmstufe getCurrentAlarmstufe() {
        return coronaCheckRepository.findAll().get(0);
    }

}
