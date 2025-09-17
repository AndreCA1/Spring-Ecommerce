package me.DIO.Ecommerce.repository;

import me.DIO.Ecommerce.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    public Role findByAuthority(String roleOperator);
}
