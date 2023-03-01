package com.shopping.client;

import com.shopping.stubs.order.Order;
import com.shopping.stubs.order.OrderRequest;
import com.shopping.stubs.order.OrderResponse;
import com.shopping.stubs.order.OrderServiceGrpc;
import io.grpc.Channel;

import java.util.List;
import java.util.logging.Logger;

public class OrderCLient {
    private Logger logger = Logger.getLogger(OrderCLient.class.getName());
    //get a stub object
    //call service method

    private OrderServiceGrpc.OrderServiceBlockingStub orderServiceBlockingStub;

    public OrderCLient(Channel channel){
        orderServiceBlockingStub = OrderServiceGrpc.newBlockingStub(channel);
    }

    public List<Order> getOrders(int userId){
        logger.info("Order Client is calling the OrderService method");
        OrderRequest orderRequest = OrderRequest.newBuilder()
                .setUserId(userId).build();
        OrderResponse orderResponse = orderServiceBlockingStub.getOrdersForUser(orderRequest);
        return orderResponse.getOrderList();
    }
}
