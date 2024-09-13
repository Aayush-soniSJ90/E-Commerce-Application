package dev.ayush.EcomProductServiceDec23.Dto.FakeStoreDTO;


import dev.ayush.EcomProductServiceDec23.Dto.FakeStoreDTO.FakeStoreProductRatingDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductResponseDTO {
    private int id;
    private String title;
    private double price;
    private String description;
    private String category;
    private String imageUrl;
    private FakeStoreProductRatingDTO rating;

}
