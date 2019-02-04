package Models.Order;

import Models.Order.Clothes.Clothes;
import lombok.Data;

import java.util.ArrayList;

@Data
public class Order {
    
    ArrayList < Clothes > clothes;
    
}
