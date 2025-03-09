package com.groupe.Worktopia.mapper;

import com.groupe.Worktopia.dto.BulletinPaieDto.BulletinPaieDto;
import com.groupe.Worktopia.dto.EmployeDto.EmployeDto;
import com.groupe.Worktopia.entities.BulletinPaie;
import com.groupe.Worktopia.entities.Employe;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-03-09T02:00:39+0100",
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

        bulletinPaie.setBulletinId( bulletinPaieDto.getBulletinId() );
        bulletinPaie.setSalaireBrut( bulletinPaieDto.getSalaireBrut() );
        bulletinPaie.setSalaireNet( bulletinPaieDto.getSalaireNet() );
        bulletinPaie.setDateGeneration( bulletinPaieDto.getDateGeneration() );
        bulletinPaie.setDateModification( bulletinPaieDto.getDateModification() );
        bulletinPaie.setEmploye( employeDtoToEmploye( bulletinPaieDto.getEmploye() ) );

        return bulletinPaie;
    }

    @Override
    public BulletinPaieDto toBulletinPaieDto(BulletinPaie bulletinPaie) {
        if ( bulletinPaie == null ) {
            return null;
        }

        BulletinPaieDto bulletinPaieDto = new BulletinPaieDto();

        bulletinPaieDto.setEmploye( employeToEmployeDto( bulletinPaie.getEmploye() ) );
        bulletinPaieDto.setBulletinId( bulletinPaie.getBulletinId() );
        bulletinPaieDto.setSalaireBrut( bulletinPaie.getSalaireBrut() );
        bulletinPaieDto.setSalaireNet( bulletinPaie.getSalaireNet() );
        bulletinPaieDto.setDateGeneration( bulletinPaie.getDateGeneration() );
        bulletinPaieDto.setDateModification( bulletinPaie.getDateModification() );

        return bulletinPaieDto;
    }

    @Override
    public List<BulletinPaieDto> toDtoLis(List<BulletinPaie> bulletinPaie) {
        if ( bulletinPaie == null ) {
            return null;
        }

        List<BulletinPaieDto> list = new ArrayList<BulletinPaieDto>( bulletinPaie.size() );
        for ( BulletinPaie bulletinPaie1 : bulletinPaie ) {
            list.add( toBulletinPaieDto( bulletinPaie1 ) );
        }

        return list;
    }

    protected Employe employeDtoToEmploye(EmployeDto employeDto) {
        if ( employeDto == null ) {
            return null;
        }

        Employe employe = new Employe();

        employe.setIdEmploye( employeDto.getIdEmploye() );
        employe.setFirstName( employeDto.getFirstName() );
        employe.setLastName( employeDto.getLastName() );
        employe.setPoste( employeDto.getPoste() );
        employe.setSalaireBase( employeDto.getSalaireBase() );
        employe.setPrime( employeDto.getPrime() );
        employe.setEmail( employeDto.getEmail() );

        return employe;
    }

    protected EmployeDto employeToEmployeDto(Employe employe) {
        if ( employe == null ) {
            return null;
        }

        EmployeDto employeDto = new EmployeDto();

        employeDto.setIdEmploye( employe.getIdEmploye() );
        employeDto.setFirstName( employe.getFirstName() );
        employeDto.setLastName( employe.getLastName() );
        employeDto.setPoste( employe.getPoste() );
        employeDto.setSalaireBase( employe.getSalaireBase() );
        employeDto.setPrime( employe.getPrime() );
        employeDto.setEmail( employe.getEmail() );

        return employeDto;
    }
}
