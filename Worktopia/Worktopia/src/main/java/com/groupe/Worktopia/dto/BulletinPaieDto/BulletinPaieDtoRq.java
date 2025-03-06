package com.groupe.Worktopia.dto.BulletinPaieDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BulletinPaieDtoRq {
    private double salaireBrut;

    private double salaireNet;

    private LocalDateTime dateGeneration;

    private LocalDateTime dateModification;


}
