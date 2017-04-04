package ml.littleapp.security;

import java.util.Collection;
import java.util.Date;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Created by stephan on 20.03.16.
 */
public class JwtUser implements UserDetails {

    private final Long id;
    private final String username;
    private final String firstname;
    private final String lastname;
    private final String password;
    private final String email;
    private final Collection<? extends GrantedAuthority> authorities;
    private final Date lastPasswordResetDate;
    private final Boolean isExpired;
    private final Boolean isLocked;
    private final Boolean isCredentialsExpired;
    private final Boolean isEnabled;

	public JwtUser(
            Long id,
            String username,
            String firstname,
            String lastname,
            String email,
            String password,
            Collection<? extends GrantedAuthority> authorities,
            Date lastPasswordResetDate,
            Boolean isExpired,
            Boolean isLocked,
            Boolean isCredentialsExpired,
            Boolean isEnabled
      ) {
          this.id = id;
          this.username = username;
          this.firstname = firstname;
          this.lastname = lastname;
          this.email = email;
          this.password = password;
          this.authorities = authorities;
  		  this.lastPasswordResetDate = lastPasswordResetDate;
  		  this.isExpired = isExpired;
  		  this.isLocked = isLocked;
  		  this.isCredentialsExpired = isCredentialsExpired;
  		  this.isEnabled = isEnabled;
      }

    @JsonIgnore
    public Long getId() {
        return id;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return !isExpired;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return !isLocked;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return !isCredentialsExpired;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    @JsonIgnore
    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }

    @JsonIgnore
    public Date getLastPasswordResetDate() {
        return lastPasswordResetDate;
    }
}
