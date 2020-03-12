import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int ID;
    private double cost;
    private double time;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Client clientOrder;
    @OneToMany(mappedBy="order",cascade = CascadeType.ALL,orphanRemoval = true)
    Set<Order_pizza> pizzas;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private Address address;
    public Order(int ID, double cost, double time,Set<Order_pizza> set,Client client,Address address) {
        this.ID = ID;
        this.cost = cost;
        this.time = time;
        pizzas=set;
        this.address=address;
        clientOrder=client;
    }

    public Order(){}
    public int getID() {
        return ID;
    }


    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }
}
