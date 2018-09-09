package com.osteck.troubles.entities;

import org.neo4j.ogm.annotation.*;

@RelationshipEntity(type="IS_OFFSPRING")
public class OffSpring {
    @Id @GeneratedValue
    private Long relationshipId;
    @Property
    private String notes;
    @StartNode
    private FamilyMember parent;
    @EndNode
    private FamilyMember child;
}
