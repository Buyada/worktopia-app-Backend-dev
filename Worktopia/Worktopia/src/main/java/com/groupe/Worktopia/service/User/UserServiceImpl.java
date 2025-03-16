package com.groupe.Worktopia.service.User;

import com.groupe.Worktopia.dto.user.UserReqDTO;
import com.groupe.Worktopia.dto.user.UserResDTO;
import com.groupe.Worktopia.entities.Profil;
import com.groupe.Worktopia.entities.Role;
import com.groupe.Worktopia.entities.User;
import com.groupe.Worktopia.exception.ResourceExistException;
import com.groupe.Worktopia.exception.ResourceNotFoundException;
import com.groupe.Worktopia.mapper.UserMapper;
import com.groupe.Worktopia.repository.ProfilRepo;
import com.groupe.Worktopia.repository.RoleRepo;
import com.groupe.Worktopia.repository.UserRepo;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    public final UserRepo userRepo;
    public final UserMapper userMapper;
    public final RoleRepo roleRepo;
    public final ProfilRepo profilRepo;

    public UserServiceImpl(UserRepo userRepo, UserMapper userMapper, RoleRepo roleRepo, ProfilRepo profilRepo) {
        this.userRepo = userRepo;
        this.userMapper = userMapper;
        this.roleRepo = roleRepo;
        this.profilRepo = profilRepo;
    }


    @Override
    public void addUser(UserReqDTO userReqDTO) {
        Optional<User> checkUserIfExist = this.userRepo.findByEmail(userReqDTO.getEmail());
        if(checkUserIfExist.isPresent())
            throw new ResourceExistException("The user already exist !");

        Role role = this.roleRepo.findById(userReqDTO.getRoleId()).orElseThrow(()-> new ResourceNotFoundException("Role non trouve"));
        Profil profil = this.profilRepo.findById(userReqDTO.getProfilId()).orElseThrow(()-> new ResourceNotFoundException("Profile non trouve"));

        User user = this.userMapper.getUserFromUserReqDTO(userReqDTO);
        user.setCreatedAt(new Date());
        user.setRole(role);
        user.setProfil(profil);
        this.userRepo.save(user);
    }

    @Override
    public UserResDTO getUser(int id) {
    User user = this.userRepo.findById(id)
            .orElseThrow(()-> new ResourceNotFoundException("Record not found !"));
        return this.userMapper.getUserResRTOFromUser(user);

    }

    @Override
    public List<UserResDTO> getUsers() {
        List<User> users = this.userRepo.findAll();
        return this.userMapper.getUsersResDTOFromUsers(users);
    }

    @Override
    public void updateUser(Integer userId, UserReqDTO userReqDTO) {
            User userUpdate = this.userRepo.findById(userId)
                    .orElseThrow(()->new ResourceNotFoundException("Record to update not found"));
            userUpdate.setFirstname(userReqDTO.getFirstname());
            userUpdate.setLastname(userReqDTO.getLastname());
            userUpdate.setEmail(userReqDTO.getEmail());
             userUpdate.setNumeroTelephone(userReqDTO.getNumeroTelephone());
           userUpdate.setDateNaissance(userReqDTO.getDateNaissance());
           userUpdate.setAddresse(userReqDTO.getAddresse());
            userUpdate.setMotDePasse(userReqDTO.getMotDePasse());

            this.userRepo.saveAndFlush(userUpdate);
    }

    @Override
    public void deleteUser(Integer userId) {

        User userDelete = this.userRepo.findById(userId)
                .orElseThrow(()->new ResourceNotFoundException("Record to delete not found !"));
        this.userRepo.delete(userDelete);
    }
}
