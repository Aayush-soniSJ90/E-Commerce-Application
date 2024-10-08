package dev.ayush.EcomProductServiceDec23.Dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class CategoryResponseDTO {
    private UUID categoryId;
    private String categoryName;
    private List<ProductResponseDTO> products;
}
