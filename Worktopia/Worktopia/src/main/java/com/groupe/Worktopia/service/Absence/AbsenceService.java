package com.groupe.Worktopia.service.Absence;

import com.groupe.Worktopia.entities.Absence;

import java.util.List;
import java.util.Optional;

public interface AbsenceService {
    Absence addAbsence(Absence absence);
    List<Absence> getAllAbsence();
    Absence getAbsenceById(Long id);
    Absence updateAbsence(Absence newAbsence, Long id);
    void  deleteAbsence (Long id);

    Optional<Absence> findById(Long idAbsence);

    Absence save(Absence existingAbsence);
}