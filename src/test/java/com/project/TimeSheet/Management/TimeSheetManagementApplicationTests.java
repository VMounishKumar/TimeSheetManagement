package com.project.TimeSheet.Management;

import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.controller.EmployeeController;
import com.controller.*;
import com.model.*;
@RunWith(SpringRunner.class)
@SpringBootTest
class TimeSheetManagementApplicationTests {

	@Autowired
	EmployeeController employeeController;

	@Test
	void contextLoads() {

	}
	@Autowired
	TmsDAO TmsDAOImpl;

	@Autowired
	Service service;


	@Test
	void contextLoads11() {
		Employee employee=new Employee("vijay","2/3/21","hacker","vijay_7843","593674");
		service.save(employee);
		Employee emp1=service.findEmployee(employee.getEmpId());
		assertThat("vijay").isEqualTo(emp1.getEmpName());
	}
	@Test
	void contextLoads01() {
		Employee employee=new Employee("vijay","2/3/21","hacker","vijay_7843","593674");
		service.save(employee);
		Employee emp=new Employee("vijay","2/3/21","devoloper","vijay_7843","593674");
		boolean emp1=TmsDAOImpl.update(emp);

		assertThat("devoloper").isEqualTo(emp.getSkill());
	}
	@Test
	void contextLoads02() {
		Employee emp1=new Employee("vijay","2/3/21","hacker","vijay_7843","593674");
		Employee emp2=new Employee("krishna","2/3/21","hacker","vijay_7843","593674");
		Employee emp3=new Employee("vivek","2/3/21","hacker","vijay_7843","593674");
		TmsDAOImpl.save(emp1);
		TmsDAOImpl.save(emp2);
		TmsDAOImpl.save(emp3);
		List<Employee> emp=new ArrayList<Employee>();
		emp.add(emp1);
		emp.add(emp2);
		emp.add(emp3);

		List<Employee> empl=service.empList(1);
		int id=2;
		int c=0;
		for(int i=0;i<empl.size();i++) {
			if((empl.get(i)).getEmpId()==id) {
				assertThat((empl.get(i)).getEmpId()).isEqualTo(id);
				c+=1;
			}


		}
		if(c==0) {

		}
	}

	//	@Test
	//	void contextLoads1() {
	//	Project project=new Project( 1,"","");
	//	TmsDAOImpl.saveProject(project);
	//	TmsDAOImpl.closeProject(project.getProject_ID(), project.getProject_end_date(), project.getProject_notes());
	//	String project1=TmsDAOImpl.closeProject(project.getProject_ID(), project.getProject_end_date(), project.getProject_notes());
	//	assertThat("close").isEqualTo(project1);
	//	}
	@Test
	void contextLoads2() {
		Roles r=new Roles(1,"manager");
		service.saveRole(r);
		assertThat("manager").isEqualTo(r.getRoleName());
	}
	@Test
	void contextLoad3() {
		Team r=new Team(1,"manager","vijay");
		service.saveTeam(r);
		r.toString();
		assertThat("manager").isEqualTo(r.getTeamName());


	}
	@Test
	void contextLoads4() {

		TeamMember tm=new TeamMember(1);
		service.saveTeamMember(tm);
		assertThat(1).isEqualTo(tm.getTeamMemberId());
	}



	@Test
	void contextLoads5() {
		TimeSheet ts=new TimeSheet("2/1/21","9","yes","Sailesh","excellent");
		service.saveTimesheet(ts);
		if(ts.getTimeSheet_NOHours()=="9") {
			boolean u=service.approveTimesheet(1);
			assertThat(true).isEqualTo(u);
		}
	}

	@Test
	void contextLoad6() {
		TimeSheet ts1=new TimeSheet("2/1/21","9","yes","Sailesh","excellent");
		TimeSheet ts2=new TimeSheet("3/2/21","9","yes","Sailesh","excellent");
		TimeSheet ts3=new TimeSheet("4/2/21","9","yes","Sailesh","excellent");
		//service.saveTimesheet(ts1);
		//service.saveTimesheet(ts2);
	//	service.saveTimesheet(ts3);
		List<TimeSheet> emp=new ArrayList<TimeSheet>();
		emp.add(ts1);
		emp.add(ts2);
		emp.add(ts3);

		List<TimeSheet> empl=service.findsheetDetails(1);
		int id=2;
		int c=0;
		for(int i=0;i<empl.size();i++) {
			if((empl.get(i)).getTimeSheetID()==id) {
				assertThat((empl.get(i)).getTimeSheetID()).isEqualTo(id);
				c+=1;
			}


		}
		if(c==0) {

		}
	}
	//	
	//	@Test
	//	void contextLoad7()
	//	{
	//		Employee emp1=new Employee("vijay","2/3/21","hacker","vijay_7843","593674");
	//		
	//		Employee emp3=new Employee("vivek","2/3/21","hacker","vijay_7843","593674");
	//		TmsDAOImpl.save(emp1);
	//	//	TmsDAOImpl.save(emp3);
	//		Employee employee=TmsDAOImpl.findEmployee(1);
	////		empl
	//		System.out.println(employee);
	//		//employee.getEmp_username();
	//	//employee.setEmp_username("casablanca");
	////		System.out.println(employee);
	//	TmsDAOImpl.update(1,emp3);
	//		System.out.println(employee);
	//		assertThat("vivek").isEqualTo(employee.getEmpName());
	//
	//	}

