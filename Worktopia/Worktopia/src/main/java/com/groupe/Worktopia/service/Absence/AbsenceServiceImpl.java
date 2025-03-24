package com.groupe.Worktopia.service.Absence;

import com.groupe.Worktopia.entities.Absence;
import com.groupe.Worktopia.entities.Permission;
import com.groupe.Worktopia.exception.ResourceNotFoundException;
import com.groupe.Worktopia.repository.AbsenceRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        Optional<Absence> absence = this.absenceRepo.findById(id);
        if (absence.isEmpty())
            throw new ResourceNotFoundException("Absence not found");
        return absence.get();
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

    @Override
    public Optional<Absence> findById(Long idAbsence) {
        return Optional.empty();
    }

    @Override
    public Absence save(Absence existingAbsence) {
        return null;
    }
}
