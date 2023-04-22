import javax.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private  String name;

    private int price;
    private int quantity;
    private int totalbill;

    @ManyToOne
    private Customer customer;


    public Product(int id, String name, int price, int quantity, int totalbill, Customer customer) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.totalbill = totalbill;
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", totalbill=" + totalbill +
                ", customer=" + customer +
                '}';
    }

    public Product()
    {
        super();
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getTotalbill() {
        return totalbill;
    }

    public void setTotalbill(int totalbill) {
        this.totalbill = totalbill;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
