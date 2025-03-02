package com.groupe.Worktopia.service.User;

import com.groupe.Worktopia.entities.User;
import com.groupe.Worktopia.exception.ResourceExistException;
import com.groupe.Worktopia.exception.ResourceNotFoundException;
import com.groupe.Worktopia.repository.UserRepo;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    public final UserRepo userRepo;

    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }


    @Override
    public void addUser(User user) {
        Optional<User> checkUserIfExist = this.userRepo.findByEmail(user.getEmail());
        if(checkUserIfExist.isPresent())
            throw new ResourceExistException("The user already exist !");
        user.setCreatedAt(new Date());
        this.userRepo.save(user);
    }

    @Override
    public User getUser(int id) {

        return this.userRepo.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Record not found !"));

    }

    @Override
    public List<User> getUsers() {
        return this.userRepo.findAll();
    }

    @Override
    public void updateUser(Integer userId, User user) {
            User userUpdate = this.userRepo.findById(userId)
                    .orElseThrow(()->new ResourceNotFoundException("Record to update not found"));
            userUpdate.setUsername(user.getUsername());
            userUpdate.setEmail(user.getEmail());
            userUpdate.setMotdePasse(user.getMotdePasse());

            this.userRepo.saveAndFlush(userUpdate);
    }

    @Override
    public void deleteUser(Integer userId) {

        User userDelete = this.userRepo.findById(userId)
                .orElseThrow(()->new ResourceNotFoundException("Record to delete not found !"));
        this.userRepo.delete(userDelete);
    }
}
