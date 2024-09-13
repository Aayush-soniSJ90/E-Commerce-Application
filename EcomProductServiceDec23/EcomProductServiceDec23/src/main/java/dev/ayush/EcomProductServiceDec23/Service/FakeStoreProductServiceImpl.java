package dev.ayush.EcomProductServiceDec23.Service;

import dev.ayush.EcomProductServiceDec23.Client.FakeStoreClient;
import dev.ayush.EcomProductServiceDec23.Dto.FakeStoreDTO.FakeStoreProductResponseDTO;
import dev.ayush.EcomProductServiceDec23.Entity.Product;
import dev.ayush.EcomProductServiceDec23.Exception.NoProductPresentException;
import dev.ayush.EcomProductServiceDec23.Exception.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("fakeStoreProductService")
public class FakeStoreProductServiceImpl {

    @Autowired
    private FakeStoreClient fakeStoreClient;

    public List<FakeStoreProductResponseDTO> getAllProducts() {
        List<FakeStoreProductResponseDTO> fakeStoreProducts = fakeStoreClient.getAllProducts();
        if(fakeStoreProducts == null){
            throw new NoProductPresentException("No Products are Found.");
        }
        return fakeStoreProducts;
    }


    public FakeStoreProductResponseDTO getProduct(int ProductId) throws ProductNotFoundException {
        FakeStoreProductResponseDTO fakeStoreProductResponseDTO = fakeStoreClient.getProductById(ProductId);
        if(fakeStoreProductResponseDTO == null){
            throw new ProductNotFoundException("Product Not Found with id: "+ ProductId);
        }
        return fakeStoreProductResponseDTO;
    }


    public Product createProduct(Product product) {
        return null;
    }


    public Product updateProduct(Product product, int productId) {
        return null;
    }


    public boolean deleteProduct(int productId) {
        return false;
    }


}
