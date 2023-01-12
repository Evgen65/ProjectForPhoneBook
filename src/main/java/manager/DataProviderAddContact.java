package manager;

import models.Contact;
import models.User;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviderAddContact {
    @DataProvider
    public Iterator<Object[]> addContactDto() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{Contact.builder()
                .name("Tirion")
                .lastName("Lanister")
                .phoneNumber("3254769801")
                .contEmail("tirion@mail.org")
                .address("King Street,Haifa,build 100")
                .description("my good friend")
                .build()});
        list.add(new Object[]{Contact.builder()
                .name("Jack")
                .lastName("Sparrow")
                .phoneNumber("8967452310")
                .contEmail("jonh@gmail.com")
                .address("Allenby,Haifa, 102")
                .description("my good friends sister")
                .build()});
        list.add(new Object[]{Contact.builder()
                .name("Jonh")
                .lastName("Silver")
                .phoneNumber("6578943021")
                .contEmail("js@mail.com")
                .address("Hertzl,Haifa,build 1")
                .description("my good friend")
                .build()});
        return list.iterator();
    }
    @DataProvider
    public Iterator<Object[]> myDPFile() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\repositoris\\ProjectForPhoneBook\\src\\test\\resources\\addContact.csv"));
        String line = bufferedReader.readLine();
        while (line != null) {
            String[] split = line.split(",");
            list.add(new Object[]{Contact.builder()
                    .name(split[0])
                    .lastName(split[1])
                    .phoneNumber(split[2])
                    .contEmail(split[3])
                    .address(split[4])
                    .description(split[5])
                    .build()});
            line = bufferedReader.readLine();
        }
        return list.iterator();
    }
}

