import com.fasterxml.jackson.databind.ObjectMapper;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Run {
    public static void main(String[] args) throws IOException {
        Run example = new Run();

        Product p1 = new Product("Carrot", 10, 5);
        Product p2 = new Product("Chocolate", 100, 400);
        Product p3 = new Product("Milk", 50, 100);
        Product p4 = new Product("Onion", 15, 10);
        Product p5 = new Product("Biscuit", 200, 600);

        Category lactic = new Category("Lactic");
        Category sweet = new Category("Sweet");
        Category vegetables = new Category("Vegetables");

        lactic.getProducts().add(p3);
        sweet.getProducts().add(p2);
        sweet.getProducts().add(p5);
        vegetables.getProducts().add(p1);
        vegetables.getProducts().add(p4);

        System.out.println("\nTo XML:");
        File lacticXml = example.toXML(lactic);
        File sweetXml = example.toXML(sweet);
        File vegetablesXml = example.toXML(vegetables);

        System.out.println("\nFrom XML:");
        example.toObjectFromXml(lacticXml);
        example.toObjectFromXml(sweetXml);
        example.toObjectFromXml(vegetablesXml);

        System.out.println("\nTo JSON:");
        File lacticJSON = example.toJSON(lactic);
        File sweetJSON = example.toJSON(sweet);
        File vegetablesJson = example.toJSON(vegetables);

        System.out.println("\nFrom JSON:");
        example.toObjectFronJSON(lacticJSON);
        example.toObjectFronJSON(sweetJSON);
        example.toObjectFronJSON(vegetablesJson);

    }


    public File toXML(Category category) {
        File file = new File("src/main/java/files/xmlFiles/" + category.getName() + ".xml");
        try {
            JAXBContext context = JAXBContext.newInstance(Category.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(category, file);
            System.out.println("create XML file: " + file.getAbsolutePath());
        } catch (JAXBException e) {
            Logger.getLogger(Run.class.getName()).log(Level.SEVERE, "marshalling threw JAXBException", e);
        }
        return file;
    }

    public void toObjectFromXml(File file) {
        try {
            JAXBContext context = JAXBContext.newInstance(Category.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Category object = (Category) unmarshaller.unmarshal(file);
            System.out.println(object.toString());
        } catch (JAXBException e) {
            Logger.getLogger(Run.class.getName()).log(Level.SEVERE, "unmarshalling threw JAXBException", e);
        }
    }

    public File toJSON(Category category) {
        File file = new File("src/main/java/files/jsonFiles/" + category.getName() + ".json");
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(file, category);
            System.out.println("create JSON file: " + file.getAbsolutePath());
        } catch (IOException e) {
            Logger.getLogger(Run.class.getName()).log(Level.SEVERE, "IOException when convention to json", e);
        }
        return file;
    }

    public Category toObjectFronJSON(File file) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Category object = mapper.readValue(file, Category.class);
        System.out.println(object.toString());
        return object;
    }

}
