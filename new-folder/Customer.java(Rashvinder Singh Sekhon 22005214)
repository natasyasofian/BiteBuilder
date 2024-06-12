import java.util.ArrayList;
import java.util.List;

public class Customer {
    private Name name;
    private Address address;
    private List<BurgerOrder> burgerOrders;

    public Customer(Name name, Address address) {
        this.name = name;
        this.address = address;
        this.burgerOrders = new ArrayList<>();
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<BurgerOrder> getBurgerOrders() {
        return burgerOrders;
    }

    public void addBurgerOrder(BurgerOrder burgerOrder) {
        this.burgerOrders.add(burgerOrder);
    }

    @Override
    public String toString() {
        return "Customer: " + name + "\nAddress: " + address + "\nOrders: " + burgerOrders;
    }
}
 