	@Test
	void contextLoader67() {
		Client c=new Client();
		Client c1=new Client(1,"vijay","reddy");
		c.setClientId(1);
		c.setClientName("vijay");
		c.setClientPlace("hyd");
		c.getClientId();
		c.getClientName();
		c.getClientPlace();
		c1.toString();
		//TmsDAOImpl.saveClient(c1);
		//		TmsDAOImpl.saveClient(c);
		assertThat("hyd").isEqualTo(c.getClientPlace());

	}

	@Test
	void contextLoader13() {
		TimeSheet ts=new TimeSheet();
		Project project=new Project();
		Employee e=new Employee();
		ts.setTimeSheetID(1);
		ts.getTimeSheetID();
		//ts.getProject();//
		//ts.setProject((List<Project>) project);//
		ts.getTimeSheet_Act();
		ts.setTimeSheet_Act("hello");
		ts.getTimeSheet_Date();
		ts.setTimeSheet_Date("2/3/21");
		ts.getTimeSheet_NOHours();
		ts.setTimeSheet_NOHours("9");
		ts.getTimeSheet_Approved();
		ts.setTimeSheet_Approved("yes");
		ts.getTimeSheet_Notes();
		ts.setTimeSheet_Rejected_Reason("not working");
		ts.setTimeSheet_Other_Activities("sports");
		ts.setTimeSheet_ApprovedBy("manager");
		ts.getTimeSheet_ApprovedBy();
		ts.getTimeSheet_Other_Activities();
		ts.getTimeSheet_Rejected_Reason();
		ts.toString();
		ts.setTimeSheet_Rejected_Reason("not workin for 9 hours");
		ts.getTimeSheet_Notes();
		ts.setTimeSheet_Notes("app notes");
		ts.getTimeSheet_Feedback();
		ts.setTimeSheet_Feedback("good");
		ts.setTimeSheet_Suggestion("work more hours");
		ts.getTimeSheet_Suggestion();
		//ts.setEmployee(e);
		//ts.getEmployee();
		assertThat("hello").isEqualTo(ts.getTimeSheet_Act());

	}
	@Test
	void context14() {

	}
	@Test
	void contextLoader15() {
		TeamMember tm=new TeamMember();
		Roles role=new Roles();
		Team team=new Team();
		tm.setTeam(team);
		tm.setTeamMemberId(1);
		tm.setRole(role);
		tm.getTeam();
		tm.getTeamMemberId();
		tm.getRole();
		team.toString();
		assertThat(1).isEqualTo(tm.getTeamMemberId());

	}
	@Test
	void contextLoader77() {
		Roles r=new Roles();
		TeamMember tm=new TeamMember();
		Roles role1=new Roles(1,"developer");
		r.setRoleId(1);
		r.getRoleId();
		r.getRoleName();
		r.setRoleName("hackers");
		r.setTeamMember(tm);
		r.getTeamMember();
		assertThat(1).isEqualTo(r.getRoleId());


	}
	@Test
	void contextLoad99()
	{
		Client c=new Client();
		Team team=new Team();
		Project p=new Project();
		p.setProject_ID(123);
		p.getProject_ID();
		p.setProject_client_Name("Mounish");
		p.getProject_client_Name();
		p.setProject_client_Name("Manish");
		p.getProject_client_Name();
		p.setProject_brief("sukhibhava");
		p.getProject_brief();
		p.setProject_client_manager("kumar");
		p.getProject_client_manager();
		p.setProject_client_email("kumar@gmail.com");
		p.getProject_client_email();
		p.setProject_OS_ID("8080");
		p.getProject_OS_ID();
		p.setProject_DB_ID("9876654");
		p.getProject_DB_ID();
		p.setProject_App_server_ID("localhost:9090");
		p.getProject_App_server_ID();
		p.setProject_manager_name("raks");
		p.getProject_manager_name();
		p.setProject_PL("abcdefgh");
		p.getProject_PL();
		p.setProject_notes("amma baboy");
		p.getProject_notes();
		p.setProject_start_date("23/09/21");
		p.getProject_start_date();
		p.setProject_end_date("25/11/21");
		p.getProject_end_date();
		p.setProject_status("Completed");
		p.getProject_status();
		p.setClient(c);
		p.getClient();
		p.getTeam();
		p.setTeam(team);
		assertThat("kumar@gmail.com").isEqualTo(p.getProject_client_email());
	}
	@Test
	void contextLoader11() {
		Employee e=new Employee();
		TimeSheet ts=new TimeSheet();

		e.setEmpId(1);
		e.setEmpName("manager");
		e.setEmpDesignationID("12");
		e.setEmpJoinDate("12/2/21");
		e.setSkill("java");
		e.setDeptID("123");
		e.setEmpNotes("app");
		e.setEmpEmail("manager@gmail.com");
		e.setPhoneNo("1234567");
		e.setEmp_username("manager_123");
		e.setEmp_password("manager_12");
		e.setTimeSheet(ts);
		e.getEmpId();
		e.getEmpName();
		e.getEmpDesignationID();
		e.getEmpJoinDate();
		e.getSkill();
		e.getDeptID();
		e.getEmpNotes();
		e.getEmpEmail();
		e.getPhoneNo();
		e.getEmp_username();
		e.getEmp_password();
		e.getTimeSheet();
		assertThat("manager").isEqualTo(e.getEmpName());
	}

