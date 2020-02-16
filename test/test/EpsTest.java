//package test;
//import static org.junit.jupiter.api.Assertions.*;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import exception1.AlreadyExists;
//import exception1.DoesntExist;
//import exception1.missingImportantInformation;
//import model.Eps;
//import model.Ticket;
//import model.User;
//
//class EpsTest {
//
//	Eps e;
//	
//	@BeforeEach
//	void setUp() {
//		
//		e = new  Eps();
//	}
//	
//	@BeforeEach
//	void setUp1() throws AlreadyExists, missingImportantInformation {
//		
//		e = new  Eps();
//		User u = new User("CC", "1193254110", "Diego A", "Torres", "3216994239", "Cl 14 # 83 - 50");
//		e.addUser(u);
//		User u1 = new User("CC", "94403988", "Diego", "Torres", "3216994239", "Cl 14 # 83 - 50");
//		e.addUser(u1);
//		User u2 = new User("CC", "67001941", "Martha", "Primero", "3216994239", "Cl 14 # 83 - 50");
//		e.addUser(u2);
//		User u3 = new User("CC", "11111111", "11", "11", "3216994239", "Cl 14 # 83 - 50");
//		e.addUser(u3);
//	}
//	
//	@BeforeEach
//	void setUp2() throws AlreadyExists, missingImportantInformation, DoesntExist {
//		
//		e = new  Eps();
//		User u = new User("CC", "1193254110", "Diego A", "Torres", "3216994239", "Cl 14 # 83 - 50");
//		e.addUser(u);
//		User u1 = new User("CC", "94403988", "Diego", "Torres", "3216994239", "Cl 14 # 83 - 50");
//		e.addUser(u1);
//		User u2 = new User("CC", "67001941", "Martha", "Primero", "3216994239", "Cl 14 # 83 - 50");
//		e.addUser(u2);
//		User u3 = new User("CC", "11111111", "11", "11", "3216994239", "Cl 14 # 83 - 50");
//		e.addUser(u3);
//		e.addTicket("1193254110");
//	}
//	
//
//	@Test
//	void testAddUser() throws AlreadyExists, missingImportantInformation {
//		setUp();
//		User u = new User("CC", "1193254110", "Diego", "Torres", "3216994239", "Cl 14 # 83 - 50");
//		e.addUser(u);
//		assertNotNull(e.getUsers().get(0));
//		assertEquals(u.getName(), e.getUsers().get(0).getName(), "El nombre esperado es: " + u.getName());
//		assertThrows(AlreadyExists.class, ()->e.addUser(u));
//		
//		
//		User u1 = new User("CC", "94403988", "Diego", "Torres", "3216994239", "Cl 14 # 83 - 50");
//		e.addUser(u1);
//		assertNotNull(e.getUsers().get(1));
//		assertEquals(u1.getName(), e.getUsers().get(1).getName(), "El nombre esperado es: " + u1.getName());
//		
//		User error = new User(null, null, null, null, null, null);
//		
//		assertThrows(missingImportantInformation.class, ()->e.addUser(error));
//		
//	}
//
//	@Test
//	void testFindById() throws AlreadyExists, missingImportantInformation, DoesntExist {
//	
//		setUp1();
//		User u = new User("CC", "1193254110", "Diego A", "Torres", "3216994239", "Cl 14 # 83 - 50");
//		String expected = u.getNumberOfDocument();
//		String actual = e.findById("1193254110").getNumberOfDocument();
//		assertEquals(expected, actual);
//		
//		String expected1 = e.getUsers().get(2).getNumberOfDocument();
//		String actual1 = e.findById("67001941").getNumberOfDocument();
//		assertEquals(expected1, actual1);
//		
//		String expected2 = e.getUsers().get(1).getNumberOfDocument();
//		String actual2 = e.findById("94403988").getNumberOfDocument();
//		assertEquals(expected2, actual2);
//		
//		String expected3 = e.getUsers().get(3).getNumberOfDocument();
//		String actual3 = e.findById("11111111").getNumberOfDocument();
//		assertEquals(expected2, actual2);
//
//	}
//
//	@Test
//	void testLoadTextFile() {
//	
//	}
//
//	@Test
//	void testNumberOfTheTicket() throws AlreadyExists, missingImportantInformation {
//	
//		
//		setUp1();
//		Ticket t= new Ticket('A', 00, null);
//		//e.getTickets().add(t);
//		String actual = e.numberOfTheTicket();
//		String expected = "A1";
//		assertEquals(expected, actual);
//		
//	}
//
//	@Test
//	void testAddTicket() throws AlreadyExists, missingImportantInformation, DoesntExist {
//		
//		setUp1();
//		
//		e.addTicket("1193254110");
//		assertNotNull(e.getTickets().get(0));
//		assertEquals(e.getTickets().get(0).getUser().getNumberOfDocument(), "1193254110");
//		
//		e.addTicket("67001941");
//		assertNotNull(e.getTickets().get(1));
//		assertEquals(e.getTickets().get(1).getUser().getNumberOfDocument(), "67001941");
//		assertEquals(e.getTickets().get(1).getComplete(), "A1");
//
//		e.addTicket("94403988");
//		assertNotNull(e.getTickets().get(2));
//		assertEquals(e.getTickets().get(2).getUser().getNumberOfDocument(), "94403988");
//		assertEquals(e.getTickets().get(2).getComplete(), "A2");
//		
//		e.addTicket("11111111");
//		assertNotNull(e.getTickets().get(3));
//		assertEquals(e.getTickets().get(3).getUser().getNumberOfDocument(), "11111111");
//		assertEquals(e.getTickets().get(3).getComplete(), "A3");
//
//	}
//
//	@Test
//	void testActual() throws AlreadyExists, missingImportantInformation, DoesntExist {
//		setUp1();
//		e.addTicket("1193254110");
//		e.addTicket("67001941");
//		e.addTicket("94403988");
//		assertNotNull(e.getTickets().get(2));
//		//assertEquals(e.getActuals(), e.getTickets().get(0));
//	}
//
//	@Test
//	void testAttend() {
//	
//	}
//
//}