package be.ifosup.glvp.repositories;

import be.ifosup.glvp.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

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
    Product findByProduct(String product);
    Product findById(long id);
}