package com.osteck.troubles.controllers;

import com.osteck.troubles.entities.FamilyMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class FamilyMemberController {

    private MembersRepository membersRepository;

    @Autowired
    FamilyMemberController(MembersRepository membersRepository) {
        this.membersRepository = membersRepository;
    }

    @GetMapping("/members")
    public List<FamilyMember> all() {
        return (List<FamilyMember>) this.membersRepository.findAll();
    }

    @GetMapping("/members/{lastName}")
    public List<FamilyMember> byLastName(@PathVariable String lastName) {
        return this.membersRepository.findByLastName(lastName);
    }

    @GetMapping("/members/{lastName}/{firstName}")
    public List<FamilyMember> byLastAndFirstName(@PathVariable String lastName, @PathVariable String firstName) {
        return this.membersRepository.findByFirstNameAndLastName(firstName, lastName);
    }

    @GetMapping("/member/{id}")
    public FamilyMember byId(@PathVariable long id) {
        return this.membersRepository.findById(id);
    }

    @GetMapping("/partnerships/{id1}/{id2}")
    public void createPartnership(@PathVariable long id1, @PathVariable long id2) {
        this.membersRepository.createPartnership(id1, id2);
    }

    /*
    //List<FamilyMember> findByLastName(@Param("lastName") String lastName);

    //List<FamilyMember> findByMaidenName(@Param("maidenName") String maidenName);

    //List<FamilyMember> findByFirstName(@Param("firstName") String firstName);

    //List<FamilyMember> findByFirstNameAndLastName(@Param("firstName") String firstName, @Param("lastName") String lastName);

    List<FamilyMember> findByDob(@Param("dob") Date dob);

    List<FamilyMember> findByMother(@Param("mother") FamilyMember mother);

    List<FamilyMember> findByFather(@Param("father") FamilyMember father);

    List<FamilyMember> findByMotherAndFather(@Param("mother") FamilyMember mother, @Param("father") FamilyMember father);

    ##
    Note: neo4j does -not- support bi-directional but this is actually not an issue as it traverses trees regardless of
    directions.
    ##

    @Query("MATCH (n), (m)\n" +
            "WHERE id(n) = {id1} AND id(m) = {id2}\n" +
            "CREATE (n)<-[:PARTNERS]-(m)")
    void createPartnership(@Param("id1") long id1, @Param("id2") long id2);

    @Query("MATCH (n), (m)\n" +
            "WHERE id(n) = id({member1}) AND id(m) = id({member2})\n" +
            "CREATE (n)<-[:PARTNERS]-(m)")
    void createPartnership(@Param("member1") FamilyMember member1, @Param("member2") FamilyMember member2);

    FamilyMember findById(@Param("id") long id);
     */
}
