import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="order_pizza")
public class Order_pizza implements Serializable {
    @Column(name="id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="order_id")
    private Order order;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="pizza_id")
    private Pizza pizza;
    @Column(name="amount")
    private int amount;

    public Order_pizza(int id, Order order, Pizza pizza, int amount) {
        this.id = id;
        this.order = order;
        this.pizza = pizza;
        this.amount = amount;
    }
    public Order_pizza(){}
}
