package com.isha.retail.services;

import com.isha.retail.models.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {

    List<Product> getAllProducts();

    public List<Product> searchByText(String text);

    Optional<Product> getProductById(int id);

    Product saveProduct(Product product);

    void deleteProduct(int id);

    void updateProduct(Product product);

}
