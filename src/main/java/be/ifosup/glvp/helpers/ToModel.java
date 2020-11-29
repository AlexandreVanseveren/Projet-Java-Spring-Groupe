package be.ifosup.glvp.helpers;

import be.ifosup.glvp.models.*;
import be.ifosup.glvp.entities.*;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class ToModel {

    // This method convert a Set of UserEntity to a Set of User Model
    public static Set<UserDTO> getUsersFromEntities(Set<User> entities) {
        return entities.stream()
                .map(userEntity -> UserDTO
                        .builder()
                        .id(userEntity.getId())
                        .firstname(userEntity.getFirstname())
                        .lastname(userEntity.getLastname())
                        .username(userEntity.getUsername())
                        .build()
                ).collect(Collectors.toSet());
    }

    public static UserDTO getUserFromEntity(User user) {
        UserDTO userD = UserDTO
                .builder()
                .id(user.getId())
                .firstname(user.getFirstname())
                .lastname(user.getLastname())
                .username(user.getUsername())
                .build();
        return userD;
    }

//    // This method convert a RoleEntity to a Role Model
//    public static Role getRoleFromEntity(Role entity){
//        return Role
//                .builder()
//                .id_user(entity.getId_user())
//                .role(entity.getRole())
//                .build();
//    }
//
//    // This method convert a Set of RoleEntity to a Set of Role Model
//    public static Set<Role> getRolesFromEntities(Set<Role> entities){
//        if(entities == null){
//            return new HashSet<>();
//        }
//
//        return entities.stream().map(roleEntity -> ToModel.getRoleFromEntity(roleEntity)).collect(Collectors.toSet());
//    }

}
