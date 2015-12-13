package tests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import persistence.Member;
import persistence.Professor;
import persistence.Student;
import persistence.dao.MemberDAO;
import persistence.dao.MemberDAOImpl;
public class PersistenceTest {
	
	static MemberDAO memberDao;
	static List<Member> members;
	
	@BeforeClass
	static public void init()
	{
		memberDao = new MemberDAOImpl();
		members = new ArrayList<Member>();
		initDB();
	}
	
	static public void initDB()
	{
		for(int i = 0; i < 10; i++)
		{
			Member m = null;
			if(i%2 == 0)
				m = new Student(i,"student"+i,"student"+i, new Double(i*3));
			else
				m = new Professor(i,"professor"+i, "professor"+i, new Double(i*1000));
			members.add(m);
			memberDao.create(m);
		}			
	}
	
	@Test
	public void testSalary()
	{
		assertEquals(new Double(1000), ((Professor)memberDao.get(2)).getSalary());
	}	
	
	@Test
	public void testAvgScore()
	{
		assertEquals(new Double(0), ((Student)memberDao.get(1)).getAvgScore());
	}
	
	@Test
	public void maxSalary()
	{
		assertEquals(new Double(9000), memberDao.maxSalary());
	}
}
