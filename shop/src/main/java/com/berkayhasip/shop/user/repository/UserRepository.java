package com.berkayhasip.shop.user.repository;

import com.berkayhasip.shop.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User , Long> {
}
