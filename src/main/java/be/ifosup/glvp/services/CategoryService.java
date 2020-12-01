package be.ifosup.glvp.services;

import be.ifosup.glvp.models.CategoryDTO;

import java.util.Set;

public interface CategoryService {
    Set<CategoryDTO> getAll();
}
