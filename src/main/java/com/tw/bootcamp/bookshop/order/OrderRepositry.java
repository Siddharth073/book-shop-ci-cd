package com.tw.bootcamp.bookshop.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepositry extends JpaRepository<Order, Long> {

}
