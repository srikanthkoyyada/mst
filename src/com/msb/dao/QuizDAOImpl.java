package com.msb.dao;

import java.util.List;

import org.hibernate.Criteria;
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

import com.msb.bean.StudentQuizPoints;
import com.msb.model.Quiz;
import com.msb.model.QuizGenre;
import com.msb.model.QuizPoints;
import com.msb.model.QuizScores;
import com.msb.model.StudentTestsCount;
import com.msb.util.MsbUtil;

@Repository
@Transactional
public class QuizDAOImpl implements QuizDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Quiz> getQuizzesBasedOnClient(String client, int genre,
			Integer offset, Integer maxResults, String user_segment) {

		Session session = sessionFactory.getCurrentSession();
		System.out.println(client);
		try {
			Criteria criteria = session.createCriteria(Quiz.class);

			Criterion category = Restrictions.eq("genre", genre);
			Criterion uSegement = Restrictions.eq("category", user_segment);

			if (client.equals("all")) {

				criteria.add(Restrictions.and(uSegement, category));
			} else {
				Criterion quiz_by = Restrictions.eq("client", client);
				Criterion quiz_category = Restrictions.and(uSegement, category);
				criteria.add(Restrictions.and(quiz_category, quiz_by));
			}

			criteria.addOrder(Order.desc("quiz_id"));
			@SuppressWarnings("unchecked")
			List<Quiz> quizzes = criteria
					.setFirstResult(offset != null ? offset : 0)
					.setMaxResults(maxResults != null ? maxResults : 10).list();
			return quizzes;

		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		}

	}
	
	// All quizzes
	@Override
	public List<Quiz> getAllQuizzesBasedOnClient(String client,
			Integer offset, Integer maxResults, String user_segment) {

		Session session = sessionFactory.getCurrentSession();
		System.out.println(client);
		try {
			Criteria criteria = session.createCriteria(Quiz.class);

			//Criterion category = Restrictions.eq("genre", genre);
			Criterion uSegement = Restrictions.eq("category", user_segment);

			if (client.equals("all")) {

				criteria.add(Restrictions.and(uSegement));
			} else {
				Criterion quiz_by = Restrictions.eq("client", client);
				Criterion quiz_category = Restrictions.and(uSegement);
				criteria.add(Restrictions.and(quiz_category, quiz_by));
			}

			criteria.addOrder(Order.desc("quiz_id"));
			@SuppressWarnings("unchecked")
			List<Quiz> quizzes = criteria
					.setFirstResult(offset != null ? offset : 0)
					.setMaxResults(maxResults != null ? maxResults : 10).list();
			return quizzes;

		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		}
	}
	//All quizzes

	@SuppressWarnings("unchecked")
	@Override
	public List<QuizGenre> getAllQuizGenres() {
		Session session = sessionFactory.getCurrentSession();

		try {
			List<QuizGenre> quizGenres = (List<QuizGenre>) session
					.createCriteria(QuizGenre.class).list();

			//System.out.println(quizGenres.size());
			return quizGenres;

		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public int getQuizzesCountBasedOnClient(String client, int genre,
			String user_segment) {
		Session session = sessionFactory.getCurrentSession();

		try {
			Criteria criteria = session.createCriteria(Quiz.class);

			Criterion category = Restrictions.eq("genre", genre);
			Criterion uSegement = Restrictions.eq("category", user_segment);

			if (client.equals("all")) {

				criteria.add(Restrictions.and(uSegement, category));
			} else {
				Criterion quiz_by = Restrictions.eq("client", client);
				Criterion quiz_category = Restrictions.and(uSegement, category);
				criteria.add(Restrictions.and(quiz_category, quiz_by));
			}
			criteria.setProjection(Projections.rowCount());
			Long rowCount = (Long) criteria.uniqueResult();
			return rowCount.intValue();
		} catch (HibernateException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	//All quizzes
	@Override
	public int getAllQuizzesCountBasedOnClient(String client,
			String user_segment) {
		Session session = sessionFactory.getCurrentSession();

		try {
			Criteria criteria = session.createCriteria(Quiz.class);

			//Criterion category = Restrictions.eq("genre", genre);
			Criterion uSegement = Restrictions.eq("category", user_segment);

			if (client.equals("all")) {

				criteria.add(Restrictions.and(uSegement));
			} else {
				Criterion quiz_by = Restrictions.eq("client", client);
				Criterion quiz_category = Restrictions.and(uSegement);
				criteria.add(Restrictions.and(quiz_category, quiz_by));
			}
			criteria.setProjection(Projections.rowCount());
			Long rowCount = (Long) criteria.uniqueResult();
			return rowCount.intValue();
		} catch (HibernateException e) {
			e.printStackTrace();
			return 0;
		}
	}
	//All quizzes

	@Override
	public Quiz getQuiz(int id) {
		Session session = sessionFactory.getCurrentSession();

		try {
			return (Quiz) session.get(Quiz.class, id);
		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean isStudenTakentest(String id, String user_name) {
		Session session = sessionFactory.getCurrentSession();

		try {
			Criteria criteria = session.createCriteria(QuizPoints.class);

			Criterion qid = Restrictions.eq("quiz_id", id);
			Criterion user = Restrictions.eq("user_name", user_name);
			criteria.add(Restrictions.and(qid, user));
			criteria.setProjection(Projections.rowCount());

			Long rowCount = (Long) criteria.uniqueResult();
			System.out.println(rowCount);
			if (rowCount.intValue() != 0)
				return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}

	@Override
	public boolean saveQuizScores(QuizScores quizScores) {
		Session session = sessionFactory.getCurrentSession();

		try {
			session.save(quizScores);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean saveQuizPoints(QuizPoints quizPoints) {
		Session session = sessionFactory.getCurrentSession();

		try {
			session.save(quizPoints);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<StudentQuizPoints> getStudentQuizPoints(String user_name) {
		Session session = sessionFactory.getCurrentSession();

		try {
			String query = "select COALESCE(sum(x.Points),0) as total_points,x.user_name,g.genre from"
					+ " (select quizpt.POINTS,quizpt.USER_NAME,quiztable.genre from QUIZ_POINTS quizpt INNER JOIN QUIZ_TABLE quiztable "
					+ "on quizpt.QUIZID=quiztable.ID where quizpt.USER_NAME=:user_name) x right"
					+ " join QUIZ_GENRES g on x.genre=g.genre_id group by g.genre_id order by total_points";
			Query quizPointsQuery = session
					.createSQLQuery(query)
					.addScalar("total_points", StandardBasicTypes.INTEGER)
					.addScalar("user_name")
					.addScalar("genre")
					.setResultTransformer(
							Transformers.aliasToBean(StudentQuizPoints.class));
			quizPointsQuery.setString("user_name", user_name);
			@SuppressWarnings("unchecked")
			List<StudentQuizPoints> studentQuizPoints = quizPointsQuery.list();
			return studentQuizPoints;
		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Integer getNumberOfQuizParticipationsByStudent(String username) {
		Session session = sessionFactory.getCurrentSession();

		try {
			Criteria criteria = session.createCriteria(QuizScores.class);

			criteria.add(Restrictions.eq("user_name", username));

			criteria.setProjection(Projections.rowCount());

			Long rowCount = (Long) criteria.uniqueResult();
			return rowCount.intValue();
		} catch (HibernateException e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public Integer getStudentDayQuizCount(String username) {
		Session session = sessionFactory.getCurrentSession();

		try {
			Criteria criteria = session.createCriteria(StudentTestsCount.class);
			criteria.add(Restrictions.eq("user_name", username));
			StudentTestsCount testsCount = (StudentTestsCount) criteria
					.uniqueResult();
			if (testsCount != null) {
				if (testsCount.getSubmit_date().compareTo(MsbUtil.getCurrentDate())==0) {
					System.out.println("dates are equal");
					return testsCount.getNo_of_tests();
				} else {
					testsCount.setSubmit_date(MsbUtil.getCurrentDate());
					session.update(testsCount);
					return 0;
				}

			} else {
				StudentTestsCount testsCountNew =new StudentTestsCount();
				testsCountNew.setUser_name(username);
				testsCountNew.setSubmit_date(MsbUtil.getCurrentDate());
				session.save(testsCountNew);
				return 0;
			}

		} catch (HibernateException e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public boolean updateStudentDayQuizCount(String username) {

		Session session = sessionFactory.getCurrentSession();
		
		try {
			Query updateQuery = session
					.createSQLQuery("update STUDENT_TESTS_COUNT set NUMBER_OF_TESTS = NUMBER_OF_TESTS+1 where user_name=:username");
			updateQuery.setParameter("username", username);

			int updated = updateQuery.executeUpdate();

			if (updated != 0)
				return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}

	@Override
	public List<Quiz> getTeacherQuizzesBasedOnClient(String client,
			Integer offset, Integer maxResults, String category) {
		Session session = sessionFactory.getCurrentSession();
		System.out.println(client);
		try {
			Criteria criteria = session.createCriteria(Quiz.class);

			
			

			if (client.equals("all")) {

				criteria.add( Restrictions.eq("category", category));
			} else {
				Criterion quiz_by = Restrictions.eq("client", client);
				Criterion quiz_category = Restrictions.eq("category", category);
				criteria.add(Restrictions.and(quiz_category, quiz_by));
			}

			criteria.addOrder(Order.desc("quiz_id"));
			@SuppressWarnings("unchecked")
			List<Quiz> quizzes = criteria
					.setFirstResult(offset != null ? offset : 0)
					.setMaxResults(maxResults != null ? maxResults : 10).list();
			return quizzes;

		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public int getTeacherQuizzesCountBasedOnClient(String client,
			String user_category) {
		Session session = sessionFactory.getCurrentSession();

		try {
			Criteria criteria = session.createCriteria(Quiz.class);

			if (client.equals("all")) {

				criteria.add( Restrictions.eq("category", user_category));
			} else {
				Criterion quiz_by = Restrictions.eq("client", client);
				Criterion quiz_category = Restrictions.eq("category", user_category);
				criteria.add(Restrictions.and(quiz_category, quiz_by));
			}
			criteria.setProjection(Projections.rowCount());
			Long rowCount = (Long) criteria.uniqueResult();
			return rowCount.intValue();
		} catch (HibernateException e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int getQuizzesCountBasedOnGenre(String client,
			List<QuizGenre> quizGenres, String user_segment) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();

		try {
			Criteria criteria = session.createCriteria(Quiz.class);

			Criterion genre = Restrictions.eq("genre", quizGenres);
			Criterion uSegement = Restrictions.eq("category", user_segment);

			if (client.equals("all")) {

				criteria.add(Restrictions.and(uSegement, genre));
			} else {
				Criterion quiz_by = Restrictions.eq("client", client);
				Criterion quiz_category = Restrictions.and(uSegement, genre);
				criteria.add(Restrictions.and(quiz_category, quiz_by));
			}
			criteria.setProjection(Projections.rowCount());
			Long rowCount = (Long) criteria.uniqueResult();
			return rowCount.intValue();
		} catch (HibernateException e) {
			e.printStackTrace();
			return 0;
		}
	}

}
