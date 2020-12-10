package be.ifosup.glvp.services;


import be.ifosup.glvp.models.StatutDTO;

import java.util.Set;

public interface StatutService {
    Set<StatutDTO> getAll();
    StatutDTO getById(long id);
}
