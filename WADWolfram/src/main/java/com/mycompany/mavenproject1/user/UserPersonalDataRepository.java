package com.mycompany.mavenproject1.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserPersonalDataRepository extends JpaRepository<UserPersonalData, Long> {
	
	UserPersonalData findByEmail(String email);
	
}