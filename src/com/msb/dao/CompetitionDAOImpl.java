package com.msb.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.msb.bean.StudentCompetitionPoints;
import com.msb.model.Competition;
import com.msb.model.CompetitionText;
import com.msb.model.MSTCompetition;
import com.msb.model.UploadATalent;

@Repository
@Transactional
public class CompetitionDAOImpl implements CompetitionDAO {

	@Autowired
	private SessionFactory sessionFactory;

	/*
	 * @PersistenceContext EntityManager entityManger;
	 */

	@SuppressWarnings("unchecked")
	@Override
	public List<Competition> getCompetitionsForSchool(int competionCategory) {
		Session session = sessionFactory.getCurrentSession();

		try {
			Criteria criteria = session.createCriteria(Competition.class);
			Criterion category = Restrictions.eq("comp_category",
					competionCategory);
			Criterion status = Restrictions.eq("status", 1);
			criteria.add(Restrictions.and(category, status));
			criteria.addOrder(Order.desc("end_date"));
			List<Competition> competitions = criteria.list();

			return competitions;

		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		}

	}
	
	@Override
	public List<Competition> getCompetitionsByCategory(int competionCategory, int userSegment) {
		Session session = sessionFactory.getCurrentSession();

		try {
			Criteria criteria = session.createCriteria(Competition.class);
			Criterion category = Restrictions.eq("comp_category",
					competionCategory);
			Criterion status = Restrictions.eq("status", 1);

			Criterion user_segment = Restrictions.eq("user_category",
					userSegment);
			Criterion category_status= Restrictions.and(category, status);
				
				
			criteria.add(Restrictions.and(user_segment, category_status));
			
			criteria.addOrder(Order.desc("end_date"));
			List<Competition> competitions = criteria.list();

			return competitions;

		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public Competition getCompetitionDetails(int compid) {
		Session session = sessionFactory.getCurrentSession();

		try {
			return (Competition) session.get(Competition.class, compid);

		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Competition loadCompetitionDetails(int compid) {
		Session session = sessionFactory.getCurrentSession();

		try {
			return (Competition) session.load(Competition.class, compid);

		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Integer saveTextCompetition(CompetitionText competitionText) {
		Session session = sessionFactory.getCurrentSession();

		try {
			return (Integer) session.save(competitionText);

		} catch (HibernateException e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public boolean updateCompetition(Competition competition) {
		Session session = sessionFactory.getCurrentSession();

		try {
			session.update(competition);
			return true;

		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Integer getUserTotalTextSubmissions(
			String username, String type) {
		Session session = sessionFactory.getCurrentSession();

		try {
			Criteria criteria = session.createCriteria(CompetitionText.class);
			//Criterion category = Restrictions.eq("comp_category_id",
					//comp_cat_id);
			Criterion comp = Restrictions.eq("entry_type", type);

			Criterion user = Restrictions.eq("user_name", username);

			Criterion criterion = Restrictions.and(user, comp);

			criteria.add(Restrictions.and(criterion, user));
			criteria.setProjection(Projections.rowCount());
			Integer row_count = (int) (long) criteria.uniqueResult();
			System.out.println(row_count);
			return row_count;

		} catch (HibernateException e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public Integer getUserTotalMSTCometitionSubmissions(
			String username, String submission_type) {
		Session session = sessionFactory.getCurrentSession();

		try {
			Criteria criteria = session.createCriteria(MSTCompetition.class);

			//Criterion comp = Restrictions.eq("comp_id", comp_id);

			Criterion user = Restrictions.eq("user_name", username);

			Criterion submission = Restrictions.eq("submission_type",
					submission_type);

			Criterion criterion = Restrictions.and(submission, user);

			criteria.add(Restrictions.and(criterion, submission));
			criteria.setProjection(Projections.rowCount());
			Integer row_count = (int) (long) criteria.uniqueResult();
			System.out.println(row_count);
			return row_count;

		} catch (HibernateException e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public Integer saveMSTCompetitions(MSTCompetition pmdCompetition) {
		Session session = sessionFactory.getCurrentSession();

		try {
			return (Integer) session.save(pmdCompetition);

		} catch (HibernateException e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public Integer getMSTCompetitionMaxID() {
		Session session = sessionFactory.getCurrentSession();

		try {
			Criteria criteria = session.createCriteria(MSTCompetition.class);
			criteria.setProjection(Projections.max("id"));
			Integer id = (Integer) criteria.uniqueResult();
			if (id != null)
				return id + 1;
			else
				return 1;
		} catch (HibernateException e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public CompetitionText getTextCompetitionSubmission(Integer id) {
		Session session = sessionFactory.getCurrentSession();

		try {
			return (CompetitionText) session.get(CompetitionText.class, id);
			//Hibernate.initialize(text.getCompetition());
			//Hibernate.initialize(text.getCompetitionCategory());
			//return text;
		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public MSTCompetition getMSTCompetitionSubmission(Integer id) {
		Session session = sessionFactory.getCurrentSession();

		try {
			return (MSTCompetition) session.get(MSTCompetition.class, id);
			//MSTCompetition competition= (MSTCompetition) session.get(MSTCompetition.class, id);
			//Hibernate.initialize(competition.getCompetition());
			//return competition;
		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public UploadATalent getUploadATalentSubmission(Integer id) {
		Session session = sessionFactory.getCurrentSession();

		try {
			return (UploadATalent) session.get(UploadATalent.class, id);

		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean updateTextSubmissionPoints(Integer id, int points) {
		Session session = sessionFactory.getCurrentSession();
		try {
			Criteria criteria = session.createCriteria(CompetitionText.class);
			criteria.add(Restrictions.eq("id", id));
			CompetitionText competitionText = (CompetitionText) criteria
					.uniqueResult();
			competitionText.setPoints(competitionText.getPoints() + points);
			session.update(competitionText);

			return true;
		} catch (HibernateException exception) {
			exception.printStackTrace();
			return false;
		}
	}
	
	@Override
	public boolean updateMSTSubmissionPoints(Integer id, int points) {
		Session session = sessionFactory.getCurrentSession();
		try {
			Criteria criteria = session.createCriteria(MSTCompetition.class);
			criteria.add(Restrictions.eq("id", id));
			MSTCompetition pmdCompetition = (MSTCompetition) criteria
					.uniqueResult();
			pmdCompetition.setPoints(pmdCompetition.getPoints() + points);
			session.update(pmdCompetition);

			return true;
		} catch (HibernateException exception) {
			exception.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateUATSubmissionPoints(Integer id, int points) {
		Session session = sessionFactory.getCurrentSession();
		try {
			Criteria criteria = session.createCriteria(UploadATalent.class);
			criteria.add(Restrictions.eq("id", id));
			UploadATalent wiytCompetition = (UploadATalent) criteria
					.uniqueResult();
			wiytCompetition.setPoints(wiytCompetition.getPoints() + points);
			session.update(wiytCompetition);

			return true;
		} catch (HibernateException exception) {
			exception.printStackTrace();
			return false;
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<StudentCompetitionPoints> getStudentCompetitionPoints(String user_name) {
		Session session = sessionFactory.getCurrentSession();
		List<StudentCompetitionPoints> studentCompPoints=new ArrayList<StudentCompetitionPoints>();
		try {
			String query = "select IFNULL(SUM(ct.POINTS),0) as total,ct.USER_ID as user_name,UPPER(cc.category_name) as category from competition_text ct "
					+ "INNER JOIN competition cmp on ct.COMP_ID=cmp.COMP_ID join competition_category cc on cmp.comp_category=cc.category_pk"
					 +" where ct.USER_ID=:user_name and ct.status=1 group by ct.USER_ID,cmp.COMP_CATEGORY order by total desc";
			Query compPointsQuery = session
					.createSQLQuery(query)
					.addScalar("total", StandardBasicTypes.INTEGER)
					.addScalar("user_name")
					.addScalar("category")
					.setResultTransformer(Transformers.aliasToBean(StudentCompetitionPoints.class));
			compPointsQuery.setParameter("user_name", user_name);
			
			List<StudentCompetitionPoints> studentCompPoints1 = compPointsQuery
					.list();
			String query1 = "SELECT IFNULL(SUM(POINTS),0) AS TOTAL,user_name,'PAINTING' as category  FROM COMP_SUBMISSIONS WHERE USER_NAME=:user_name "
					+ "and status=1 GROUP BY USER_NAME";
			Query compPointsQuery1 = session
					.createSQLQuery(query1)
					.addScalar("total", StandardBasicTypes.INTEGER)
					.addScalar("user_name")
					.addScalar("category")
					.setResultTransformer(Transformers.aliasToBean(StudentCompetitionPoints.class));
			compPointsQuery1.setParameter("user_name", user_name);
			
			List<StudentCompetitionPoints> studentCompPoints2 = compPointsQuery1.list();
			
			String query2 = "SELECT IFNULL(SUM(POINTS),0) AS TOTAL,user_name,UPPER(SUBMISSION_TYPE) as category"
					+ "  FROM PANORAMA_EVENTS_SUBMISSION WHERE USER_NAME=:user_name and status=1 GROUP BY SUBMISSION_TYPE,USER_NAME";
			Query compPointsQuery2 = session
					.createSQLQuery(query2)
					.addScalar("total", StandardBasicTypes.INTEGER)
					.addScalar("user_name")
					.addScalar("category")
					.setResultTransformer(Transformers.aliasToBean(StudentCompetitionPoints.class));
			compPointsQuery2.setParameter("user_name", user_name);
			
			List<StudentCompetitionPoints> studentCompPoints3 = compPointsQuery2.list();
			
			studentCompPoints.addAll(studentCompPoints1);
			studentCompPoints.addAll(studentCompPoints2);
			studentCompPoints.addAll(studentCompPoints3);
			return studentCompPoints;
		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	
	/*nextorprevious for text entry start*/
	@Override
	public int getNextOrPreviousTextId(int id,
			boolean next, boolean previous) {
		Session session = sessionFactory.getCurrentSession();
		try {
			
			Criteria criteria = session
					.createCriteria(CompetitionText.class);

			
			if (next) {
				criteria.addOrder(Order.asc("id"));
				criteria.add(Restrictions.gt("id", id));
			}
			if (previous) {
				criteria.addOrder(Order.desc("id"));
				criteria.add(Restrictions.lt("id", id));

			}

			criteria.setMaxResults(1);
			CompetitionText competitionText = (CompetitionText) criteria
					.uniqueResult();			
			
			
			if (competitionText != null && competitionText.getId() != 0)
				return competitionText.getId();		
			else
				return 0;

		} catch (HibernateException e) {
			e.printStackTrace();

		}
		
		return 0;
	}
	
	@Override
	public int getNextOrPreviousEntryId(int id, String type,
			boolean next, boolean previous) {
		Session session = sessionFactory.getCurrentSession();
		try {
			/*
			 * Query selectQuery = session
			 * .createQuery("SELECT SUBMISSION_ID FROM MST_SUBMISSION WHERE SUBMISSION_ID>:id AND SUBMISSION_TYPE=:type"
			 * ); selectQuery.setParameter("id", id); selectQuery.setParameter("type",
			 * type); Integer nxt = (Integer) selectQuery.uniqueResult();
			 * 
			 * if (nxt != null) return nxt; else return 1;
			 */
			Criteria criteria = session.createCriteria(MSTCompetition.class);
			Criterion category = Restrictions.eq("submission_type",
					type);

			if (next) {
				criteria.addOrder(Order.asc("id"));
				Criterion nxt = Restrictions.gt("id", id);
				criteria.add(Restrictions.and(category, nxt));
			} else if(previous) {
				criteria.addOrder(Order.desc("id"));
				Criterion pre = Restrictions.lt("id", id);
				Criterion category_status= Restrictions.and(category, pre);
				
				
				criteria.add(Restrictions.and(pre, category_status));
			}
				//criteria.addOrder(Order.desc("id"));
				criteria.setMaxResults(1);
				MSTCompetition mst = (MSTCompetition) criteria
						.uniqueResult();
				if (mst != null && mst.getId() != 0)
					return mst.getId();		
				else
					return 0;

		} catch (HibernateException e) {
			e.printStackTrace();
			return 0;
		}
	}
			
	
	@Override
	public int getNextOrPreviousUatId(int id,
			boolean next, boolean previous) {
		Session session = sessionFactory.getCurrentSession();
		try {
			
			Criteria criteria = session
					.createCriteria(UploadATalent.class);

			
			criteria.addOrder(Order.desc("id"));
			if (next)
				criteria.add(Restrictions.gt("id", id));
			if (previous) {
				criteria.add(Restrictions.lt("id", id));

			}
			
			criteria.setMaxResults(1);
			UploadATalent wiyt = (UploadATalent) criteria
					.uniqueResult();			
			
			
			if (wiyt != null && wiyt.getId() != 0)
				return wiyt.getId();		
			else
				return 0;

		} catch (HibernateException e) {
			e.printStackTrace();

		}
		
		return 0;
	}
	
	@Override
	public boolean saveTextEntryVisit(int id) throws SQLException {
		Session session = sessionFactory.getCurrentSession();
		try {
			
			Criteria criteria = session.createCriteria(CompetitionText.class);
			criteria.add(Restrictions.eq("id", id));
			CompetitionText competitionText = (CompetitionText) criteria
					.uniqueResult();
			competitionText.setVisits(competitionText.getVisits() + 1);
			session.merge(id);
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
	public boolean saveEntryVisit(int id) throws SQLException {
		Session session = sessionFactory.getCurrentSession();
		try {
			
			Criteria criteria = session.createCriteria(MSTCompetition.class);
			criteria.add(Restrictions.eq("id", id));
			MSTCompetition entry = (MSTCompetition) criteria
					.uniqueResult();
			entry.setVisits(entry.getVisits() + 1);
			session.merge(id);
			 
			return true;
		} catch (HibernateException exception) {
			exception.printStackTrace();
			return false;
		}

	}
	
	/* Others DAOImpl */
	@Override
	public Integer saveUploadATalent(UploadATalent uploadATalent) {
		Session session = sessionFactory.getCurrentSession();

		try {
			return (Integer) session.save(uploadATalent);

		} catch (HibernateException e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public Integer getUploadATalentMaxID() {
		Session session = sessionFactory.getCurrentSession();

		try {
			Criteria criteria = session.createCriteria(UploadATalent.class);
			criteria.setProjection(Projections.max("id"));
			Integer id = (Integer) criteria.uniqueResult();
			if (id != null)
				return id + 1;
			else
				return 1;
		} catch (HibernateException e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public Integer getStudentTotalUatSubmissionsCount(String username) {
		Session session = sessionFactory.getCurrentSession();

		try {
			Criteria criteria = session.createCriteria(UploadATalent.class);
			Criterion user_name = Restrictions.eq("user_name", username);
			criteria.add(user_name);
			criteria.setProjection(Projections.rowCount());
			Integer row_count = (int) (long) criteria.uniqueResult();
			System.out.println(row_count);
			return row_count;

		} catch (HibernateException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	@Override
	public boolean saveUatEntryVisit(int id) throws SQLException {
		Session session = sessionFactory.getCurrentSession();
		try {
			
			Criteria criteria = session.createCriteria(UploadATalent.class);
			criteria.add(Restrictions.eq("id", id));
			UploadATalent entry = (UploadATalent) criteria
					.uniqueResult();
			entry.setVisits(entry.getVisits() + 1);
			session.merge(id);
			 
			return true;
		} catch (HibernateException exception) {
			exception.printStackTrace();
			return false;
		}

	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<CompetitionText> getAllTextEntries(String type, int userCategory,
			int limit, int offset) {
		Session session = sessionFactory.getCurrentSession();

		try {
			Criteria criteria = session.createCriteria(CompetitionText.class);
			Criterion category = Restrictions.eq("entry_type",
					type);
			Criterion userType = Restrictions.eq("user_category", userCategory);
			Criterion status = Restrictions.eq("status", 1);
				
				Criterion criterion = Restrictions.and(category, status);

				criteria.add(Restrictions.and(criterion, userType));
			
				criteria.addOrder(Order.desc("submit_date"));
				if (offset != 0)
					criteria.setFirstResult(offset);

				if (limit != 0)
					criteria.setMaxResults(limit);
				List<CompetitionText> competitions = criteria.list();

			return competitions;

		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		}

	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<CompetitionText> getAllTextEntriesByClient(String type, String comp_by,
			int limit, int offset) {
		Session session = sessionFactory.getCurrentSession();

		try {
			Criteria criteria = session.createCriteria(CompetitionText.class);
			Criterion category = Restrictions.eq("entry_type",
					type);
			Criterion comp_client = Restrictions.eq("comp_by", comp_by);
			Criterion status = Restrictions.eq("status", 1);
				
				Criterion criterion = Restrictions.and(category, status);

				criteria.add(Restrictions.and(criterion, comp_client));
			
				criteria.addOrder(Order.desc("submit_date"));
				if (offset != 0)
					criteria.setFirstResult(offset);

				if (limit != 0)
					criteria.setMaxResults(limit);
				List<CompetitionText> competitions = criteria.list();

			return competitions;

		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		}

	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<MSTCompetition> getAllMSTEntries(String type, int userCategory,
			int limit, int offset) {
		Session session = sessionFactory.getCurrentSession();

		try {
			Criteria criteria = session.createCriteria(MSTCompetition.class);
			Criterion category = Restrictions.eq("submission_type",
					type);
			Criterion userType = Restrictions.eq("user_category", userCategory);
			Criterion status = Restrictions.eq("status", 1);

			Criterion criterion = Restrictions.and(category, status);
			//criteria.add(Restrictions.and(category, userType));
			criteria.add(Restrictions.and(criterion, userType));
			
				criteria.addOrder(Order.desc("submit_date"));
				if (offset != 0)
					criteria.setFirstResult(offset);

				if (limit != 0)
					criteria.setMaxResults(limit);
				List<MSTCompetition> competitions = criteria.list();

			return competitions;

		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		}

	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<MSTCompetition> getAllMSTEntriesByClient(String type, String comp_by,
			int limit, int offset) {
		Session session = sessionFactory.getCurrentSession();

		try {
			Criteria criteria = session.createCriteria(MSTCompetition.class);
			Criterion category = Restrictions.eq("submission_type",
					type);
			Criterion userType = Restrictions.eq("comp_by", comp_by);
			Criterion status = Restrictions.eq("status", 1);

			Criterion criterion = Restrictions.and(category, status);
			//criteria.add(Restrictions.and(category, userType));
			criteria.add(Restrictions.and(criterion, userType));
			
				criteria.addOrder(Order.desc("submit_date"));
				if (offset != 0)
					criteria.setFirstResult(offset);

				if (limit != 0)
					criteria.setMaxResults(limit);
				List<MSTCompetition> competitions = criteria.list();

			return competitions;

		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		}

	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<UploadATalent> getAllUATEntries(int userCategory, int limit, int offset) {
		Session session = sessionFactory.getCurrentSession();

		try {
			Criteria criteria = session.createCriteria(UploadATalent.class);
			Criterion category = Restrictions.eq("user_category", userCategory);
			Criterion status = Restrictions.eq("status", 1);

				criteria.add(Restrictions.and(category, status));
			
				criteria.addOrder(Order.desc("submit_date"));
				if (offset != 0)
					criteria.setFirstResult(offset);

				if (limit != 0)
					criteria.setMaxResults(limit);
				List<UploadATalent> competitions = criteria.list();

			return competitions;

		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		}

	}
	
	@Override
	public Integer getStudentTotalTextSubmissionsOfACompetition(
			String username, int comp_id) {
		Session session = sessionFactory.getCurrentSession();

		try {
			Criteria criteria = session.createCriteria(CompetitionText.class);
			//Criterion category = Restrictions.eq("comp_category_id",
					//comp_cat_id);
			Criterion comp = Restrictions.eq("comp_id", comp_id);

			Criterion user = Restrictions.eq("user_name", username);

			Criterion criterion = Restrictions.and(user, comp);

			criteria.add(Restrictions.and(criterion, user));
			criteria.setProjection(Projections.rowCount());
			Integer row_count = (int) (long) criteria.uniqueResult();
			System.out.println(row_count);
			return row_count;

		} catch (HibernateException e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public Integer getStudentTotalMSTSubmissionsOfACompetition(
			String username, int comp_id) {
		Session session = sessionFactory.getCurrentSession();

		try {
			Criteria criteria = session
					.createCriteria(MSTCompetition.class);

			Criterion comp = Restrictions.eq("comp_id", comp_id);

			Criterion user = Restrictions.eq("user_name", username);

			criteria.add(Restrictions.and(comp, user));
			criteria.setProjection(Projections.rowCount());
			Integer row_count = (int) (long) criteria.uniqueResult();
			System.out.println(row_count);
			return row_count;

		} catch (HibernateException e) {
			e.printStackTrace();
			return 0;
		}
	}

}