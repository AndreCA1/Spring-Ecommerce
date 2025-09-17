package me.DIO.Ecommerce.projections;

import java.util.Date;

public interface OrderItemDetailsProjection {
    int getQuantity();
    Long getOrderId();
    Long getProductId();
}
