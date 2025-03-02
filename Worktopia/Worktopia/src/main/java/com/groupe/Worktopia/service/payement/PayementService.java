package com.groupe.Worktopia.service.payement;

import com.groupe.Worktopia.entities.BulletinPaie;
import com.groupe.Worktopia.entities.Employe;

public interface PayementService {
    public BulletinPaie genererBulletinPaie(Long employeId);
    void updateBulletinPaie(Long id, BulletinPaie bulletinPaie);
    void deleteBulletinPaie(Long id);
    public BulletinPaie getBulletinPaie(Long id);
}
