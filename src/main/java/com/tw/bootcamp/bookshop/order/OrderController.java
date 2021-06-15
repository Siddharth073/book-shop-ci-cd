package com.tw.bootcamp.bookshop.order;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @PostMapping("/orders")
    public ResponseEntity create(@RequestBody Order order) {
        return new ResponseEntity(new OrderResponse(1L), HttpStatus.CREATED);
    }
}
