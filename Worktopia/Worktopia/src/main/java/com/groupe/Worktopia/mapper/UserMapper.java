package com.groupe.Worktopia.mapper;

import com.groupe.Worktopia.dto.user.UserReqDTO;
import com.groupe.Worktopia.dto.user.UserResDTO;
import com.groupe.Worktopia.entities.User;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
@Mapper(componentModel = "spring")
@Component
public interface UserMapper {
    User getUserFromUserReqDTO(UserReqDTO userReqDTO);

    List<UserResDTO> getUsersResDTOFromUsers(List<User> users);

    UserResDTO getUserResRTOFromUser(User user);




//    UserResDTO getUserResRTOFromUser(User user);
//    List<UserResDTO> getUsersResDTOFromUsers(List<User> users);
//    UserReqDTO UpdateUserResRTOFromUser(User user);
}
