package be.ifosup.glvp.services;

import be.ifosup.glvp.models.ProductDTO;
import be.ifosup.glvp.forms.ProductForm;


import java.util.List;
import java.util.Set;

//Objet créer en fonction du login
public interface ProductService {
    ProductDTO getprodname(String prodname);
    Set<ProductDTO> getAll();
    ProductDTO getById(long id);
    void deleteById(long id);
    ProductDTO create(ProductForm productform);
}
