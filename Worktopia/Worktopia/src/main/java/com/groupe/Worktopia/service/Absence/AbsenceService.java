package com.groupe.Worktopia.service.Absence;

import com.groupe.Worktopia.entities.Absence;

import java.util.List;

public interface AbsenceService {
    Absence addAbsence(Absence absence);
    List<Absence> getAllAbsence();
    Absence getAbsenceById(Long id);
    Absence updateAbsence(Absence newAbsence, Long id);
    void  deleteAbsence (Long id);

}