package hello.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Motor {

    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @NotNull
    @Column(unique = true)
    private String motorID;

    @Size(max=100)
    private String motorName;

    private String brand;

    public Motor() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMotorID() {
        return motorID;
    }

    public void setMotorID(String motorID) {
        this.motorID = motorID;
    }

    public String getMotorName() {
        return motorName;
    }

    public void setMotorName(String motorName) {
        this.motorName = motorName;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Motor{" +
                "id=" + id +
                ", motorID='" + motorID + '\'' +
                ", motorName='" + motorName + '\'' +
                ", brand='" + brand + '\'' +
                '}';
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Owners_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Owner owner;
}
