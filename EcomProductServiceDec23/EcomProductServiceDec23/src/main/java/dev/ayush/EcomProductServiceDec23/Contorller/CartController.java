package dev.ayush.EcomProductServiceDec23.Contorller;

import dev.ayush.EcomProductServiceDec23.Client.FakeStoreClient;
import dev.ayush.EcomProductServiceDec23.Dto.FakeStoreDTO.FakeStoreCartResponseDTO;
import dev.ayush.EcomProductServiceDec23.Exception.CartNotFoundException;
import dev.ayush.EcomProductServiceDec23.Exception.RandomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CartController {

    @Autowired
    private FakeStoreClient fakeStoreClient;
    @GetMapping("/cart/{userId}")
    public ResponseEntity getCartForUser(@PathVariable("userId")  int userId){
        List<FakeStoreCartResponseDTO> cartResponse = fakeStoreClient.getCartByUserId(userId);
        if(cartResponse == null){
            throw new CartNotFoundException("Cart Not Found for userId: " + userId);
        }
        return ResponseEntity.ok(cartResponse);
    }

    @GetMapping("/cartexception")
    public ResponseEntity getCartException(){
        throw new RandomException("Exception from cart.");

    }


}
