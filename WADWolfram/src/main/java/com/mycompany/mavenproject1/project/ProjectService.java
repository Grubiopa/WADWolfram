package com.mycompany.mavenproject1.project;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
//import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.mavenproject1.donation.Donation;
import com.mycompany.mavenproject1.donation.DonationsRepository;
import com.mycompany.mavenproject1.user.User;

@Service
public class ProjectService {

	@Autowired
	private ProjectRepository projects;
	@Autowired
	private DonationsRepository movements;

	// private static final String FILES_FOLDER_PROJECTS = "files";

	public Project viewProject(long id) {
		return projects.findOne(id);
	}

	public List<Project> viewAllProjects() {
		return projects.findAll();
	}

	public Project deleteProject(long id) {
		// revisar
		Project p = projects.findOne(id);
		if (p != null) {
			for (Donation d : p.getDonations())
				movements.delete(d);
			projects.delete(p);
		}
		return p;
	}

	public Project donate(long projectId, Donation d) {
		Project p = projects.findOne(projectId);
		if (p != null) {
			movements.save(d);
			p.setParcialBudget(p.getParcialBudget() + d.getMoney());
			p.setRestBudget(p.getRestBudget() - d.getMoney());
			p.getDonations().add(d);
			projects.save(p);
		}
		return p;
	}

	public Project addNewProject(Project p) {
		projects.save(p);
		return p;

		/*
		 * String fileName = p.getId() + ".jpg"; if (!imagen.isEmpty()) { try {
		 * File filesFolder = new File(FILES_FOLDER_PROJECTS); if
		 * (!filesFolder.exists()) { filesFolder.mkdirs(); }
		 * 
		 * File uploadedFile = new File(filesFolder.getAbsolutePath(),
		 * fileName); imagen.transferTo(uploadedFile);
		 * }catch(IllegalStateException e){ e.printStackTrace(); } catch
		 * (IOException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } }
		 */
	}

	/*
	 * @RequestMapping("/imagep/{fileName}.jpg") public void
	 * handleFileDownload(@PathVariable String fileName, HttpServletResponse
	 * res) throws FileNotFoundException, IOException {
	 * 
	 * File file = new File(FILES_FOLDER_PROJECTS, fileName+".jpg");
	 * 
	 * if (file.exists()) { res.setContentType("imagep/jpeg");
	 * res.setContentLength(new Long(file.length()).intValue()); FileCopyUtils
	 * .copy(new FileInputStream(file), res.getOutputStream()); } else {
	 * res.sendError(404, "File" + fileName + "(" + file.getAbsolutePath() +
	 * ") does not exist"); } }
	 */

}
