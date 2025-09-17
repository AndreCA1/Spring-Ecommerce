package me.DIO.Ecommerce.repository;

import me.DIO.Ecommerce.model.CarItem;
import org.springframework.data.jpa.repository.JpaRepository;

    public interface CarItemRepository extends JpaRepository<CarItem, Long> {
}
