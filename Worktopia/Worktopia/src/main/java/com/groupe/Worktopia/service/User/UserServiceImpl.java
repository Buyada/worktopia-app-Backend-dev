package com.groupe.Worktopia.service.User;

import com.groupe.Worktopia.dto.profil.ProfilReqDTO;
import com.groupe.Worktopia.dto.profil.ProfilResDTO;
import com.groupe.Worktopia.dto.role.RoleResDTO;
import com.groupe.Worktopia.dto.user.UserReq2DTO;
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
import com.groupe.Worktopia.service.Profil.ProfilServiceImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepo userRepo;
    private final UserMapper userMapper;
    private final RoleRepo roleRepo;
    private final ProfilRepo profilRepo;
    private  final ProfilServiceImpl profilServiceImpl;
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public UserServiceImpl(UserRepo userRepo, UserMapper userMapper, RoleRepo roleRepo, ProfilRepo profilRepo, ProfilServiceImpl profilServiceImpl) {
        this.userRepo = userRepo;
        this.userMapper = userMapper;
        this.roleRepo = roleRepo;
        this.profilRepo = profilRepo;
        this.profilServiceImpl = profilServiceImpl;
    }


    @Override
    public void addUser(UserReqDTO userReqDTO) {
        Optional<User> checkUserIfExist = this.userRepo.findByEmail(userReqDTO.getEmail());
        if(checkUserIfExist.isPresent())
            throw new ResourceExistException("The user already exist !");

        Role role = this.roleRepo.findById(userReqDTO.getRoleId()).orElseThrow(()-> new ResourceNotFoundException("Role non trouve"));
//        Profil profil = this.profilRepo.findById(userReqDTO.getProfilId()).orElseThrow(()-> new ResourceNotFoundException("Profile non trouve"));




        User user = this.userMapper.getUserFromUserReqDTO(userReqDTO);
        user.setCreatedAt(new Date());
        user.setMotDePasse(encoder.encode(userReqDTO.getMotDePasse()));
        user.setRole(role);
//        user.set
//        user.setProfil(profil);

       User savedUser =  this.userRepo.save(user);
       Integer etId = savedUser.getUserId();
        this.profilServiceImpl.addProfil(userReqDTO.getProfilReqDTO(), etId);

//        this.profilServiceImpl.setProfile(savedUser);

    }

    @Override
    public UserResDTO getUser(int id) {
    User user = this.userRepo.findById(id)
            .orElseThrow(()-> new ResourceNotFoundException("Record not found !"));


        // Mapper vers le DTO
        UserResDTO userResDTO = new UserResDTO();
        userResDTO.setUsername(user.getUsername());
        userResDTO.setMotDePasse(user.getMotDePasse());
        userResDTO.setEmail(user.getEmail());

        if (user.getRole() != null) {
            RoleResDTO roleDTO = new RoleResDTO();
            roleDTO.setRoleId(user.getRole().getRoleId());
            roleDTO.setRolename(user.getRole().getRolename());
            userResDTO.setRoleResDTO(roleDTO);
        }

        if (user.getProfil() != null) {
            ProfilResDTO profileDTO = new ProfilResDTO();
            profileDTO.setProfilId(user.getProfil().getProfilId());
            profileDTO.setFirstname(user.getProfil().getFirstname());
            profileDTO.setLastname(user.getProfil().getLastname());
            profileDTO.setNumerotelephone(user.getProfil().getNumerotelephone());
            profileDTO.setAdresse(user.getProfil().getAdresse());
            profileDTO.setDatedenaissance(user.getProfil().getDatedenaissance());
            profileDTO.setGenre(user.getProfil().getGenre());
            profileDTO.setPhotodeprofil(user.getProfil().getPhotodeprofil());
            profileDTO.setCv(user.getProfil().getCv());
            userResDTO.setProfilResDTO(profileDTO);
        }
//        return this.userMapper.getUserResRTOFromUser(user);
        return userResDTO;

    }

    @Override
    public List<UserResDTO> getUsers() {
//        List<User> users = this.userRepo.findAll();
//        return this.userMapper.getUsersResDTOFromUsers(users);

        List<User> users = userRepo.findAll();
        List<UserResDTO> userResDTOs = new ArrayList<>();
        for (User user : users) {
            // Mapper vers le DTO
            UserResDTO userResDTO = new UserResDTO();
            userResDTO.setUsername(user.getUsername());
            userResDTO.setMotDePasse(user.getMotDePasse());
            userResDTO.setEmail(user.getEmail());

            if (user.getRole() != null) {
                RoleResDTO roleDTO = new RoleResDTO();
                roleDTO.setRoleId(user.getRole().getRoleId());
                roleDTO.setRolename(user.getRole().getRolename());
                userResDTO.setRoleResDTO(roleDTO);
            }

            if (user.getProfil() != null) {
                ProfilResDTO profileDTO = new ProfilResDTO();
                profileDTO.setProfilId(user.getProfil().getProfilId());
                profileDTO.setFirstname(user.getProfil().getFirstname());
                profileDTO.setLastname(user.getProfil().getLastname());
                profileDTO.setNumerotelephone(user.getProfil().getNumerotelephone());
                profileDTO.setAdresse(user.getProfil().getAdresse());
                profileDTO.setDatedenaissance(user.getProfil().getDatedenaissance());
                profileDTO.setGenre(user.getProfil().getGenre());
                profileDTO.setPhotodeprofil(user.getProfil().getPhotodeprofil());
                profileDTO.setCv(user.getProfil().getCv());
                userResDTO.setProfilResDTO(profileDTO);
            }
            userResDTOs.add(userResDTO);
        }
        return userResDTOs;
    }

    @Override
    public void updateUser(Integer userId, UserReq2DTO userReq2DTO) {
            User userUpdate = this.userRepo.findById(userId)
                    .orElseThrow(()->new ResourceNotFoundException("Record to update not found"));
            userUpdate.setUsername(userReq2DTO.getUsername());
            userUpdate.setEmail(userReq2DTO.getEmail());
        userUpdate.setMotDePasse(userReq2DTO.getMotDePasse());


            this.userRepo.saveAndFlush(userUpdate);
    }

    @Override
    public void deleteUser(Integer userId) {

        User userDelete = this.userRepo.findById(userId)
                .orElseThrow(()->new ResourceNotFoundException("Record to delete not found !"));
        this.userRepo.delete(userDelete);
    }
}
