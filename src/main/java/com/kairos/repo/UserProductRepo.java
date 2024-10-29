package com.kairos.repo;

import com.kairos.entity.UserProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;

import java.util.List;

public interface UserProductRepo extends JpaRepository<UserProduct, Long> {
        List<UserProduct> findByIdBetween(Long start, Long end);

//    UserProduct findByName(String name);
    List<UserProduct> findByName(String name);
}
