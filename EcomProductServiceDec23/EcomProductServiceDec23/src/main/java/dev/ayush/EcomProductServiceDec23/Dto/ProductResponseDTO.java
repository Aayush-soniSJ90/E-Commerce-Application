package dev.ayush.EcomProductServiceDec23.Dto;


import dev.ayush.EcomProductServiceDec23.Entity.Category;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ProductResponseDTO implements Serializable {
    private int productId;
    private String title;
    private double price;
    private String description;
    private String category;
    private String imageURL;
    private double rating;
}
