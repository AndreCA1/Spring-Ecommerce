package me.DIO.Ecommerce.projections;

public interface UserDetailsProjection {
    String getUsername();
    String getUserEmail();
    String getPassword();
    Long getRoleId();
    String getAuthority();
    long getUserId();
}
