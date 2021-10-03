package com.model;

import java.util.List;

import org.springframework.stereotype.Component;


@Component
public interface TmsDAO {
	
	public void save(Employee e);
	
	public List<Employee> empList(int id);
	
	public boolean update(Employee e);
	
	public void saveProject(Project p);
	
	public Project trackStatus(int id);
	
	public String closeProject(int id,String date, String projNotes);
	
	public boolean closeDate();
	
	public void saveTimesheet(TimeSheet t);
	
	public List<TimeSheet> findsheetDetails(int id);
	
	public boolean approveTimesheet(int id);

	public Employee findEmployee(int empId);

	public String update(int id,Employee e);
	
	public void saveRole(Roles r);

	public void saveTeam(Team t);
	
	public void saveClient(Client c);
	
	public void saveTeamMember(TeamMember tm);
	
	public List<Employee> empList();
}
