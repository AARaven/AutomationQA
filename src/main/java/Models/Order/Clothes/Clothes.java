package Models.Order.Clothes;

import Models.Order.Clothes.Enums.ForOrdering.Colour;
import Models.Order.Clothes.Enums.ForOrdering.Composition;
import Models.Order.Clothes.Enums.ForOrdering.Property;
import Models.Order.Clothes.Enums.ForOrdering.Size;
import lombok.Data;

@Data
public abstract class Clothes {
    
    protected int         quantity;
    protected String      name;
    protected Colour      colour;
    protected Composition composition;
    protected Property    property;
    protected Size        size;
}
