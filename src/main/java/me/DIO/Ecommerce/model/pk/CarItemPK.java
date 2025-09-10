package me.DIO.Ecommerce.model.pk;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.DIO.Ecommerce.model.Product;
import me.DIO.Ecommerce.model.User;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Embeddable
public class CarItemPK {
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
