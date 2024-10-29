package com.kairos.repo;

import com.kairos.entity.UserProduct;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class UserProductRepoTest {
    @Autowired
    private UserProductRepo repo;

    @Test
    public void saveEntity() {
        UserProduct userProduct = new UserProduct();
        userProduct.setName("user_1");
        userProduct.setArea("hyd");
        userProduct.setStreet("kavuri_hills");
        userProduct.setPrice("1000");

        UserProduct save = repo.save(userProduct);
        System.out.println(save);
    }

    @Test
    public void updateEntity() {
        UserProduct userProduct = repo.findById(1L).orElseThrow();
        userProduct.setName("UPDATED name!!!");
        userProduct.setPrice("updated price!!!");
        UserProduct save = repo.save(userProduct);
        System.out.println(save);
    }

    @Test
    public void saveAllTest() {
        UserProduct userProduct1 = new UserProduct();
        userProduct1.setName("user_1");
        userProduct1.setArea("hyd");
        userProduct1.setStreet("kavuri_hills");
        userProduct1.setPrice("1000");

        UserProduct userProduct2 = new UserProduct();
        userProduct2.setName("user_2");
        userProduct2.setArea("hnk");
        userProduct2.setStreet("banjara_hills");
        userProduct2.setPrice("2000");

        List<UserProduct> userProductList = List.of(userProduct1, userProduct2);

        ArrayList<UserProduct> userProducts = new ArrayList<>();
        userProducts.add(userProduct2);
        userProducts.add(userProduct1);

        List<UserProduct> savedUserProducts = repo.saveAll(userProducts);
        System.out.println(savedUserProducts);
    }

    @Test
    public void findAllTest() {
        List<UserProduct> all = repo.findAll();
        all.stream().map(UserProduct::getName).forEach(System.out::println);
    }

    @Test
    public void deleteAllWithEntityTest() {
        UserProduct userProduct = repo.findById(4L).orElseThrow();
        UserProduct userProduct1 = repo.findById(5L).orElseThrow();

        repo.deleteAll(List.of(userProduct, userProduct1));
    }

    @Test
    public void deleteAllTest() {
        repo.deleteAll();
    }

    @Test
    public void countMethodTest() {
        long count = repo.count();
        System.out.println("count::: " + count);
    }
    @Test
    public void existByIdTest() {
        boolean is_exist = repo.existsById(6L);
        System.out.println(is_exist);
    }
    @Test
    public void queryMethodTest() {
        List<UserProduct> byIdBetween = repo.findByIdBetween(1L, 8L);

         byIdBetween.stream().map(UserProduct::getName).forEach(System.out::println);
    }
    @Test
    public void queryMethodFindByName() {
        List<UserProduct> userProductList = repo.findByName("user_1");
        userProductList.stream().map(UserProduct::getId).forEach(System.out::println);
    }
}