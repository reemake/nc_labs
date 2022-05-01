package jaxb;

import contracts.Contract;
import repository.Repository;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;

public class JAXBConverter {
    private JAXBContext c;
    private Marshaller m;
    private Unmarshaller um;

    public JAXBConverter(Class clazz) throws JAXBException {
        this.c = JAXBContext.newInstance(clazz);
        this.m = this.c.createMarshaller();
        this.m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        this.um = this.c.createUnmarshaller();
    }

    public void marshall(Repository repo) throws JAXBException {
        m.marshal(repo, new File("src/main/resources/newRepo.xml"));
    }

    public Repository unmarshall(String filepath) throws JAXBException, FileNotFoundException {
        return (Repository) um.unmarshal(new FileReader(filepath));
    }
}
