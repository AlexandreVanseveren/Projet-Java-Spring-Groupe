package be.ifosup.glvp.services.impl;


import be.ifosup.glvp.forms.UserForm;
import be.ifosup.glvp.helpers.ToModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import be.ifosup.glvp.entities.User;
import be.ifosup.glvp.models.UserDTO;
import be.ifosup.glvp.repositories.UserRepository;
import be.ifosup.glvp.services.UserService;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UsersServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UsersServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDTO create(UserForm userform) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encodePassword = bCryptPasswordEncoder.encode(userform.getPassword());
       User entity = User.builder()
                .username(userform.getUsername())
                .lastname(userform.getLastname())
                .firstname(userform.getFirstname())
                .password(encodePassword)
                .build();
        User user = userRepository.save(entity);
        return ToModel.getUserFromEntity(user);

    }

    @Override
    public void deleteById(long id) {
        try {
            userRepository.deleteById(id);
        } catch (Exception e) {
            System.out.println("Something went wrong.");
        }
    }

    @Override
    public UserDTO getById(long id) {
        User entity = userRepository.findById(id);

        UserDTO user = entity == null ? null : ToModel.getUserFromEntity(entity);

        return user;
    }

    @Override
    public UserDTO getUser(String username) {
        User user = userRepository.findByUsername(username); //recherche en fonction du username
        //Constructeur d'objet
        UserDTO userDTO = UserDTO.builder()
                .firstname(user.getFirstname())
                .lastname(user.getLastname())
                .id(user.getId())
                .username(user.getUsername())
                .build();

        return userDTO;
    }

    @Override
    public Set<UserDTO> getAll() {
        Set<User> entities = new HashSet<>(userRepository.findAll());
        return ToModel.getUsersFromEntities(entities);
    }

//    @Override
//    public List<UserDTO> getAll() {
//        List<User> entities = userRepository.findAll();
//
//        return entities.stream()
//                .map(userEntity -> UserDTO
//                        .builder()
//                        .id(userEntity.getId())
//                        .firstname(userEntity.getFirstname())
//                        .lastname(userEntity.getLastname())
//                        .build()
//                ).collect(Collectors.toList());
//    }
}
