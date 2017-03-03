package com.mycompany.mavenproject1;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DonationsRepository extends JpaRepository<Movements, Long> {

List <Donation> findByUserNameAndProjectTitle(String userName, String projectTitle);
List<Donation> findByUserName(String userName);
List<Donation> findByProjectTitle(String projectTitle);
}