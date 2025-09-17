package me.DIO.Ecommerce.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import me.DIO.Ecommerce.model.pk.CarItemPK;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

@Entity
@Table(name = "tb_carItem")
public class CarItem {

    @EmbeddedId
    @EqualsAndHashCode.Include
    private CarItemPK id = new CarItemPK();

    private int quantity;
}
