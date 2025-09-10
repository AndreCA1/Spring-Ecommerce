package me.DIO.Ecommerce.service;

import me.DIO.Ecommerce.model.Role;
import me.DIO.Ecommerce.model.User;
import me.DIO.Ecommerce.projections.UserDetailsProjection;
import me.DIO.Ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Transactional(readOnly = true)
    public UserDetailsProjection searchUserAndRoleByUsername(String username) {
        List<UserDetailsProjection> result = repository.searchUserAndRoleByUsername(username);
        if (result.isEmpty()) {
            throw new UsernameNotFoundException("User not found: " + username);
        }
        return result.get(0);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<UserDetailsProjection> result = repository.searchUserAndRoleByUsername(username);

        if (result.isEmpty()){
            throw new UsernameNotFoundException("User not found");
        }

        User user = new User();
        user.setUsername(result.get(0).getUsername());
        user.setEmail(result.get(0).getUserEmail());
        user.setPassword(result.get(0).getPassword());
        for (UserDetailsProjection p : result){
            user.addRole(new Role(p.getRoleId(), p.getAuthority()));
        }
        return user;
    }
}
