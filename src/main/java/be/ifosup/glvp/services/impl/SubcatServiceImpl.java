package be.ifosup.glvp.services.impl;

import be.ifosup.glvp.entities.Subcat;
import be.ifosup.glvp.helpers.ToModel;
import be.ifosup.glvp.models.SubcatDTO;
import be.ifosup.glvp.repositories.SubcatRepository;
import be.ifosup.glvp.services.SubcatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
@Service
public class SubcatServiceImpl implements SubcatService {
    @Qualifier("subcatRepository")
    @Autowired
    private SubcatRepository subcatRepository;

    @Override
    public Set<SubcatDTO> getAll() {
        Set<Subcat> entities = new HashSet<>(subcatRepository.findAll());
        return ToModel.getSubcatsFromEntities(entities);
    }
}
