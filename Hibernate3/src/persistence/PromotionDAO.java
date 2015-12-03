package persistence;

public interface PromotionDAO {
	public void create(Promotion p);

	public Promotion get(Integer id);

	public Long numberOfPromotions();

	public void update(Promotion p);

	public void delete(Promotion p);
}
