package com.tutorial.jpa.entitites;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@NamedQueries(
        {
                @NamedQuery(query = "Select u from UserEntity u where u.id = :id", name = "find UserEntity by id"),
                @NamedQuery(query = "Select u from UserEntity u where u.name = :name", name = "find UserEntity by name"),
                @NamedQuery(query = "UPDATE UserEntity u SET u.name=:name where u.id = :id", name = "update UserEntity by id")
        }
)
public class UserEntity implements Serializable {

    //Execute this on PostgreSQL database so that the id can be auto incremented
    //CREATE SEQUENCE users_id_seq;
    //ALTER SEQUENCE users_id_seq OWNED BY users.id;

    @Id
    @SequenceGenerator(name = "users_id_seq", sequenceName = "users_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "users_id_seq")
    @Column(name = "id", updatable = false, nullable = false)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "phone_number")
    private String phoneNumber;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
