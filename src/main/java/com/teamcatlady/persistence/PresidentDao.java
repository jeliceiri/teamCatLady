package com.teamcatlady.persistence;

import com.teamcatlady.entity.President;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Expression;
import java.util.ArrayList;
import java.util.List;

/**
 * The type President dao.
 */
public class PresidentDao {

    /**
     * The Session factory.
     */
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();
    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * Gets president by id.
     *
     * @param id the id
     * @return the by id
     */
    public President getById(int id) {
        logger.debug("Searching for getById {}", id);
        Session session = sessionFactory.openSession();
        President president = session.get(President.class, id);
        session.close();
        return president;
    }

    /**
     * Gets president by presidentail number.
     *
     * @param number the number
     * @return the by number
     */
    public President getByNumber(int number) {
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<President> query = builder.createQuery(President.class);
        Root<President> root = query.from(President.class);
        Expression<String> propertyPath = root.get("number");
        query.where(builder.equal(propertyPath, number));
        President president = session.createQuery(query).uniqueResult();
        session.close();
        return president;
    }

    /**
     * Gets all presidents.
     *
     * @return the all
     */
    public List<President> getAll() {
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<President> query = builder.createQuery(President.class);
        Root<President> root = query.from(President.class);
        List<President> presidents = session.createQuery(query).getResultList();
        session.close();
        return presidents;
    }

    /**
     * Gets presidents by party.
     *
     * @param party the party
     * @return the by party
     */
    public List<President> getByParty(String party) {
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<President> query = builder.createQuery(President.class);
        Root<President> root = query.from(President.class);
        Expression<String> propertyPath = root.get("party");
        query.where(builder.equal(propertyPath, party));
        List<President> presidents = session.createQuery(query).getResultList();
        session.close();
        return presidents;
    }

    /**
     * Gets presidents by birth year.
     *
     * @param birthYear the birth year
     * @return the by birth year
     */
    public List<President> getByBirthYear(int birthYear) {
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<President> query = builder.createQuery(President.class);
        Root<President> root = query.from(President.class);
        Expression<String> propertyPath = root.get("birthYear");
        query.where(builder.equal(propertyPath, birthYear));
        List<President> presidents = session.createQuery(query).getResultList();
        session.close();
        return presidents;
    }

    /**
     * Gets all living presidents.
     *
     * @return the all living presidents
     */

    public List<President> getAllLivingPresidents() {
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<President> query = builder.createQuery(President.class);
        Root<President> root = query.from(President.class);
        Expression<String> propertyPath = root.get("deathYear");
        query.where(builder.isNull(propertyPath));
        List<President> presidents = session.createQuery(query).getResultList();
        session.close();
        return presidents;
    }

    /**
     * Gets all dead presidents.
     *
     * @return the all dead presidents
     */
    public List<President> getAllDeadPresidents() {
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<President> query = builder.createQuery(President.class);
        Root<President> root = query.from(President.class);
        Expression<String> propertyPath = root.get("deathYear");
        query.where(builder.isNotNull(propertyPath));
        List<President> presidents = session.createQuery(query).getResultList();
        session.close();
        return presidents;
    }

    /**
     * Save or update a president.
     *
     * @param president the president
     */
    public void saveOrUpdate(President president) {
        logger.debug("SaveOrUpdating: {}", president);
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(president);
        transaction.commit();
        session.close();
    }

    /**
     * Insert a president.
     *
     * @param president the president
     * @return the int
     */
    public int insert(President president) {
        int id = 0;
        logger.debug("Inserting: {}", president);
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        id = (int)session.save(president);
        transaction.commit();
        session.close();
        return id;
    }

    /**
     * Delete a president.
     *
     * @param president the president
     */
    public void delete(President president) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(president);
        transaction.commit();
        session.close();
    }

    public President getByName(String name) {
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<President> query = builder.createQuery(President.class);
        Root<President> root = query.from(President.class);
        Expression<String> propertyPath = root.get("name");
        query.where(builder.equal(propertyPath, name));
        President president = session.createQuery(query).getSingleResult();
        session.close();
        return president;
    }
}
