package persistence;

import org.hibernate.Query;
import org.hibernate.Session;

public class PromotionDAOImpl implements PromotionDAO {

	@Override
	public void create(Promotion p) {
		DBHandler.create(p);
	}
	
	@Override
	public void update(Promotion p) {
		DBHandler.update(p);
	}
	
	@Override
	public void delete(Promotion p) {
		DBHandler.delete(p);
	}

	@Override
	public Promotion get(Integer id) {
		Session session = DBHandler.getSession();
		String queryString = "from Promotion where id = :id_promotion";
		Query query = session.createQuery(queryString);
		query.setParameter("id_promotion", id);
		Promotion p = (Promotion) query.uniqueResult();
		p.getUsers().size();
		session.close();
		return p;
	}

	@Override
	public Long numberOfPromotions() {
		Session session = DBHandler.getSession();
		Long size = (Long) session.createQuery("select count(*) from Promotion").uniqueResult();
		session.close();
		return size;
	}
}
