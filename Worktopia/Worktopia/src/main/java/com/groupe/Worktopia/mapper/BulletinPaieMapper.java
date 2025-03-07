package com.groupe.Worktopia.mapper;

import com.groupe.Worktopia.dto.BulletinPaieDto.BulletinPaieDto;
import com.groupe.Worktopia.entities.BulletinPaie;
import org.mapstruct.Mapper;
import org.springframework.context.annotation.Configuration;

@Mapper(componentModel = "spring")
@Configuration
public interface BulletinPaieMapper {
    BulletinPaie toBulletinPaie(BulletinPaieDto bulletinPaieDto);
    BulletinPaieDto toBulletinPaieDto(BulletinPaie bulletinPaie);

}
