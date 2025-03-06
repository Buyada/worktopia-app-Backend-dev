package com.groupe.Worktopia.service.payement;

import com.groupe.Worktopia.entities.BulletinPaie;
import com.groupe.Worktopia.entities.Employe;

public interface PayementService {
    public BulletinPaie genererBulletinPaie(Long idEmploye);
    public BulletinPaie updateBulletinPaie(Long bulletinId, BulletinPaie bulletinPaie);
    void deleteBulletinPaie(Long bulletinId);
    public BulletinPaie getBulletinPaieById(Long bulletinId);
}
