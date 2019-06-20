package com.tutorial.hibernate.entitites;

import javax.persistence.*;

@Entity
@Table(name = "account")
public class AccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private int id;

    @Column(name = "account_number")
    private String accountNumber;

    @OneToOne(mappedBy="account")
    private EmployeeEntity employee;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public EmployeeEntity getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeEntity employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "AccountEntity{" +
                "id=" + id +
                ", accountNumber='" + accountNumber + '\'' +
                ", employee=" + employee +
                '}';
    }
}
