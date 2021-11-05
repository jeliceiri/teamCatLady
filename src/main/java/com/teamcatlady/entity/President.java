package com.teamcatlady.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

/**
 * The type President.
 *
 * @author jeliceiri 11/5/21
 */
@Entity(name = "President")
@Table(name = "presidents")
public class President {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Column(name = "president")
    private String name;

    @Column(name = "birth_year")
    private int birthYear;

    @Column(name = "death_year")
    private int deathYear;

    @Column(name = "took_office")
    private String tookOffice;

    @Column(name = "left_office")
    private String leftOffice;

    private String party;

    /**
     * Instantiates a new President.
     */
    public President() {
    }

    /**
     * Instantiates a new President.
     *
     * @param name       the name
     * @param birthYear  the birth year
     * @param deathYear  the death year
     * @param tookOffice the took office
     * @param leftOffice the left office
     * @param party      the party
     */
    public President(String name, int birthYear, int deathYear, String tookOffice, String leftOffice, String party) {
        this.name = name;
        this.birthYear = birthYear;
        this.deathYear = deathYear;
        this.tookOffice = tookOffice;
        this.leftOffice = leftOffice;
        this.party = party;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets birth year.
     *
     * @return the birth year
     */
    public int getBirthYear() {
        return birthYear;
    }

    /**
     * Sets birth year.
     *
     * @param birthYear the birth year
     */
    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    /**
     * Gets death year.
     *
     * @return the death year
     */
    public int getDeathYear() {
        return deathYear;
    }

    /**
     * Sets death year.
     *
     * @param deathYear the death year
     */
    public void setDeathYear(int deathYear) {
        this.deathYear = deathYear;
    }

    /**
     * Gets took office.
     *
     * @return the took office
     */
    public String getTookOffice() {
        return tookOffice;
    }

    /**
     * Sets took office.
     *
     * @param tookOffice the took office
     */
    public void setTookOffice(String tookOffice) {
        this.tookOffice = tookOffice;
    }

    /**
     * Gets left office.
     *
     * @return the left office
     */
    public String getLeftOffice() {
        return leftOffice;
    }

    /**
     * Sets left office.
     *
     * @param leftOffice the left office
     */
    public void setLeftOffice(String leftOffice) {
        this.leftOffice = leftOffice;
    }

    /**
     * Gets party.
     *
     * @return the party
     */
    public String getParty() {
        return party;
    }

    /**
     * Sets party.
     *
     * @param party the party
     */
    public void setParty(String party) {
        this.party = party;
    }

    @Override
    public String toString() {
        return "President{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthYear=" + birthYear +
                ", deathYear=" + deathYear +
                ", tookOffice='" + tookOffice + '\'' +
                ", leftOffice='" + leftOffice + '\'' +
                ", party='" + party + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        President president = (President) o;
        return id == president.id && birthYear == president.birthYear && deathYear == president.deathYear && Objects.equals(name, president.name) && Objects.equals(tookOffice, president.tookOffice) && Objects.equals(leftOffice, president.leftOffice) && Objects.equals(party, president.party);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, birthYear, deathYear, tookOffice, leftOffice, party);
    }
}
