package com.pelican.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "users.roles")
@Data
public class Role implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users.roles_role_id")
    @Column(name = "role_id")
    private Integer id;
    @Column(name = "role_name", nullable = false)
    private String roleName;
}
