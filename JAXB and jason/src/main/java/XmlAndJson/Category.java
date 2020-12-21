import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import java.util.ArrayList;
import java.util.List;

@XmlType(propOrder = {"name", "products"}, name = "category")
@XmlRootElement
public class Category {

    @JsonProperty("CategoryName")
    private String name;

    @JsonProperty("CategoryProducts")
    private List<Product> products = new ArrayList<Product>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElementWrapper(name = "products")
    @XmlElement(name = "product")
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Category(String name) {
        this.name = name;
    }

    public Category() {
    }

    @Override
    public String toString() {

        return "Category name: " + name
                + "\nproducts:" + products.toString();
    }
}
