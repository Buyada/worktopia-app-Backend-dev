package com.groupe.Worktopia.service.payement;

import com.groupe.Worktopia.dto.BulletinPaieDto.BulletinPaieDto;
import com.groupe.Worktopia.entities.BulletinPaie;
import com.groupe.Worktopia.entities.Employe;

import java.util.List;

public interface PayementService {
    List<BulletinPaieDto> getAllBulletinPaie();
    public BulletinPaie genererBulletinPaie(Long idEmploye);
    public BulletinPaie updateBulletinPaie(Long bulletinId, BulletinPaie bulletinPaie);
    void deleteBulletinPaie(Long bulletinId);
    public BulletinPaie getBulletinPaieById(Long bulletinId);
}
