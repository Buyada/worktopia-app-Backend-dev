package com.groupe.Worktopia.service.Absence;

import com.groupe.Worktopia.entities.Absence;
import com.groupe.Worktopia.entities.Categorie;
import com.groupe.Worktopia.entities.Permission;
import com.groupe.Worktopia.exception.ResourceExistException;
import com.groupe.Worktopia.exception.ResourceNotFoundException;
import com.groupe.Worktopia.repository.AbsenceRepo;
import org.springframework.stereotype.Service;

import java.util.Date;
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
        if (absence.getIdAbsence() != null) {
            Optional<Absence> AbsenceAdd = this.absenceRepo.findById(absence.getIdAbsence());
            if (AbsenceAdd.isPresent()) {
                throw new ResourceExistException("This absence already exists !");
            }
        }

        // Il faut que l'ID soit nul avant de sauvegarder pour qu'il soit auto-incrémenté par la base de données
        absence.setCreatedAt(new Date());
        return this.absenceRepo.save(absence);  // La base de données s'occupe de l'ID auto-incrémenté
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
        Absence absenceToDelete = this.absenceRepo.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("This absence was not found !"));
        this.absenceRepo.delete(absenceToDelete);
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
