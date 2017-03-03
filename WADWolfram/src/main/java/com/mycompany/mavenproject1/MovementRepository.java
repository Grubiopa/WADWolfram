package com.mycompany.mavenproject1;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovementRepository extends JpaRepository<Movements, Long> {

public List <Donation> findByUserNameAndProjectTitle(String userName, String projectTitle);
public List<Donation> findByUserName(String userName);
public List<Donation> findByProjectTitle(String projectTitle);
}