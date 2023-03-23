package idi.ntnu.restcalculator.model;

import jakarta.persistence.*;

@Entity
@Table(name = "expression")
public class Expression {
    @Id
    @Column(name = "expressionid", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "expression", nullable = false)
    private String calculation;

    @Column(name = "result", nullable = false)
    private double result;

    @Column(name = "userid")
    private int userid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCalculation() {
        return calculation;
    }

    public void setCalculation(String calculation) {
        this.calculation = calculation;
    }

    public double getAnswer() {
        return result;
    }

    public void setAnswer(double answer) {
        this.result = answer;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }
}
