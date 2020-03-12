import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
public class Client implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int ID;
    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private String phone;

    @OneToMany(mappedBy = "clientFeedback",cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<Feedback> feedbacks;

    @OneToMany(mappedBy = "clientOrders",cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<Order> orders;

    public Client(int ID, String name, String surname, String phone,Set<Feedback> feedbacks,Set<Order>orders) {
        this.ID = ID;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.orders=orders;
        this.feedbacks=feedbacks;
    }
    public Client (){

    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
