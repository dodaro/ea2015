package persistence.dao;

import persistence.Member;

public interface MemberDAO {
	public void create(Member p);
	public Member get(Integer id);
	public Double sumOfSalary();
	public Double maxOfAvgScore();
	public void update(Member p);
	public void delete(Member p);	
}
