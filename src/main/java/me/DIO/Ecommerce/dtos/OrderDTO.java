package me.DIO.Ecommerce.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import me.DIO.Ecommerce.model.Product;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class OrderDTO {
    @Schema(description = "Database generated ID Order")
    @EqualsAndHashCode.Include
    private long id;
    @Schema(description = "Date the order was made")
    @NotNull(message = "Required field")
    private Date date;
}
