package be.ifosup.glvp.services;


import be.ifosup.glvp.models.SubcatDTO;

import java.util.Set;

public interface SubcatService {
    Set<SubcatDTO> getAll();
}
