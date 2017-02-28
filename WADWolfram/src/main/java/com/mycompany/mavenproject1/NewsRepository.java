package com.mycompany.mavenproject1;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepository extends JpaRepository<New, Long>{
    public List<New> findByCategory(Category category);
    public New findByTitle(String title);
    public New findOne(long id);
    public List<New> findAll();
    
}