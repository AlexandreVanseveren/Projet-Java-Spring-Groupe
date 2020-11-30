package be.ifosup.glvp.repositories;


import be.ifosup.glvp.entities.Statut;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatutRepository extends JpaRepository<Statut, Long> {
    Statut findById(long id);
}
