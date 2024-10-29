package com.kairos.service;

import com.kairos.entity.UserProduct;
import com.kairos.repo.UserProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserProductService {
    @Autowired
    private UserProductRepo repo;

    public UserProduct findUserProduct(Long id) {
        UserProduct userProduct = repo.findById(id).orElseThrow();
        return userProduct;
    }

    public UserProduct saveUserProd() {
        UserProduct userProduct = new UserProduct();
        userProduct.setName("user_1");
        userProduct.setArea("hyd");
        userProduct.setStreet("kavuri_hills");
        userProduct.setPrice("1000");

        UserProduct save = repo.save(userProduct);
        return save;
    }
}
