package com.groupe.Worktopia.mapper;

import com.groupe.Worktopia.dto.BulletinPaieDto.BulletinPaieDto;
import com.groupe.Worktopia.entities.BulletinPaie;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Mapper(componentModel = "spring")
@Configuration
public interface BulletinPaieMapper {

    BulletinPaie toBulletinPaie(BulletinPaieDto bulletinPaieDto);
  @Mapping(target = "employe", source = "employe")
    BulletinPaieDto toBulletinPaieDto(BulletinPaie bulletinPaie);
   // @Mapping//(target = "employe", source = "employe")
    List<BulletinPaieDto> toDtoLis(List<BulletinPaie> bulletinPaie);

}
