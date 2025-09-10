package me.DIO.Ecommerce.repository;


import me.DIO.Ecommerce.model.User;
import me.DIO.Ecommerce.projections.UserDetailsProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query(nativeQuery = true,
            value = """
                    SELECT u.username as Username,
                           u.email as UserEmail,
                           u.password,
                           r.id as RoleId,
                           r.authority,
                           u.id as UserId 
                    FROM tb_user u 
                        INNER JOIN tb_user_role ur 
                                ON u.id = ur.user_id 
                                    INNER JOIN tb_role r 
                                        ON r.id = ur.role_id
                    WHERE u.username = :username
                   """
    )
    List<UserDetailsProjection> searchUserAndRoleByUsername(String username);
}
