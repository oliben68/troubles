package com.osteck.troubles.entities;

import org.neo4j.ogm.annotation.*;

import java.util.Date;

@NodeEntity
public class FamilyMember {

    @Id
    @GeneratedValue
    private Long id;

    @Relationship(type = "IS_OFFSPRING")
    private FamilyMember mother;

    @Relationship(type = "IS_OFFSPRING")
    private FamilyMember father;

    @Relationship(type = "IS_SPOUSE")
    private FamilyMember spouse;

    private String firstName;
    private String lastName;
    private String maidenName;
    private Address placeOfBirth;
    private Date dob;

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMaidenName() {
        return maidenName;
    }

    public void setMaidenName(String maidenName) {
        this.maidenName = maidenName;
    }

    public Address getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(Address placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public FamilyMember getMother() {
        return mother;
    }

    public void setMother(FamilyMember mother) {
        this.mother = mother;
    }

    public FamilyMember getFather() {
        return father;
    }

    public void setFather(FamilyMember father) {
        this.father = father;
    }

    public FamilyMember getSpouse() { return spouse; }

    public void setSpouse(FamilyMember spouse) { this.spouse = spouse; }
}

