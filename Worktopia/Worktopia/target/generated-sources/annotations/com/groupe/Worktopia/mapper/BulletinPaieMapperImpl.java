package com.groupe.Worktopia.mapper;

import com.groupe.Worktopia.dto.BulletinPaieDto.BulletinPaieDto;
import com.groupe.Worktopia.dto.EmployeDto.EmployeDto;
import com.groupe.Worktopia.entities.BulletinPaie;
import com.groupe.Worktopia.entities.Employe;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-03-09T15:44:34+0100",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.14 (Amazon.com Inc.)"
)
@Component
public class BulletinPaieMapperImpl implements BulletinPaieMapper {

    @Override
    public BulletinPaieDto toBulletinPaieDto(BulletinPaie bulletinPaie) {
        if ( bulletinPaie == null ) {
            return null;
        }

        Long bulletinId = null;
        EmployeDto employe = null;
        LocalDateTime dateModification = null;
        LocalDateTime dateGeneration = null;
        double salaireNet = 0.0d;
        double salaireBrut = 0.0d;

        bulletinId = bulletinPaie.getBulletinId();
        employe = toEmployeDto( bulletinPaie.getEmploye() );
        dateModification = bulletinPaie.getDateModification();
        dateGeneration = bulletinPaie.getDateGeneration();
        salaireNet = bulletinPaie.getSalaireNet();
        salaireBrut = bulletinPaie.getSalaireBrut();

        BulletinPaieDto bulletinPaieDto = new BulletinPaieDto( bulletinId, employe, dateModification, salaireNet, dateGeneration, salaireBrut );

        return bulletinPaieDto;
    }

    @Override
    public BulletinPaie toBulletinPaie(BulletinPaieDto bulletinPaieDto) {
        if ( bulletinPaieDto == null ) {
            return null;
        }

        Long bulletinId = null;
        Employe employe = null;
        LocalDateTime dateModification = null;
        LocalDateTime dateGeneration = null;
        double salaireNet = 0.0d;
        double salaireBrut = 0.0d;

        bulletinId = bulletinPaieDto.getBulletinId();
        employe = toEmploye( bulletinPaieDto.getEmploye() );
        dateModification = bulletinPaieDto.getDateModification();
        dateGeneration = bulletinPaieDto.getDateGeneration();
        salaireNet = bulletinPaieDto.getSalaireNet();
        salaireBrut = bulletinPaieDto.getSalaireBrut();

        BulletinPaie bulletinPaie = new BulletinPaie( bulletinId, employe, dateModification, salaireNet, dateGeneration, salaireBrut );

        return bulletinPaie;
    }

    @Override
    public List<BulletinPaieDto> toDtoList(List<BulletinPaie> bulletinPaieList) {
        if ( bulletinPaieList == null ) {
            return null;
        }

        List<BulletinPaieDto> list = new ArrayList<BulletinPaieDto>( bulletinPaieList.size() );
        for ( BulletinPaie bulletinPaie : bulletinPaieList ) {
            list.add( toBulletinPaieDto( bulletinPaie ) );
        }

        return list;
    }

    @Override
    public EmployeDto toEmployeDto(Employe employe) {
        if ( employe == null ) {
            return null;
        }

        Long idEmploye = null;
        String firstName = null;
        String lastName = null;
        String poste = null;
        double salaireBase = 0.0d;
        double prime = 0.0d;
        String email = null;

        idEmploye = employe.getIdEmploye();
        firstName = employe.getFirstName();
        lastName = employe.getLastName();
        poste = employe.getPoste();
        salaireBase = employe.getSalaireBase();
        prime = employe.getPrime();
        email = employe.getEmail();

        EmployeDto employeDto = new EmployeDto( idEmploye, email, prime, poste, salaireBase, lastName, firstName );

        return employeDto;
    }

    @Override
    public Employe toEmploye(EmployeDto employeDto) {
        if ( employeDto == null ) {
            return null;
        }

        Long idEmploye = null;
        String email = null;
        double prime = 0.0d;
        double salaireBase = 0.0d;
        String poste = null;
        String lastName = null;
        String firstName = null;

        idEmploye = employeDto.getIdEmploye();
        email = employeDto.getEmail();
        prime = employeDto.getPrime();
        salaireBase = employeDto.getSalaireBase();
        poste = employeDto.getPoste();
        lastName = employeDto.getLastName();
        firstName = employeDto.getFirstName();

        List<BulletinPaie> bulletinsPaie = null;
        LocalDateTime updatedAt = null;
        LocalDateTime createdAt = null;

        Employe employe = new Employe( bulletinsPaie, updatedAt, email, createdAt, prime, salaireBase, poste, lastName, firstName, idEmploye );

        return employe;
    }
}
