package be.ifosup.glvp.repositories;

import be.ifosup.glvp.entities.Product;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Gestion JPA pour les utilisateurs
 */

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    /**
     * Définit une fonction qui permet de récupérer un utilisateur sur base du username
     *
     * @param product
     * @return
     */
    Product findByProduct(String product); //1 Produit

    Product findById(long id); //Par id

//    @Query(value = "SELECT '*' FROM products order by peremption DESC")
//    List<Product> findAllProduct();

}