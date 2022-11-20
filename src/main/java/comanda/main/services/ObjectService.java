package comanda.main.services;

import java.util.List;

/*Esta interfaz nos indica que métodos hay que usar (getAll, getOne, etc), es genérica*/
public interface ObjectService <T> {

	public List<T> getAll();
	public T getOne(int id);
	public T save(T t);
	public T update(T t, int id);
	public boolean delete(int id);
	
}
