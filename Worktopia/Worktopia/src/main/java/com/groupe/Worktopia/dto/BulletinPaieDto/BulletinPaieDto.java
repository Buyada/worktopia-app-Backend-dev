package com.groupe.Worktopia.dto.BulletinPaieDto;

import com.groupe.Worktopia.dto.EmployeDto.EmployeDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BulletinPaieDto {
   private Long bulletinId;

    private double salaireBrut;

    private double salaireNet;

    private LocalDateTime dateGeneration;

    private LocalDateTime dateModification;

    private EmployeDto employe;


}
