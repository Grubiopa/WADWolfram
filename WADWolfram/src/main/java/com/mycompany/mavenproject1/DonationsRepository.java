package com.mycompany.mavenproject1;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DonationsRepository extends JpaRepository<Donation, Long> {

	List<Donation> findByuserId(Long userId);

}