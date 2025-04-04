package com.groupe.Worktopia.service.User;

import com.groupe.Worktopia.dto.user.UserReq2DTO;
import com.groupe.Worktopia.dto.user.UserReqDTO;
import com.groupe.Worktopia.dto.user.UserResDTO;
import com.groupe.Worktopia.entities.User;

import java.util.List;

public interface UserService {
    void addUser(UserReqDTO userReqDTO);
    UserResDTO getUser(int id);
    List<UserResDTO> getUsers();
    void updateUser(Integer userId, UserReq2DTO userReq2DTO);
    void deleteUser(Integer userId);

}
