package com.isha.retail.repositories;

import com.isha.retail.models.Product;

import java.util.List;

public interface ISearchRepository {

    List<Product> findProductsByText(String text);
}
