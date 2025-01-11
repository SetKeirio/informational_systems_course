package informational_systems.course.items;

import jakarta.persistence.*;

@Entity
@Table(name = "inventory")
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "item1")
    private Item item1;

    @ManyToOne
    @JoinColumn(name = "item2")
    private Item item2;

    @ManyToOne
    @JoinColumn(name = "item3")
    private Item item3;

    @ManyToOne
    @JoinColumn(name = "item4")
    private Item item4;

    @ManyToOne
    @JoinColumn(name = "item5")
    private Item item5;

    @ManyToOne
    @JoinColumn(name = "item6")
    private Item item6;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Item getItem1() {
        return item1;
    }

    public void setItem1(Item item1) {
        this.item1 = item1;
    }

    public Item getItem2() {
        return item2;
    }

    public void setItem2(Item item2) {
        this.item2 = item2;
    }

    public Item getItem3() {
        return item3;
    }

    public void setItem3(Item item3) {
        this.item3 = item3;
    }

    public Item getItem4() {
        return item4;
    }

    public void setItem4(Item item4) {
        this.item4 = item4;
    }

    public Item getItem5() {
        return item5;
    }

    public void setItem5(Item item5) {
        this.item5 = item5;
    }

    public Item getItem6() {
        return item6;
    }

    public void setItem6(Item item6) {
        this.item6 = item6;
    }
}
