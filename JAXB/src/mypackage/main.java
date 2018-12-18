package mypackage;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class main {

    try {

        File file1 = new File("mypackage/corazonesSolitarios.xml");
        File file2 = new File("mypackage/masCorazones.xml");
        JAXBContext jaxbContext = JAXBContext.newInstance(PersonaType.class);

        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        PersonaType customer = (PersonaType) jaxbUnmarshaller.unmarshal(file1);
        System.out.println(customer);

    } catch (JAXBException e) {
        e.printStackTrace();
    }

}
