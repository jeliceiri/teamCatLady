package com.teamcatlady.persistence;

import com.teamcatlady.entity.President;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

public class PresidentDao {

    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    public President getById(int id) {
        return new President();
    }

    public List<President> getAllPresidents() {
        return new ArrayList<President>();
    }

    public List<President> getByParty(String party) {
        return new ArrayList<President>();
    }

    // TODO this could be reworked to just use one method, maybe?
    // Or maybe the API could call something like getByLivingStatus(Boolean livingStatus)
    // with that boolean coming from the request, and then the statement could be built using that
    // Up to you on which you think is cleaner! Just let me know what the method to call from the API is :)
    public List<President> getAllLivingPresidents() {
        return new ArrayList<President>();
    }

    public List<President> getAllDeadPresidents() {
        return new ArrayList<President>();
    }

    public void saveOrUpdate(President president) {

    }

    public int insert(President president) {
        return 0;
    }

    public void delete(President president) {

    }


}
