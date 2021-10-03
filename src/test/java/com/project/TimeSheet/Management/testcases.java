//package com.project.TimeSheet.Management;
//
//
//
//
//
//
//	import java.sql.Date;
//	import org.apache.catalina.User;
//	import org.junit.jupiter.api.Test;
//	import org.springframework.beans.factory.annotation.Autowired;
//	import org.springframework.boot.test.context.SpringBootTest;
//	import static org.junit.jupiter.api.Assertions.assertTrue;
//	import org.junit.jupiter.api.BeforeEach;
//	import org.junit.jupiter.api.Test;
//	import org.springframework.beans.factory.annotation.Autowired;
//	import org.springframework.boot.test.context.SpringBootTest;
//	import org.springframework.test.context.junit4.SpringRunner;
//	import org.springframework.transaction.annotation.EnableTransactionManagement;
//	import com.model.*;
//	
//	import static org.assertj.core.api.Assertions.assertThat;
//	import java.util.*;
//
//
//	@EnableTransactionManagement
//	@SpringBootTest
//	public class testcases {
//
//
//
//	@Autowired
//	TmsDAO TmsDAOImpl;
//	
//
//
//
//	@Test
//	void contextLoads() {
//	Employee employee=new Employee("vijay","2/3/21","hacker","vijay_7843","593674");
//	TmsDAOImpl.save(employee);
//	Employee emp1=TmsDAOImpl.findEmployee(employee.getEmpId());
//	assertThat("vijay").isEqualTo(emp1.getEmpName());
//	}
//	@Test
//	void contextLoads01() {
//		Employee employee=new Employee("vijay","2/3/21","hacker","vijay_7843","593674");
//		TmsDAOImpl.save(employee);
//		Employee emp=new Employee("vijay","2/3/21","devoloper","vijay_7843","593674");
//		boolean emp1=TmsDAOImpl.update(emp);
//		
//		assertThat("devoloper").isEqualTo(emp.getSkill());
//	}
//	@Test
//	void contextLoads02() {
//		Employee emp1=new Employee("vijay","2/3/21","hacker","vijay_7843","593674");
//		Employee emp2=new Employee("krishna","2/3/21","hacker","vijay_7843","593674");
//		Employee emp3=new Employee("vivek","2/3/21","hacker","vijay_7843","593674");
//		TmsDAOImpl.save(emp1);
//		TmsDAOImpl.save(emp2);
//		TmsDAOImpl.save(emp3);
//		List<Employee> emp=new ArrayList<Employee>();
//		emp.add(emp1);
//		emp.add(emp2);
//		emp.add(emp3);
//
//		List<Employee> empl=TmsDAOImpl.empList(1);
//		int id=2;
//		int c=0;
//		for(int i=0;i<empl.size();i++) {
//			if((empl.get(i)).getEmpId()==id) {
//				System.out.println(emp.get(i));
//				assertThat((empl.get(i)).getEmpId()).isEqualTo(id);
//				c+=1;
//			}
//				
//			
//		}
//		if(c==0) {
//			
//		}
//	}
//	
//	@Test
//	void contextLoads1() {
//	Project project=new Project( 1,"sai","wsa");
//	TmsDAOImpl.saveProject(project);
////	TmsDAOImpl.closeProject(project.getProject_ID(), project.getProject_end_date(), project.getProject_notes());
////String project1=TmsDAOImpl.closeProject(project.getProject_ID(), project.getProject_end_date(), project.getProject_notes());
//	assertThat(1).isEqualTo(project.getProject_ID());
//	}
//	@Test
//	void contextLoads2() {
//	Roles r=new Roles(1,"manager");
//	TmsDAOImpl.saveRole(r);
//	assertThat("manager").isEqualTo(r.getRoleName());
//	}
//	@Test
//	void contextLoad3() {
//		Team r=new Team(1,"manager","vijay");
//		TmsDAOImpl.saveTeam(r);
//		assertThat("manager").isEqualTo(r.getTeamName());
//
//
//	}
//	@Test
//	void contextLoads4() {
//	
//	TeamMember tm=new TeamMember(1);
//	TmsDAOImpl.saveTeamMember(tm);
//	assertThat(1).isEqualTo(tm.getTeamMemberId());
//	}
//
//
//
//	@Test
//	void contextLoads5() {
//	TimeSheet ts=new TimeSheet("2/1/21","9","yes","Sailesh","excellent");
//	assertThat("yes").isEqualTo(ts.getTimeSheet_Approved());
//	}
//	/*	@Test
//	void contextLoads6() {
//	HallCapacity hallCapacity=new HallCapacity(10);
//	hallCapacityDAOImpl.saveHallCapacity(hallCapacity);
//	assertThat(10).isEqualTo(hallCapacity.getSeatCount());
//
//
//
//	}
//	
//
//
//	@Test
//	void contextLoads7() {
//	String d1="2021-09-09";
//	String d2="2021-09-12";
//	Date date2=Date.valueOf(d2);
//	Date date=Date.valueOf(d1);
//	Shows s=new Shows(27,date,date2);
//	showsDAOImpl.saveShows(s);
//	Shows s2=showsDAOImpl.findShows(s.getShowId());
//	assertThat(27).isEqualTo(s2.getSlotNo());
//	}
//	@Test
//	void contextLoads8() {
//	Users user=new Users("lxmn",'a',967619,"lxmn@gmail.com");
//	usersDAOImpl.saveUser(user);
//	Users user1=new Users();
//	user1.setUserName("tulasi");
//	user1.setUserType('b');
//	user1.setMobileNo(4567);
//	user1.setEmailId("tulasi@gmail.com");
//	usersDAOImpl.saveUser(user1);
//	Users user2=new Users("kavya",'a',967619,"lxmn@gmail.com");
//	usersDAOImpl.saveUser(user2);
//	assertThat("tulasi@gmail.com").isEqualTo(user1.getEmailId());
//	assertThat("tulasi").isEqualTo(user1.getUserName());
//	assertThat('b').isEqualTo(user1.getUserType());
//	assertThat(4567).isEqualTo(user1.getMobileNo());
//	assertThat(true).isEqualTo(usersDAOImpl.updateUser(user2));
//	}*/
//}
