package com.groupe.Worktopia.mapper;

import com.groupe.Worktopia.dto.BulletinPaieDto.BulletinPaieDto;
import com.groupe.Worktopia.entities.BulletinPaie;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-03-08T00:03:15+0100",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.14 (Amazon.com Inc.)"
)
@Component
public class BulletinPaieMapperImpl implements BulletinPaieMapper {

    @Override
    public BulletinPaie toBulletinPaie(BulletinPaieDto bulletinPaieDto) {
        if ( bulletinPaieDto == null ) {
            return null;
        }

        BulletinPaie bulletinPaie = new BulletinPaie();

        return bulletinPaie;
    }

    @Override
    public BulletinPaieDto toBulletinPaieDto(BulletinPaie bulletinPaie) {
        if ( bulletinPaie == null ) {
            return null;
        }

        BulletinPaieDto bulletinPaieDto = new BulletinPaieDto();

        return bulletinPaieDto;
    }
}
