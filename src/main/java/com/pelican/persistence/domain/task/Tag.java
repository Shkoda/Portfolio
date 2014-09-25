package com.pelican.persistence.domain.task;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.libs.com.zwitserloot.cmdreader.Description;

import javax.persistence.*;

/**
 * Created by Nightingale on 15.09.2014.
 */
@Setter
@NoArgsConstructor
@Entity
@Table(schema = "planner", name = "tags")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, unique = true)
    private int id;
    @Column(name = "owner_id")
    private int ownerId;
    @Column
    private String name;
    @Column
    private String description;

    public Tag(int ownerId, String name, String description) {
        this.ownerId = ownerId;
        this.name = name;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
