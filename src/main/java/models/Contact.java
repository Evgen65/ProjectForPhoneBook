
package models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString

public class Contact {
    String name;
    String lastName;
    String phoneNumber;
    String contEmail;
    String address;
    String description;

}