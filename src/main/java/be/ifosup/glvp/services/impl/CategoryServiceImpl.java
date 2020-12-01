package be.ifosup.glvp.services.impl;

import be.ifosup.glvp.entities.Category;
import be.ifosup.glvp.helpers.ToModel;
import be.ifosup.glvp.models.CategoryDTO;
import be.ifosup.glvp.repositories.CategoryRepository;
import be.ifosup.glvp.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Qualifier("categoryRepository")
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Set<CategoryDTO> getAll(){
        Set<Category> entities = new HashSet<>(categoryRepository.findAll());
        return ToModel.getCategegoriesFromEntities(entities);
    }
}