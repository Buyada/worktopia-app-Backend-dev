package com.groupe.Worktopia.mapper;

import com.groupe.Worktopia.dto.EmployeDto.EmployeDto;
import com.groupe.Worktopia.entities.Employe;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-03-08T01:54:55+0100",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.14 (Amazon.com Inc.)"
)
@Component
public class EmployeMapperImpl implements EmployeMapper {

    @Override
    public Employe toEmploye(EmployeDto employeDto) {
        if ( employeDto == null ) {
            return null;
        }

        Employe employe = new Employe();

        return employe;
    }

    @Override
    public EmployeDto toDto(Employe employe) {
        if ( employe == null ) {
            return null;
        }

        EmployeDto employeDto = new EmployeDto();

        return employeDto;
    }

    @Override
    public List<EmployeDto> toDtoList(List<Employe> employes) {
        if ( employes == null ) {
            return null;
        }

        List<EmployeDto> list = new ArrayList<EmployeDto>( employes.size() );
        for ( Employe employe : employes ) {
            list.add( toDto( employe ) );
        }

        return list;
    }
}
