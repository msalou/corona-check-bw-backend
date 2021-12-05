package de.bw.coronacheck.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.bw.coronacheck.models.Alarmstufe;
import de.bw.coronacheck.models.AlarmstufeHistory;
import de.bw.coronacheck.models.Lebensbereich;
import de.bw.coronacheck.models.Massnahme;
import de.bw.coronacheck.repository.AlarmstufeHistoryRepository;
import de.bw.coronacheck.repository.AlarmstufeRepository;
import de.bw.coronacheck.repository.LebensbereichRepository;

@Service
public class CoronaCheckService {

    private static final int STUFE_1 = 1;
    private static final int STUFE_2 = 2;
    private static final int STUFE_3 = 3;
    private static final int STUFE_4 = 4;

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

    public Massnahme getMassnahmeByLebensbereich(final Long lebensbereichId) throws RuntimeException {
        final Alarmstufe currentAlarmstufe = getCurrentAlarmstufe();
        final Lebensbereich lebensbereich = getLebensbereichById(lebensbereichId);
        switch (currentAlarmstufe.getId().intValue()) {
            case STUFE_1:
                return new Massnahme(lebensbereich.getStepBasisstufe());
            case STUFE_2:
                return new Massnahme(lebensbereich.getStepWarnstufe());
            case STUFE_3:
                return new Massnahme(lebensbereich.getStepAlarmstufeI());
            case STUFE_4:
                return new Massnahme(lebensbereich.getStepAlarmstufeII());
            default:
                throw new RuntimeException();
        }
    }

    private Lebensbereich getLebensbereichById(Long lebensbereichId) {
        return getLebensbereiche().stream().filter(lebensbereich -> lebensbereich.getId() == lebensbereichId).findFirst().orElseThrow(RuntimeException::new);
    }

}
