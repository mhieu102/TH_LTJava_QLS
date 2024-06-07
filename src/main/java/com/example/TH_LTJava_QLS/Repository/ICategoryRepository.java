package com.example.TH_LTJava_QLS.Repository;

import com.example.TH_LTJava_QLS.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryRepository extends JpaRepository<Category, Long> {
}
