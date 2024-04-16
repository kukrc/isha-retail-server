package com.isha.retail.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Getter
@Setter
@EqualsAndHashCode
@Document(collection = "Product")
@NoArgsConstructor
@ToString
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String _id;
    private String name;
    private String description;
    private String features;
    private String price;
    private String keywords;
    private String url;
    private String category;
    private String subcategory;
}
