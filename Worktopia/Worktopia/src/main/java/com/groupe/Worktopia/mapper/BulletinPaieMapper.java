package com.groupe.Worktopia.mapper;

import com.groupe.Worktopia.dto.BulletinPaieDto.BulletinPaieDtoRq;
import com.groupe.Worktopia.dto.BulletinPaieDto.BulletinPaieDtoRs;
import com.groupe.Worktopia.entities.BulletinPaie;
import org.mapstruct.Mapper;
import org.springframework.context.annotation.Configuration;

@Mapper(componentModel = "spring")
@Configuration
public interface BulletinPaieMapper {
    BulletinPaie getBulletinPaieFromBulletinPaieDtoRq(BulletinPaieDtoRq bulletinPaieDtoRq);
    BulletinPaieDtoRs getBulletinPaieDtoRsFromBulletinPaie(BulletinPaie bulletinPaie);

}
