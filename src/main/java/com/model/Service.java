package com.model;



import java.util.List;

import javax.management.relation.Role;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class Service {

	@Autowired
	TmsDAO tmsDAOImpl;

	public void save(Employee e) {
		tmsDAOImpl.save(e);
	}

	public List<Employee> empList(int id){
		return tmsDAOImpl.empList(id);

	}



	public String update(int id,Employee e) {
		return tmsDAOImpl.update(id,e);



	}

	public void saveProject(Project p) {
		tmsDAOImpl.saveProject(p);
	}

	public Project  trackStatus(int id) {
		return tmsDAOImpl.trackStatus(id);



	}

	public String closeProject(int id,String date, String projNotes) {
		return tmsDAOImpl.closeProject(id, date, projNotes);



	}

	public void saveTimesheet(TimeSheet t) {
		tmsDAOImpl.saveTimesheet(t);



	}

	public List<TimeSheet> findsheetDetails(int id) {
		return tmsDAOImpl.findsheetDetails(id);



	}

	public boolean approveTimesheet(int id) {
		return tmsDAOImpl.approveTimesheet(id);



	}
	public Employee findEmployee(int empId) {
		// TODO Auto-generated method stub


		return tmsDAOImpl.findEmployee(empId);
	}

	public Employee getEmployeeById(int empId) {
		// TODO Auto-generated method stub
		return null;
	}

	public void saveRole(Roles r) {
		tmsDAOImpl.saveRole(r);
	}
	public void saveTeam(Team t) {
		tmsDAOImpl.saveTeam(t);
	}
	public void saveClient(Client c) {
		tmsDAOImpl.saveClient(c);
	}
	public void saveTeamMember(TeamMember tm) {
		tmsDAOImpl.saveTeamMember(tm);
	}

	public List<Employee> empList(){
		return tmsDAOImpl.empList();
	}



}