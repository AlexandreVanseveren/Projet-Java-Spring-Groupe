package be.ifosup.glvp.services;


import be.ifosup.glvp.models.ProductDTO;
import be.ifosup.glvp.forms.ProductForm;


import java.sql.Array;
import java.util.List;
import java.util.Set;

public interface ProductService {
    ProductDTO getprodname(String prodname);
    Set<ProductDTO> getByCategory(long id);
    Set<ProductDTO> getBysubCategory(long Id);
    Set<ProductDTO> getBystatut(long Id);
    Set<ProductDTO> getAll();
    ProductDTO getById(long id);
    void deleteById(long id);
    ProductDTO create(ProductForm productform);
    ProductDTO update(ProductForm productForm);
}
