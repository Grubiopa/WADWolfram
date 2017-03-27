package com.mycompany.mavenproject1.donation;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mycompany.mavenproject1.project.Project;
import com.mycompany.mavenproject1.user.User;

public interface DonationsRepository extends JpaRepository<Donation, Long> {
	
	List<Donation> findByuserId(Long userId);
	List<Donation> findByUser(User user);
	List<Donation> findByProject(Project project);

}
