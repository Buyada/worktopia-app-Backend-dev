package com.groupe.Worktopia.dto.BulletinPaieDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BulletinPaieDto {
    private double salaireBrut;

    private double salaireNet;

    private LocalDateTime dateGeneration;

    private LocalDateTime dateModification;


}
