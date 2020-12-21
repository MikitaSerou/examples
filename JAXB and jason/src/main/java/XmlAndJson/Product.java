import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlType;


@XmlType(propOrder = {"name", "price", "countOfcalories"}, name = "product")
public class Product {

    @JsonProperty("ProductName")
    private String name;

    @JsonProperty("ProductPrice")
    private int price;

    @JsonProperty("ProductCalories")
    private double countOfcalories;

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

    public double getCountOfcalories() {
        return countOfcalories;
    }

    public void setCountOfcalories(double countOfcalories) {
        this.countOfcalories = countOfcalories;
    }


    public Product(String name, int price, double countOfcalories) {
        this.name = name;
        this.price = price;
        this.countOfcalories = countOfcalories;

    }

    public Product() {
    }

    @Override
    public String toString() {
        return "\n" + name
                + "{price: " + price
                + ", calories: " +countOfcalories + "}";
    }
}
