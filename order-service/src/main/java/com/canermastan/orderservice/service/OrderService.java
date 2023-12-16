package com.canermastan.orderservice.service;

import com.canermastan.orderservice.dto.OrderLineItemsDto;
import com.canermastan.orderservice.dto.OrderRequest;
import com.canermastan.orderservice.entity.OrderLineItems;

public interface OrderService {
    String placeOrder(OrderRequest orderRequest);
}
