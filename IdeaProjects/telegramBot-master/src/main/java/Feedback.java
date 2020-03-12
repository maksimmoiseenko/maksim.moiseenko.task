import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Feedback implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int ID;
    @Column
    private int rating;
    @Column
    private int time_rating;
    @Column
    private String wishes;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Client clientFeedback;

    public Feedback(int ID, int rating, int time_rating, String wishes) {
        this.ID = ID;
        this.rating = rating;
        this.time_rating = time_rating;
        this.wishes = wishes;
    }

    public Feedback() { }

    public int getID() {
        return ID;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getTime_rating() {
        return time_rating;
    }

    public void setTime_rating(int time_rating) {
        this.time_rating = time_rating;
    }

    public String getWishes() {
        return wishes;
    }

    public void setWishes(String wishes) {
        this.wishes = wishes;
    }
}

