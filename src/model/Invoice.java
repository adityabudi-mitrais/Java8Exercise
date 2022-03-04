package model;

public class Invoice {
    Integer id;
    Customer customer;
    String title;
    Integer amount;

    public Invoice(Integer id, Customer customer, String title, Integer amount) {
        this.id = id;
        this.customer = customer;
        this.title = title;
        this.amount = amount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "id=" + id +
                ", customer=" + customer +
                ", title='" + title + '\'' +
                ", amount=" + amount +
                '}';
    }
}
