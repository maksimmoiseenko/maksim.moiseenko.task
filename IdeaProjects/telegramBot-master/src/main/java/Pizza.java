import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class Pizza implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int ID;
    @Column
    private String title;
    @Column
    private String ingridients;
    @Column
    private double cost;
    @Column
    private int size;
    @OneToMany(fetch = FetchType.LAZY)
    private Set<Order_pizza> pizzasOrder;

    public Pizza(int ID, String title, String ingridients, double cost, int size, Set<Order_pizza> pizzasOrders) {
        this.ID = ID;
        this.title = title;
        this.ingridients = ingridients;
        this.cost = cost;
        this.size = size;
        pizzasOrder=pizzasOrders;
    }
    public Pizza() {}

    public int getID() {
        return ID;
    }




    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIngridients() {
        return ingridients;
    }

    public void setIngridients(String ingridients) {
        this.ingridients = ingridients;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
