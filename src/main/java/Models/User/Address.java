package Models.User;

import Models.User.Enums.States;
import lombok.Data;

@Data
public class Address {
    
    private String country;
    private States state;
    private String city;
    private String zipCode;
    private String address;
    private String addressSecondLine;
    private String company;
}
