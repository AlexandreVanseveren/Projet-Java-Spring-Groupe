package be.ifosup.glvp.repositories;



import be.ifosup.glvp.entities.Subcat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubcatRepository extends JpaRepository<Subcat, Long> {
    Subcat findById(long id);
}
