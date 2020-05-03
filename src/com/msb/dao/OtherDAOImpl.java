package com.msb.dao;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.msb.model.AskAnExpert;
import com.msb.model.CompetitionText;
import com.msb.model.MSTCompetition;
import com.msb.model.Other;
import com.msb.model.PaymentDetails;
import com.msb.model.UserLikeKey;
import com.msb.model.UserLikeValidation;

@Repository
@Transactional
public class OtherDAOImpl implements OtherDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Other validateUser(String username, String password) {
		Session session = sessionFactory.getCurrentSession();
		Other other = null;
		try {

			Criteria criteria = session.createCriteria(Other.class);
			criteria.add(Restrictions.eq("username", username));
			other = (Other) criteria.uniqueResult();

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
			Criteria criteria = session.createCriteria(Other.class);
			// Criterion username = Restrictions.eq("username", userNameOrMail);
			// Criterion mail = Restrictions.eq("mail", userNameOrMail);

			// LogicalExpression expression = Restrictions.or(username, mail);
			criteria.add(Restrictions.eq("username", userNameOrMail));
			Other other = (Other) criteria.uniqueResult();

			if (other != null)
				usermap.put(other.getMail(), other.getPassword());

			return usermap;

		} catch (HibernateException exception) {
			exception.printStackTrace();
			return null;
		}

	}

	@Override
	public boolean saveOther(Other other) {
		Session session = sessionFactory.getCurrentSession();

		try {
			/*
			 * System.out.println("photo size" + photo.available()); if (photo
			 * != null && photo.available() > 0) { // OthersProfileImage
			 * profileImage = new OthersProfileImage(); byte[] image =
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
	
	@Override
	public boolean saveStudent(Other user) {
		Session session = sessionFactory.getCurrentSession();

		try {
			
			//System.out.println("photo size" + photo.available()); if (photo
			 //!= null && photo.available() > 0) { // OthersProfileImage
			 //profileImage = new OthersProfileImage(); byte[] image =
			 //IOUtils.toByteArray(photo); user.setImage(image); }
			 
			//user.setTxnref("MSBU00" + (getStudentMaxID() + 1));

			session.save(user);
			return true;

		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}

	}

	public Integer getStudentMaxID() {
		Session session = sessionFactory.getCurrentSession();

		try {
			Criteria criteria = session.createCriteria(Other.class);
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
					.createQuery("select student_id from UserActivation where activation_code= :acode");
			selectQuery.setParameter("acode", activationCode);
			Integer student_id = (Integer) selectQuery.uniqueResult();
			if (student_id != 0 && student_id != null) {

				Query deleteQuery = session
						.createQuery("delete UserActivation where activation_code = :acode");
				deleteQuery.setParameter("acode", activationCode);

				int deleted = deleteQuery.executeUpdate();
				System.out.println(deleted);
				if (deleted > 0) {
					Query updateQuery = session
							.createSQLQuery("update USER_DETAILS set active = :active , mail_verified = :verified"
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
		Other other = null;
		try {
			System.out.println("checking username exist or not");
			Criteria criteria = session.createCriteria(Other.class);
			criteria.add(Restrictions.eq("username", username));
			other = (Other) criteria.uniqueResult();

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
	public boolean updateUser(Other other) {
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
			Criteria criteria = session.createCriteria(Other.class);
			criteria.add(Restrictions.eq("username", username));
			Other other = (Other) criteria.uniqueResult();
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
	public boolean saveAskAnExpert(AskAnExpert askAnExpert) {
		Session session = sessionFactory.getCurrentSession();

		try {
			session.save(askAnExpert);
			return true;

		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CompetitionText> getUserTextEntries(String username,
			int textCategory, int limit) {
		Session session = sessionFactory.getCurrentSession();

		try {
			Criteria criteria = session.createCriteria(CompetitionText.class);

			Criterion categroy = Restrictions.eq("comp_category_id",
					textCategory);

			Criterion user = Restrictions.eq("user_name", username);

			criteria.add(Restrictions.and(user, categroy));

			if (limit != 0)
				criteria.setMaxResults(limit);

			criteria.setFetchMode("competition", FetchMode.JOIN);
			List<CompetitionText> textCompList = criteria.list();

			return textCompList;

		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MSTCompetition> getUserPMDDEntries(String username,
			String entryCategory, int limit) {
		Session session = sessionFactory.getCurrentSession();

		try {
			Criteria criteria = session.createCriteria(MSTCompetition.class);

			Criterion categroy = Restrictions.eq("submission_type",
					entryCategory);

			Criterion user = Restrictions.eq("user_name", username);

			criteria.add(Restrictions.and(user, categroy));

			if (limit != 0)
				criteria.setMaxResults(limit);

			criteria.setFetchMode("competition", FetchMode.JOIN);
			List<MSTCompetition> pmdCompList = criteria.list();

			return pmdCompList;

		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Other getStudentDetails(String username) {
		Session session = sessionFactory.getCurrentSession();
		Other other = null;
		try {

			Criteria criteria = session.createCriteria(Other.class);
			criteria.add(Restrictions.eq("username", username));
			other = (Other) criteria.uniqueResult();

			return other;

		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		}

	}
	
	@Override
	public Other getStudentDetailsById(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Other other = null;

		try {
			Criteria criteria = session.createCriteria(Other.class);
			criteria.add(Restrictions.eq("id", id));
			other = (Other) criteria.uniqueResult();

			return other;

		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public boolean savePaymentDetails(PaymentDetails paymentDetails) {
		Session session = sessionFactory.getCurrentSession();

		try {
			session.saveOrUpdate(paymentDetails);

			return true;
		} catch (HibernateException exception) {
			exception.printStackTrace();
			return false;
		}
	}
	
	@Override
	public boolean updateUserPointsForDebates(int id, int points) {
		Session session = sessionFactory.getCurrentSession();
		try {
			Criteria criteria = session.createCriteria(Other.class);
			criteria.add(Restrictions.eq("id", id));
			Other other = (Other) criteria.uniqueResult();
			other.setPoints(other.getPoints() + points);
			session.merge(other);
			System.out.println("Id and points are :"+id +other.getPoints());
			/*
			 * session.flush(); session.refresh(user);
			 */
			return true;
		} catch (HibernateException exception) {
			exception.printStackTrace();
			return false;
		}

	}

	
	@SuppressWarnings("unchecked")
	@Override
	public List<Other> getTopStudents() {
		Session session = sessionFactory.getCurrentSession();

		try {
			Query detailsQuery = session
				.createSQLQuery("select ud.USER_NAME,ud.CITY,ud.REFERENCE,ud.POINTS,qp.user_quizzes from USER_DETAILS ud "
						+ "join (select user_name,count(user_name) as user_quizzes from QUIZ_POINTS group by user_name) as qp"
						+ " on ud.user_name=qp.user_name where (ud.SCHOOL='sri chaitanya techno school' OR ud.SCHOOL_CODE='srichaitanya')"
						+ " AND ud.POINTS>1000 AND ud.REFERENCE <>'ARROW' AND ud.REFERENCE IS NOT NULL ORDER BY ud.POINTS DESC");
			Criteria criteria = session
					.createCriteria(Other.class);
		
				//criteria.add(Restrictions.eq("article_category", category));
				//criteria.addOrder(Order.desc("date_created"));			

				List<Other> TopStudents = criteria.list();

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
			
			Criteria criteria = session.createCriteria(Other.class);
			
			//criteria.add(Restrictions.eq("article_category", category));

			criteria.setProjection(Projections.rowCount());
			Long rowCount = (Long) criteria.uniqueResult();
			return rowCount.intValue();
		} catch (HibernateException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	@Override
	public int getTotalUsersCount() throws ParseException {
		Session session = sessionFactory.getCurrentSession();

		try {
			Query selectQuery = session
					.createQuery("select count(*) from Other where reg_date>='2017-07-13'");
			//selectQuery.setParameter("acode", "srichaitanya");
			Integer count = (Integer) selectQuery.uniqueResult();
			
			
			//Integer id = (int) (long) criteria.uniqueResult();
			System.out.println("Total count is : " +count);
			
			return count;

		} catch (HibernateException e) {
			e.printStackTrace();
			return 0;
		}
	}

}
