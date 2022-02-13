package dao;

import org.hibernate.Session;

/**
 * Deals with the creation<p>
 * and shutdown of Hibernate<p>
 * database sessions.
 * Contains methods such as<p>
 * begin, commit, close and rollback.<p>
 *
 */
public interface Dao {
	public Session getSession();
	public void begin();
	public void commit();
	public void close();
	public void rollback();

}
