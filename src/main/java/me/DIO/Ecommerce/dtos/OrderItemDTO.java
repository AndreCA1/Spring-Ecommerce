package me.DIO.Ecommerce.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import me.DIO.Ecommerce.model.CarItem;
import me.DIO.Ecommerce.model.OrderItem;
import me.DIO.Ecommerce.model.pk.CarItemPK;
import me.DIO.Ecommerce.model.pk.OrderItemPK;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class OrderItemDTO {
    @Schema(description = "Composite key(orderID and productID)")
    @EqualsAndHashCode.Include
    private OrderItemPK id;

    @NotNull(message = "Required field")
    private int quantity;

    @Schema(description = "Price of the product at the time of order")
    @NotNull(message = "Required field")
    private float unitPrice;

    public OrderItemDTO(OrderItem entity) {
        this.id = entity.getId();
        this.quantity = entity.getQuantity();
        this.unitPrice = entity.getUnitPrice();
    }
}
