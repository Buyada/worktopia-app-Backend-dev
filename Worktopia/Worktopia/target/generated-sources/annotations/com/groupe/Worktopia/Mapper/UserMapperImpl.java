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
    date = "2025-04-05T18:14:28+0100",
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

        return user;
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
    public UserResDTO getUserResRTOFromUser(User user) {
        if ( user == null ) {
            return null;
        }

        UserResDTO userResDTO = new UserResDTO();

        return userResDTO;
    }
}
