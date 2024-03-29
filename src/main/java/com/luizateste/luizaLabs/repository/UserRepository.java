package com.luizateste.luizaLabs.repository;

import com.luizateste.luizaLabs.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<Users, String> {

    UserDetails findByLogin(String login);
}
