package be.ifosup.glvp.repositories;

import be.ifosup.glvp.entities.Product;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;


/**
 * Gestion JPA pour les utilisateurs
 */

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    /**
     * Définit une fonction qui permet de récupérer un utilisateur sur base du username
     *
     * @param
     * @return
     */

//    @Query(value = "SELECT '*' FROM products order by peremption DESC")
//    List<Product> findAllProduct();


    Product findByProduct(String product);
    Product findById(long id);
    @Query(nativeQuery =true, value = "SELECT * FROM products INNER JOIN subcat ON products.id_subfk = subcat.id_sub where id_catfk = (:fk)")
    List<Product> findAllById_subfk(@Param("fk") Long id_catfk);
    @Query(nativeQuery =true, value = "SELECT * FROM products where id_subfk = (:fk)")
    List<Product> findAllById_subcatfk(@Param("fk") Long id_subfk);
    @Query(nativeQuery =true, value = "SELECT * FROM products where id_statfk = (:fk)")
    List<Product> findAllById_statfk(@Param("fk") Long id_statfk);
}