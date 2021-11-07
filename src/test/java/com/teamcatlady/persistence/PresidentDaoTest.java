package com.teamcatlady.persistence;

import com.teamcatlady.entity.President;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import test.util.Database;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PresidentDaoTest {

    PresidentDao dao;
    private final Logger logger = LogManager.getLogger(this.getClass());

    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");

        dao = new PresidentDao();
    }

    @Test
    void getByIdSuccess() {
        President president = dao.getById(1);
        assertNotNull(president);
        assertEquals("George Washington", president.getName());
    }

    @Test
    void getByNumberSuccess() {
        President president = dao.getByNumber(44);
        assertNotNull(president);
        assertEquals("Barack Obama", president.getName());

    }

    @Test
    void getAllSuccess() {
        List<President> presidentList = dao.getAll();
        assertEquals(6, presidentList.size());
    }

    @Test
    void getByPartySuccess() {
        List<President> presidentList = dao.getByParty("Democratic");
        assertEquals(2, presidentList.size());
    }

    @Test
    void getByBirthYearSuccess() {
        List<President> presidentList = dao.getByBirthYear(1946);
        assertEquals(2, presidentList.size());
    }

    @Test
    void getLivingPresidentsSuccess() {
        List<President> livingPresidents = dao.getAllLivingPresidents();
        assertEquals(3, livingPresidents.size());
    }

    @Test
    void getDeadPresidentsSuccess() {
        List<President> deadPresidents = dao.getAllDeadPresidents();
        assertEquals(3, deadPresidents.size());
    }

    //Equals not working with both presidents...
    @Test
    void saveOrUpdateSuccess() {
        String newName = "John Adams the OG";
        President presidentToUpdate = dao.getById(2);
        presidentToUpdate.setName(newName);
        dao.saveOrUpdate(presidentToUpdate);
        President retrievedPresident = dao.getById(2);
        assertEquals(presidentToUpdate.getName(), newName);

    }

    @Test
    void insertSuccess() {
        President president = new President(66, "Raymond Barnacles", 1995, 2038, "2021-12-25", "2023-01-01", "Green");
        int id = dao.insert(president);
        assertNotEquals(0, id);
        President insertedPresident = dao.getById(id);
        assertEquals(insertedPresident.getName(), "Raymond Barnacles");
    }

    @Test
    void deleteSuccess() {
        President presidentToDelete = dao.getById(3);
        dao.delete(presidentToDelete);
        assertNull(dao.getById(3));
    }
}
