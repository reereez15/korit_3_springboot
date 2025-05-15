package com.packt.cardatabase.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Ownerid;

    private String firstname, lastname;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner") // 컬럼명 owner를 참조하여 ownerid에 맞는 자동차 목록을 가져옴
    private List<Car> cars;

    // 기본 생성자 및 id를 제외한 RequriedArgsConstructor setter/ getter

    public Owner() {
    }

    public Owner(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public Long getOwnerid() {
        return Ownerid;
    }

    public void setOwnerid(Long ownerid) {
        Ownerid = ownerid;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
}