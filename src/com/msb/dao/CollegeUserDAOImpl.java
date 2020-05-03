package com.msb.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.msb.model.CollegeUser;
import com.msb.model.UserLikeKey;
import com.msb.model.UserLikeValidation;

@Repository
@Transactional
public class CollegeUserDAOImpl implements CollegeUserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public CollegeUser validateUser(String username, String password) {
		Session session = sessionFactory.getCurrentSession();
		CollegeUser other = null;
		try {

			Criteria criteria = session.createCriteria(CollegeUser.class);
			criteria.add(Restrictions.eq("username", username));
			other = (CollegeUser) criteria.uniqueResult();

			if (other != null && other.getUsername() != null
					&& !other.getUsername().isEmpty()) {

				if (other.getPassword().equals(password)) {
					return other;
				}

			} else
				return null;

		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		}

		return null;
	}

	@Override
	public Map<String, String> getStudentPassword(String userNameOrMail) {

		Session session = sessionFactory.getCurrentSession();
		Map<String, String> usermap = new HashMap<String, String>();
		try {
			Criteria criteria = session.createCriteria(CollegeUser.class);
			// Criterion username = Restrictions.eq("username", userNameOrMail);
			// Criterion mail = Restrictions.eq("mail", userNameOrMail);

			// LogicalExpression expression = Restrictions.or(username, mail);
			criteria.add(Restrictions.eq("username", userNameOrMail));
			CollegeUser other = (CollegeUser) criteria.uniqueResult();

			if (other != null)
				usermap.put(other.getMail(), other.getPassword());

			return usermap;

		} catch (HibernateException exception) {
			exception.printStackTrace();
			return null;
		}

	}

	@Override
	public boolean saveCollegeUser(CollegeUser other) {
		Session session = sessionFactory.getCurrentSession();

		try {
			/*
			 * System.out.println("photo size" + photo.available()); if (photo
			 * != null && photo.available() > 0) { // UserProfileImage
			 * profileImage = new UserProfileImage(); byte[] image =
			 * IOUtils.toByteArray(photo); user.setImage(image); }
			 */
			//other.setTxnref("MSBU00" + (getStudentMaxID() + 1));

			session.save(other);
			return true;

		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}

	}

	public Integer getStudentMaxID() {
		Session session = sessionFactory.getCurrentSession();

		try {
			Criteria criteria = session.createCriteria(CollegeUser.class);
			criteria.setProjection(Projections.max("id"));
			Integer id = (Integer) criteria.uniqueResult();
			if (id != null)
				return id;
			else
				return 1;

		} catch (HibernateException e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public boolean activateRegisteredUser(String activationCode) {
		Session session = sessionFactory.getCurrentSession();

		try {
			Query selectQuery = session
					.createQuery("select student_id from CollegeUserActivation where activation_code= :acode");
			selectQuery.setParameter("acode", activationCode);
			Integer student_id = (Integer) selectQuery.uniqueResult();
			if (student_id != 0 && student_id != null) {

				Query deleteQuery = session
						.createQuery("delete CollegeUserActivation where activation_code = :acode");
				deleteQuery.setParameter("acode", activationCode);

				int deleted = deleteQuery.executeUpdate();
				System.out.println(deleted);
				if (deleted > 0) {
					Query updateQuery = session
							.createSQLQuery("update CollEGE_USER set active = :active , mail_verified = :verified"
									+ " where id = :id");
					updateQuery.setParameter("active", 1);
					updateQuery.setParameter("verified", 1);
					updateQuery.setParameter("id", student_id);
					int updated = updateQuery.executeUpdate();

					/*
					 * Criteria criteria =
					 * session.createCriteria(UserActivation.class);
					 * criteria.add(Restrictions.eq("activation_code",
					 * activationCode)); List<UserActivation> activations =
					 * criteria.list(); UserActivation activation =
					 * activations.get(0); if (activation != null) {
					 * session.delete(activation);
					 */
					if (updated > 0)
						return true;
					else
						return false;

				} else {
					return false;
				}
			} else {
				return false;
			}

		} catch (HibernateException exception) {
			exception.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean isUserExist(String username) {
		Session session = sessionFactory.getCurrentSession();
		CollegeUser other = null;
		try {
			System.out.println("checking username exist or not");
			Criteria criteria = session.createCriteria(CollegeUser.class);
			criteria.add(Restrictions.eq("username", username));
			other = (CollegeUser) criteria.uniqueResult();

			if (other != null)
				return true;
			else
				return false;
		
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public boolean updateUser(CollegeUser other) {
		Session session = sessionFactory.getCurrentSession();

		try {
			session.update(other);
			session.flush();
			session.refresh(other);
			return true;
		} catch (HibernateException exception) {
			exception.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean saveStudentLike(UserLikeValidation userLikeValidation) {
		Session session = sessionFactory.getCurrentSession();

		try {

			session.saveOrUpdate(userLikeValidation);
			return true;
		} catch (HibernateException exception) {
			exception.printStackTrace();
			return false;
		}
	}

	@Override
	public UserLikeValidation checkStudentLike(
			UserLikeValidation userLikeValidation) {
		Session session = sessionFactory.getCurrentSession();

		String username = userLikeValidation.getUsername();
		int entry_id = userLikeValidation.getEntry_id();
		String comp_type = userLikeValidation.getComp_type();
		UserLikeValidation likeValidation = (UserLikeValidation) session.get(
				UserLikeValidation.class, new UserLikeKey(username, entry_id,
						comp_type));
		return likeValidation;
	}

	@Override
	public boolean updateUserPoints(String username, int points) {
		Session session = sessionFactory.getCurrentSession();
		try {
			Criteria criteria = session.createCriteria(CollegeUser.class);
			criteria.add(Restrictions.eq("username", username));
			CollegeUser other = (CollegeUser) criteria.uniqueResult();
			other.setPoints(other.getPoints() + points);
			session.merge(other);
			/*
			 * session.flush(); session.refresh(user);
			 */
			return true;
		} catch (HibernateException exception) {
			exception.printStackTrace();
			return false;
		}

	}

	@Override
	public CollegeUser getStudentDetails(String username) {
		Session session = sessionFactory.getCurrentSession();
		CollegeUser other = null;
		try {

			Criteria criteria = session.createCriteria(CollegeUser.class);
			criteria.add(Restrictions.eq("username", username));
			other = (CollegeUser) criteria.uniqueResult();

			return other;

		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		}

	}
	
	@Override
	public CollegeUser getStudentDetailsById(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		CollegeUser other = null;

		try {
			Criteria criteria = session.createCriteria(CollegeUser.class);
			criteria.add(Restrictions.eq("id", id));
			other = (CollegeUser) criteria.uniqueResult();

			return other;

		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		}

	}

	
	@SuppressWarnings("unchecked")
	@Override
	public List<CollegeUser> getTopStudents() {
		Session session = sessionFactory.getCurrentSession();

		try {
			Query detailsQuery = session
				.createSQLQuery("select ud.USER_NAME,ud.CITY,ud.REFERENCE,ud.POINTS,qp.user_quizzes from USER_DETAILS ud "
						+ "join (select user_name,count(user_name) as user_quizzes from QUIZ_POINTS group by user_name) as qp"
						+ " on ud.user_name=qp.user_name where (ud.SCHOOL='sri chaitanya techno school' OR ud.SCHOOL_CODE='srichaitanya')"
						+ " AND ud.POINTS>1000 AND ud.REFERENCE <>'ARROW' AND ud.REFERENCE IS NOT NULL ORDER BY ud.POINTS DESC");
			Criteria criteria = session
					.createCriteria(CollegeUser.class);
		
				//criteria.add(Restrictions.eq("article_category", category));
				//criteria.addOrder(Order.desc("date_created"));			

				List<CollegeUser> TopStudents = criteria.list();

				return TopStudents;

			} catch (HibernateException e) {
				e.printStackTrace();
				return null;
			}
		}
	
	@Override
	public int getTopStudentsCount() {
		Session session = sessionFactory.getCurrentSession();

		try {			
			
			Criteria criteria = session.createCriteria(CollegeUser.class);
			
			//criteria.add(Restrictions.eq("article_category", category));

			criteria.setProjection(Projections.rowCount());
			Long rowCount = (Long) criteria.uniqueResult();
			return rowCount.intValue();
		} catch (HibernateException e) {
			e.printStackTrace();
			return 0;
		}
	}

}
