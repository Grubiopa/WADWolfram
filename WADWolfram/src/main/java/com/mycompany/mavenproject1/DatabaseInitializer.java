package com.mycompany.mavenproject1;

import java.util.ArrayList;
import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.mycompany.mavenproject1.donation.Donation;
import com.mycompany.mavenproject1.donation.DonationsRepository;
import com.mycompany.mavenproject1.noticias.CommentClass;
import com.mycompany.mavenproject1.noticias.Noticia;
import com.mycompany.mavenproject1.noticias.NoticiasRepository;
import com.mycompany.mavenproject1.project.Project;
import com.mycompany.mavenproject1.project.ProjectRepository;
import com.mycompany.mavenproject1.user.UserPersonalData;
import com.mycompany.mavenproject1.user.UserPersonalDataRepository;

@Component
public class DatabaseInitializer {
	
	@Autowired
	private UserPersonalDataRepository users;
	@Autowired
	private ProjectRepository projects;
	@Autowired
	private DonationsRepository movements;
	@Autowired
	private NoticiasRepository noticias;
	
	@PostConstruct
	public void init() {

		  Date releaseDate = new Date();
		  //Projectos
		  projects.save(new Project("Titulo", "Breve Descripcion", "description", 500000.0, 0.0, 36, true, releaseDate, 2017,
					"image"));
		  projects.save(new Project("Titulo2", "Breve Descripcion2", "description2", 600.0, 0.0, 36, true, releaseDate,
					2017, "image"));
		  //Noticias
	        ArrayList<Long> coments = new ArrayList<>();
	        noticias.save(new Noticia("Noticia1", /*a,*/ "cuerpo", 0, "enfermedad", coments, releaseDate));
	        noticias.save(new Noticia("Noticia2", /*b,*/ "cuerpo2", 0, "eventos", coments, releaseDate));
	        
		//USER
		users.save(
				new UserPersonalData("Gabi", "R", "g.ru@yo.com", "gabi0794", "aaaa", "aaaa", "icon.png", "ROLE_ADMIN"));
		users.save(
				new UserPersonalData("Elnombre", "Elapellido", "e@e.es", "e", "e", "e", "icon.png", "ROLE_USER"));

		//DONACIONEs
		Date d = new Date();

		UserPersonalData u = users.findOne((long) 2);
		Project p = projects.findOne((long) 1);
		movements.save(new Donation(u, p, 50, d));
		movements.save(new Donation(u, p, 60, d));
		movements.save(new Donation(u, p, 40, d));
		p.setParcialBudget(p.getParcialBudget() + 150);
		p.setRestBudget(p.getRestBudget() - 150);
		projects.save(p);
		p = projects.findOne((long) 2);
		movements.save(new Donation(u, p, 10, d));
		p.setParcialBudget(p.getParcialBudget() + 10);
		p.setRestBudget(p.getRestBudget() - 10);
		projects.save(p);
	}
}
