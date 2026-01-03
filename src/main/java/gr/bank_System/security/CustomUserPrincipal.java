package gr.bank_System.security;

import gr.bank_System.core.enums.Role;
import gr.bank_System.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class CustomUserPrincipal implements UserDetails{

    private final String publicId;
    private final Long personId;
    private final Long userId;

    private final String username;
    private final String password;
    private final boolean active;

    private final Collection<? extends GrantedAuthority> authorities;

    private CustomUserPrincipal(
            String publicId,
            Long personId,
            Long userId,
            String username,
            String password,
            boolean active,
            Collection<? extends GrantedAuthority> authorities
    ) {
        this.publicId = publicId;
        this.personId = personId;
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.active = active;
        this.authorities = authorities;
    }

    public static CustomUserPrincipal fromForLogin(User user) {
        return new CustomUserPrincipal(
                user.getPublicId(),
                user.getPerson().getId(),
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                Boolean.TRUE.equals(user.getIsActive()),
                buildAuthorities(user.getRole())
        );
    }

    private static Collection<? extends GrantedAuthority> buildAuthorities(Role role) {
        return List.of(new SimpleGrantedAuthority("ROLE_" + role.name()));
    }


    public String getPublicId() { return publicId; }
    public Long getPersonId() { return personId; }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return active;

    }

}
