package three.dao;

import java.sql.SQLException;
import java.util.List;

/**
 * <li>1. C reate(INSERT)</li>
 * <li>2. R etrieve(SELECT)</li>
 * <li>3. U update(UPDATE)</li>
 * <li>4. D elete(DELETE)</li>
 *
 * @param <E>
 */
public interface Dao<E> {

    public void create(E entity) throws SQLException;

    public E retrieve(int primaryKey) throws SQLException;

    public List<E> retrieveAll() throws  SQLException;

    public void update(E entity) throws SQLException;

    public void delete(E entity) throws SQLException;
}
