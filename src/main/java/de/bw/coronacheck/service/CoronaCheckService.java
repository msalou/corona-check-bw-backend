package de.bw.coronacheck.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.bw.coronacheck.models.Alarmstufe;
import de.bw.coronacheck.models.AlarmstufeHistory;
import de.bw.coronacheck.models.Lebensbereich;
import de.bw.coronacheck.repository.AlarmstufeHistoryRepository;
import de.bw.coronacheck.repository.AlarmstufeRepository;
import de.bw.coronacheck.repository.LebensbereichRepository;

@Service
public class CoronaCheckService {

    @Autowired
    private AlarmstufeRepository alarmstufeRepository;

    @Autowired
    private AlarmstufeHistoryRepository alarmstufeHistoryRepository;

    @Autowired
    private LebensbereichRepository lebensbereichRepository;

    public Alarmstufe getCurrentAlarmstufe() {
        final LocalDateTime todayDate = LocalDateTime.now();
        final AlarmstufeHistory currentAlarmstufe = alarmstufeHistoryRepository.findAlarmstufeByDate(todayDate);
        return alarmstufeRepository.findById(currentAlarmstufe.getAlarmstufeId()).get();
    }

    public List<Lebensbereich> getLebensbereiche() {
        return lebensbereichRepository.findAll();
    }

}
