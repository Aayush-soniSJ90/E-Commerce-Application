package dev.ayush.EcomProductServiceDec23.Exception;

public class CartNotFoundException extends RuntimeException{
    public CartNotFoundException(String message) {
        super(message);
    }
}
