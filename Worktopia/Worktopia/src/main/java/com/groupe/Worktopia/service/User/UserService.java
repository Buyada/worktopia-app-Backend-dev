package com.groupe.Worktopia.service.User;

import com.groupe.Worktopia.entities.User;

import java.util.List;

public interface UserService {
    void addUser(User user);
    User getUser(int id);
    List<User> getUsers();
    void updateUser(Integer userId, User user);
    void deleteUser(Integer userId);

}
