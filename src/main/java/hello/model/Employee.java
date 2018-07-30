package hello.model;

import javax.persistence.*;

@Entity
//@Table(name = "Employee")
public class Employee {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private String name;

    public Employee() {
    }

    public Employee(String name){
        this.name = name;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}