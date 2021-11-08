package com.teamcatlady.persistence;

import com.teamcatlady.entity.President;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import test.util.Database;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type President dao test.
 */
public class PresidentDaoTest {

    /**
     * The Dao.
     */
    PresidentDao dao;
    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * Sets up.
     */
    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
        dao = new PresidentDao();
    }

    /**
     * Verify getById successfully runs
     */
    @Test
    void getByIdSuccess() {
        President president = dao.getById(1);
        assertNotNull(president);
        assertEquals("George Washington", president.getName());
    }

    /**
     * Verify getByNumber successfully runs
     */
    @Test
    void getByNumberSuccess() {
        President president = dao.getByNumber(44);
        assertNotNull(president);
        assertEquals("Barack Obama", president.getName());
    }

    /**
     * Verify getByName successfully runs
     */
    @Test
    void getByName() {
        President president = dao.getByName("George Washington");
        President retrievedPresident = dao.getByNumber(1);
        assertEquals(president, retrievedPresident);
    }

    /**
     * Verify getAll successfully runs
     */
    @Test
    void getAllSuccess() {
        List<President> presidentList = dao.getAll();
        assertEquals(6, presidentList.size());
    }

    /**
     * Verify getgetByParty successfully runs
     */
    @Test
    void getByPartySuccess() {
        List<President> presidentList = dao.getByParty("Democratic");
        assertEquals(2, presidentList.size());
    }

    /**
     * Verify getByBirthYear successfully runs
     */
    @Test
    void getByBirthYearSuccess() {
        List<President> presidentList = dao.getByBirthYear(1946);
        assertEquals(2, presidentList.size());
    }

    /**
     * Verify getAllLivingPresidents successfully runs
     */
    @Test
    void getLivingPresidentsSuccess() {
        List<President> livingPresidents = dao.getAllLivingPresidents();
        assertEquals(3, livingPresidents.size());
    }

    /**
     * Verify getAllDeadPresidents successfully runs
     */
    @Test
    void getDeadPresidentsSuccess() {
        List<President> deadPresidents = dao.getAllDeadPresidents();
        assertEquals(3, deadPresidents.size());
    }

    /**
     * Verify saveOrUpdate successfully runs
     */
    @Test
    void saveOrUpdateSuccess() {
        String newName = "John Adams the OG";
        President presidentToUpdate = dao.getById(2);
        presidentToUpdate.setName(newName);
        dao.saveOrUpdate(presidentToUpdate);
        President retrievedPresident = dao.getById(2);
        assertEquals(presidentToUpdate, retrievedPresident);
    }

    /**
     * Verify insert successfully runs
     */
    @Test
    void insertSuccess() {
        President president = new President(66, "Raymond Barnacles", 1995, 2038, "2021-12-25", "2023-01-01", "Green");
        int id = dao.insert(president);
        assertNotEquals(0, id);
        President insertedPresident = dao.getById(id);
        assertEquals(president, insertedPresident);
    }

    /**
     * Verify delete successfully runs
     */
    @Test
    void deleteSuccess() {
        President presidentToDelete = dao.getById(3);
        dao.delete(presidentToDelete);
        assertNull(dao.getById(3));
    }
}
