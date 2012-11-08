package szpital.baza;

import java.util.List;

public interface ManagerInterface<TEntity> {
	
	public TEntity get(long id);
	public List<TEntity> getAll();
	public boolean save(TEntity obj);
	public boolean delete(TEntity obj);

}
