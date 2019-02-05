package Models.Order;

import Models.Order.Clothes.Clothes;
import lombok.Data;

import java.util.ArrayList;

public class Order {
    
    private ArrayList < Clothes > clothes;
    
    public ArrayList < Clothes > getClothes() {
        return this.clothes;
    }
    
    public Order( ArrayList < Clothes > clothes ) {
        this.clothes = clothes;
    }
}
