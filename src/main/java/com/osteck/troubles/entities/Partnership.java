package com.osteck.troubles.entities;

import org.neo4j.ogm.annotation.*;

import java.util.List;

@RelationshipEntity(type="IS_PARTNER")
public class Partnership {
    @Id @GeneratedValue
    private Long partnershipId;

    @Property
    private String notes;

    @StartNode
    private FamilyMember spouse1;

    @EndNode
    private FamilyMember spouse2;

    List<FamilyMember> children;
}
