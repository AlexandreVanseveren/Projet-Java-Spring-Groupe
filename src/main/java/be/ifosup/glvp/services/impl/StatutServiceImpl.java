package be.ifosup.glvp.services.impl;

import be.ifosup.glvp.entities.Statut;
import be.ifosup.glvp.entities.User;
import be.ifosup.glvp.helpers.ToModel;
import be.ifosup.glvp.models.StatutDTO;
import be.ifosup.glvp.models.UserDTO;
import be.ifosup.glvp.repositories.StatutRepository;
import be.ifosup.glvp.services.StatutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class StatutServiceImpl implements StatutService {
    @Qualifier("statutRepository")
    @Autowired
    private StatutRepository statutRepository;

    @Override
    public Set<StatutDTO> getAll() {
        Set<Statut> entities = new HashSet<>(statutRepository.findAll());
        return ToModel.getStatusFromEntities(entities);
    }
    @Override
    public StatutDTO getById(long id) {
        Statut entity = statutRepository.findById(id);

        StatutDTO statut = entity == null ? null : ToModel.getStatutFromEntity(entity);

        return statut;
    }

}
