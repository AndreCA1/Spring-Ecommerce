package me.DIO.Ecommerce.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import me.DIO.Ecommerce.model.CarItem;
import me.DIO.Ecommerce.model.pk.CarItemPK;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class CarItemDTO {
    @Schema(description = "Composite key(userID and productID)")
    @EqualsAndHashCode.Include
    private CarItemPK id;

    @NotNull(message = "Required field")
    private int quantity;

    public CarItemDTO(CarItem entity) {
        this.id = entity.getId();
        this.quantity = entity.getQuantity();
    }
}