	@Test
	void contextLoaderTeam()
	{
		Project p=new Project();

		Employee e=new Employee();
		List<TeamMember> tm=new ArrayList<TeamMember>();

		Team t=new Team();
		TeamMember m=new TeamMember();
		Roles r=new Roles();
		t.setTeamID(1);
		t.setTeamName("texs");
		t.setTeamLeader("marcus");
		t.setTeamNotes("initiator");
		t.setProject(p);
		t.setCountries("usa");
		m.setRole(r);
		m.setTeam(t);
		m.setTeamMemberId(1);

		t.getTeamID();
		t.getTeamName();
		t.getTeamLeader();
		t.getTeamNotes();
		t.getProject();
		t.getCountries();
		m.getRole();
		m.getTeam();
		m.getTeamMemberId();

		assertThat("texs").isEqualTo(t.getTeamName());
	}
	//	@Test
	//	void contextLoads6() {
	//		TimeSheet t1=new TimeSheet();
	//		TimeSheet ts=new TimeSheet("2/1/21","9","yes","Sailesh","excellent");
	//		//TimeSheet t1=new TimeSheet();
	//		TmsDAOImpl.saveTimesheet(t1);
	//		TmsDAOImpl.save(ts);
	//		//
	//		// Employee e2=service.findEmployee(1);
	//
	//		Employee emp=TmsDAOImpl.findEmployee(e1.getEmpId());
	//		//assertTrue(e1.equals(emp));
	//
	//		assertThat("vandana").isEqualTo(emp.getEmp_username());
	//
	//
	//
	//		}
	//	}


	/*	@Test
	void contextLoads6() {
	HallCapacity hallCapacity=new HallCapacity(10);
	hallCapacityDAOImpl.saveHallCapacity(hallCapacity);
	assertThat(10).isEqualTo(hallCapacity.getSeatCount());



	}



	@Test
	void contextLoads7() {
	String d1="2021-09-09";
	String d2="2021-09-12";
	Date date2=Date.valueOf(d2);
	Date date=Date.valueOf(d1);
	Shows s=new Shows(27,date,date2);
	showsDAOImpl.saveShows(s);
	Shows s2=showsDAOImpl.findShows(s.getShowId());
	assertThat(27).isEqualTo(s2.getSlotNo());
	}
	@Test
	void contextLoads8() {
	Users user=new Users("lxmn",'a',967619,"lxmn@gmail.com");
	usersDAOImpl.saveUser(user);
	Users user1=new Users();
	user1.setUserName("tulasi");
	user1.setUserType('b');
	user1.setMobileNo(4567);
	user1.setEmailId("tulasi@gmail.com");
	usersDAOImpl.saveUser(user1);
	Users user2=new Users("kavya",'a',967619,"lxmn@gmail.com");
	usersDAOImpl.saveUser(user2);
	assertThat("tulasi@gmail.com").isEqualTo(user1.getEmailId());
	assertThat("tulasi").isEqualTo(user1.getUserName());
	assertThat('b').isEqualTo(user1.getUserType());
	assertThat(4567).isEqualTo(user1.getMobileNo());
	assertThat(true).isEqualTo(usersDAOImpl.updateUser(user2));
	}*/
}