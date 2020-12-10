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

    public static Set<ProductDTO> getProductsFromEntities(Set<Product> entities) {
        return entities.stream()
                .map(productEntity -> ProductDTO
                        .builder()
                        .id(productEntity.getId())
                        .productname(productEntity.getProduct())
                        .rayon(productEntity.getRayon())
                        .peremption(productEntity.getPeremption())
                        .id_statfk(productEntity.getStat_name())
                        .id_subfk(productEntity.getSub_name())
                        .price(productEntity.getPrice())
                        .quantities(productEntity.getQuantities())
                        .build()
                ).collect(Collectors.toSet());
    }

    public static ProductDTO getProductFromEntity(Product product) {
        ProductDTO productD = ProductDTO
                .builder()
                .id(product.getId())
                .productname(product.getProduct())
                .rayon(product.getRayon())
                .peremption(product.getPeremption())
                .id_statfk(product.getStat_name())
                .id_subfk(product.getSub_name())
                .price(product.getPrice())
                .quantities(product.getQuantities())
                .build();
        return productD;
    }
    public static StatutDTO getStatutFromEntity(Statut statut) {
        StatutDTO statutDTO = StatutDTO
                .builder()
                .id(statut.getId_stat())
                .stat_name(statut.getStat_name())
                .build();
        return statutDTO;
    }


    public static Set<SubcatDTO> getSubcatsFromEntities(Set<Subcat> entities) {
        return entities.stream()
                .map( subcatEntity -> SubcatDTO
                                .builder()
                                .id(subcatEntity.getId_sub())
                                .subcat(subcatEntity.getSub_name())
                                .id_catfk(subcatEntity.getCat_name())
                                .build()
                ).collect(Collectors.toSet());
    }
    public static Set<StatutDTO> getStatusFromEntities(Set<Statut> entities) {
        return entities.stream()
                .map( statutEntity -> StatutDTO
                        .builder()
                        .id(statutEntity.getId_stat())
                        .stat_name(statutEntity.getStat_name())
                        .build()
                ).collect(Collectors.toSet());
    }
    public static Set<CategoryDTO> getCategegoriesFromEntities(Set<Category> entities) {
        return entities.stream()
                .map( categoryEntity -> CategoryDTO
                        .builder()
                        .id(categoryEntity.getId_cat())
                        .cat_name(categoryEntity.getCat_name())
                        .build()
                ).collect(Collectors.toSet());
    }
}
