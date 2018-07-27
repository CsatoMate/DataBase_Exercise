package hello.Models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Owners {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @NotNull
    @Column(unique = true)
    private Long id;

    @NotNull
    @Column(unique = true)
    @Size(max = 5)
    private String ownerID;

    private String name;

    public Owners() {
    }

    public Owners(@NotNull @Size(max = 5) String ownerID) {
        this.ownerID = ownerID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOwnerID() {
        return ownerID;
    }

    public void setOwnerID(String ownerID) {
        this.ownerID = ownerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Owners{" +
                "id=" + id +
                ", ownerID='" + ownerID + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
