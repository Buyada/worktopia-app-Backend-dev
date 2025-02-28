package com.groupe.Worktopia.service.payement;

import com.groupe.Worktopia.entities.BulletinPaie;
import com.groupe.Worktopia.entities.Employe;

public interface PayementService {
    public BulletinPaie genererBulletinPaie(Employe employe);
}
