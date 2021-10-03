package com.model;



import java.util.List;

import javax.management.relation.Role;
import javax.transaction.*;
//import javax.transaction.*;

import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class TmsDAOImpl implements TmsDAO{

	@Autowired
	SessionFactory sessionFactory;
	
	Project p;
	Employee e;
	TimeSheet t;
	Client c;
	Team team;
	Role r;
	@Override
	public void save(Employee e)  {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		// Employee e1=new Employee("vandana","483","20/09/2021","java","B1","notes","vandana@cap.com","1234567890","vandana","1234",t);
		
			session.save(e);
		
		session.flush();
		//session.close();
		tx.commit();
	}



	@Override
	public List<Employee> empList(int id) {
		// TODO Auto-generated method stub

		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		List<Employee> emplist=session.createQuery("select i from Employee i where emp_id=id").list();
		// TODO Auto-generated method stub
		return emplist;
	}

	@Override
	public List<Employee> empList() {
		// TODO Auto-generated method stub

		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		List<Employee> emplist=session.createQuery("select i from Employee i ").list();
		// TODO Auto-generated method stub
		return emplist;
	}


	@Override
	public String update(int id,Employee e) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		
		Employee e1=findEmployee(id);
		e1.setEmpName(e.getEmpName());
		
		session.update(e1);
		tx.commit();
		return "employee details updated";
		
		
//		session.update(e);
//		session.flush();
//		tx.commit();
//		session.close();
//		
//		// TODO Auto-generated method stub
//		return true;

	}



	@Override
	public void saveProject(Project p) {
		System.out.println(p);
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		System.out.println(p);
		//Project p1=new Project(c,team,"payroll","raj","brief","sai","sai@gmail.com","123","3345","8080","kiran","Adi","notes","20/09/2021","20/10/2021","started");
		session.save(p);
		System.out.println("c");
		session.flush();
		tx.commit();
		//session.close();
		
	}



	@Override
public Project trackStatus(int id) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
	/*	 String status=session.getQueryString("select project_status from project i where project_ID=id");
		*/
//		Query Projectlist=session.createQuery("select i from Project i ");
//
//		Project p=ProjectList;
		
		
		Project e=session.get(Project.class,id);
		tx.commit();
			
		
		
		return e;

	}



	@Override
	public String closeProject(int id,String date, String projNotes) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		
		
		Project p=session.get(Project.class, id);
		p.setProject_status("close");
		p.setProject_end_date(date);
		p.setProject_notes(projNotes);
		session.update(p);
		tx.commit();
		
		return p.getProject_status();
	}

	@Override
	public boolean closeDate() {
		
		return false;
	}



	@Override
	public boolean approveTimesheet(int id) {
		// TODO Auto-generated method stub
		
		return true;

	}



	@Override
	public void saveTimesheet(TimeSheet t) {
		
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		// TimeSheet t1=new TimeSheet( (List<Project>) p ,e,"payroll","2/09/2021","4","yes","raj","not complete","NA","done","NA","Activity");
		session.save(t);
		session.flush();
		tx.commit();
		session.close();

	}



	@Override
	public List<TimeSheet> findsheetDetails(int id) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		List<TimeSheet> timeSheetlist=session.createQuery("select i from TimeSheet i where time_sheetid=id").list();
		
		return timeSheetlist;
	}



	@Override
	public Employee findEmployee(int id) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		Employee e=session.get(Employee.class,id);
		tx.commit();
		session.close();
		System.out.println(e);
		
		
		
//		List<Employee> timeSheetlist=session.createQuery("select i from Employee i where empId=id").list();
//		String str="gfds";
//		Employee t=new Employee();
//		timeSheetlist.get(id).setEmp_password(str);
//		System.out.println(timeSheetlist.get(0).getEmp_password());
		return e;
	}



	@Override
	public boolean update(Employee e) {
		// TODO Auto-generated method stub
		return false;
	}



	public void saveRole(Roles r) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		// Employee e1=new Employee("vandana","483","20/09/2021","java","B1","notes","vandana@cap.com","1234567890","vandana","1234",t);

		session.save(r);
		session.flush();
		//session.close();
		tx.commit();
		
	}



	@Override
	public void saveTeam(Team t) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		// Employee e1=new Employee("vandana","483","20/09/2021","java","B1","notes","vandana@cap.com","1234567890","vandana","1234",t);

		session.save(t);
		session.flush();
		//session.close();
		tx.commit();
		
	}



	@Override
	public void saveClient(Client c) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		// Employee e1=new Employee("vandana","483","20/09/2021","java","B1","notes","vandana@cap.com","1234567890","vandana","1234",t);

		session.save(c);
		session.flush();
		//session.close();
		tx.commit();
		session.close();
		
	}

	public void saveTeamMember(TeamMember tm) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		// Employee e1=new Employee("vandana","483","20/09/2021","java","B1","notes","vandana@cap.com","1234567890","vandana","1234",t);

		session.save(tm);
		session.flush();
		//session.close();
		tx.commit();
		session.close();
	}




	









}