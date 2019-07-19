package com.revature.repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.revature.model.User;
import com.revature.util.SessionFactory;

@Repository("ur2")
public class UserRepositoryImpl implements UserRepository {

	@Override
	public User getUserByUsername(String username) {
		User u = null;
		Session s = null;
		Transaction tx =null;

		try {
			s = SessionFactory.getSession();
			tx = s.beginTransaction();
			CriteriaBuilder cb = s.getCriteriaBuilder();
			CriteriaQuery<User> cq = cb.createQuery(User.class);
			Root<User> root = cq.from(User.class);
			cq.select(root).where(cb.equal(root.get("username"), username));
			Query<User> q = s.createQuery(cq);
			u=q.getSingleResult();
			tx.commit();
			

		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			s.close();
		}
		
		System.out.println(u);

		return u;
	}

}

