import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Address implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int ID;
    @Column
    private String street;
    @Column
    private String house;
    @Column
    private String flat;
    @OneToOne(mappedBy = "address")
    private Order order;
    public Address(int ID, String street, String house, String flat,Order order) {
        this.ID = ID;
        this.street = street;
        this.house = house;
        this.flat = flat;
        this.order=order;
    }
    public Address(){}

    public int getID() {
        return ID;
    }


    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getFlat() {
        return flat;
    }

    public void setFlat(String flat) {
        this.flat = flat;
    }
}
