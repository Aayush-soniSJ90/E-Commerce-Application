package dev.ayush.EcomProductServiceDec23.Exception;

public class ProductNotFoundException extends RuntimeException{


    public ProductNotFoundException(String message) {
        super(message);
    }

}
