package com.example.demo.caterepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.category.Category;
@Repository
public interface CategoryRepo extends JpaRepository<Category,Integer>{

}
