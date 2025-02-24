package com.groupe.Worktopia.service.Absence;

import com.groupe.Worktopia.entities.Absence;
import com.groupe.Worktopia.repository.AbsenceRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AbsenceServiceImpl implements AbsenceService {

    private final AbsenceRepo absenceRepo;

    public AbsenceServiceImpl(AbsenceRepo absenceRepo) {
        this.absenceRepo = absenceRepo;
    }

    @Override
    public Absence addAbsence(Absence absence) {
        return this.absenceRepo.save(absence);
    }

    @Override
    public List<Absence> getAllAbsence() {
        return this.absenceRepo.findAll();
    }

    @Override
    public Absence getAbsenceById(Long id) {
        return this.absenceRepo.findById(id).get();
    }

    @Override
    public Absence updateAbsence(Absence newAbsence, Long id) {
        Absence oldAbsence = this.absenceRepo.findById(id).get();
        oldAbsence.setNombreAbsence(newAbsence.getNombreAbsence());
        oldAbsence.setJustifiee(newAbsence.getJustifiee());
        return this.absenceRepo.saveAndFlush(oldAbsence);
    }

    @Override
    public void deleteAbsence(Long id) {
        this.absenceRepo.deleteById(id);
    } 
}
