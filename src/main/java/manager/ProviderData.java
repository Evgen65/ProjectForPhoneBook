package manager;

import models.Contact;
import models.User;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProviderData {
    @DataProvider
    public Iterator<Object[]> registrationDto() {
        List<Object[]> list = new ArrayList<>();
        int i = (int) ((System.currentTimeMillis() / 1000) % 3600);
        list.add(new Object[]{User.builder()
                .email("abc" + i + "@mail.org")
                .password("$1234Abcd")
                .build()});
        list.add(new Object[]{User.builder()
                .email("bca" + i + "@mail.org")
                .password("$1234Abcd")
                .build()});
        list.add(new Object[]{User.builder()
                .email("cba" + i + "@mail.org")
                .password("$1234Abcd")
                .build()});
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> myDPFile() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\repositoris\\ProjectForPhoneBook\\src\\test\\resources\\registrations.csv"));
        String line = bufferedReader.readLine();
        while (line != null) {
            String[] split = line.split(",");
            list.add(new Object[]{User.builder()
                    .email(split[0])
                    .password(split[1])
                    .build()});
            line = bufferedReader.readLine();
        }
        return list.iterator();
    }
}
