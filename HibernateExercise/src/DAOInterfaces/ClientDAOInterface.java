package DAOInterfaces;

import java.util.List;

import persistence.Client;

public interface ClientDAOInterface
{
	public void create(Client client);

	public Client get(Integer id);

	public void update(Client client);

	public void delete(Client client);

	public int numberOfClients();

	public List<Client> getClients();
}
