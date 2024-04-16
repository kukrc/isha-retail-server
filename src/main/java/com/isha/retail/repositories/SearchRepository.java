package com.isha.retail.repositories;

import com.isha.retail.models.Product;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class SearchRepository implements ISearchRepository{

    @Autowired
    MongoClient client;

    @Autowired
    MongoConverter converter;

    @Override
    public List<Product> findProductsByText(String text) {
        List<Product> products = new ArrayList<>();
        MongoDatabase database =  client.getDatabase("isharetaildb");
        MongoCollection<Document> collection = database.getCollection("Product");
        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search",
                        new Document("index", "product-search")
                                .append("text",
                                        new Document("query", text)
                                                .append("path", Arrays.asList("category", "keywords", "features", "subcategory", "url")))),
                new Document("$sort",
                        new Document("price", 1L)),
                new Document("$limit", 5L)));
        result.forEach((doc)-> {
            products.add(converter.read(Product.class, doc));
        });
        return products;
    }
}
