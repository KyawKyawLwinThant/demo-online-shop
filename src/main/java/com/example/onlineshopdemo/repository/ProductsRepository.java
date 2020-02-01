package com.example.onlineshopdemo.repository;

import com.example.onlineshopdemo.domain.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductsRepository extends JpaRepository<Products,Integer> {

    List<Products> findByCategory_Id(int id);

    @Query("select p from Products p where  p.category.id=:id")
    List<Products> findProductsByCategoryId(@Param("id") int id);
}
