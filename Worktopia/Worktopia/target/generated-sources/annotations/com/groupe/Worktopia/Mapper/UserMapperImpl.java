package com.groupe.Worktopia.mapper;

import com.groupe.Worktopia.dto.user.UserReqDTO;
import com.groupe.Worktopia.dto.user.UserResDTO;
import com.groupe.Worktopia.entities.User;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-03-16T16:21:03+0100",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 23.0.1 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User getUserFromUserReqDTO(UserReqDTO userReqDTO) {
        if ( userReqDTO == null ) {
            return null;
        }

        User user = new User();

        user.setFirstname( userReqDTO.getFirstname() );
        user.setLastname( userReqDTO.getLastname() );
        user.setEmail( userReqDTO.getEmail() );
        user.setNumeroTelephone( userReqDTO.getNumeroTelephone() );
        user.setDateNaissance( userReqDTO.getDateNaissance() );
        user.setAddresse( userReqDTO.getAddresse() );
        user.setMotDePasse( userReqDTO.getMotDePasse() );

        return user;
    }

    @Override
    public UserResDTO getUserResRTOFromUser(User user) {
        if ( user == null ) {
            return null;
        }

        UserResDTO userResDTO = new UserResDTO();

        userResDTO.setUserId( user.getUserId() );
        userResDTO.setFirstname( user.getFirstname() );
        userResDTO.setLastname( user.getLastname() );
        userResDTO.setEmail( user.getEmail() );
        userResDTO.setNumeroTelephone( user.getNumeroTelephone() );
        userResDTO.setDateNaissance( user.getDateNaissance() );
        userResDTO.setAddresse( user.getAddresse() );
        userResDTO.setMotDePasse( user.getMotDePasse() );

        return userResDTO;
    }

    @Override
    public List<UserResDTO> getUsersResDTOFromUsers(List<User> users) {
        if ( users == null ) {
            return null;
        }

        List<UserResDTO> list = new ArrayList<UserResDTO>( users.size() );
        for ( User user : users ) {
            list.add( getUserResRTOFromUser( user ) );
        }

        return list;
    }

    @Override
    public UserReqDTO UpdateUserResRTOFromUser(User user) {
        if ( user == null ) {
            return null;
        }

        UserReqDTO userReqDTO = new UserReqDTO();

        userReqDTO.setFirstname( user.getFirstname() );
        userReqDTO.setLastname( user.getLastname() );
        userReqDTO.setEmail( user.getEmail() );
        userReqDTO.setNumeroTelephone( user.getNumeroTelephone() );
        userReqDTO.setDateNaissance( user.getDateNaissance() );
        userReqDTO.setAddresse( user.getAddresse() );
        userReqDTO.setMotDePasse( user.getMotDePasse() );

        return userReqDTO;
    }
}
