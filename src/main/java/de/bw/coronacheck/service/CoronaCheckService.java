package de.bw.coronacheck.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.bw.coronacheck.models.Alarmstufe;
import de.bw.coronacheck.models.Lebensbereich;
import de.bw.coronacheck.repository.AlarmstufeRepository;
import de.bw.coronacheck.repository.LebensbereichRepository;

@Service
public class CoronaCheckService {

    @Autowired
    private AlarmstufeRepository alarmstufeRepository;

    @Autowired
    private LebensbereichRepository lebensbereichRepository;

    public Alarmstufe getCurrentAlarmstufe() {
        return alarmstufeRepository.findById((long) 1).get();
    }

    public List<Lebensbereich> getLebensbereiche() {
        return lebensbereichRepository.findAll();
    }

}
