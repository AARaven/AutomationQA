package Models.Order.Clothes;

import Models.Order.Clothes.Enums.ForOrdering.Colours;
import Models.Order.Clothes.Enums.ForOrdering.Compositions;
import Models.Order.Clothes.Enums.ForOrdering.Properties;
import Models.Order.Clothes.Enums.ForOrdering.Sizes;

public class Tshirt extends Clothes {
    
    public Tshirt( String name ) {
        super( name );
    }
    
    public Tshirt( int quantity, String name, Colours colour,
                   Compositions composition,
                   Properties property,
                   Sizes size ) {
        super( quantity, name, colour, composition, property, size );
    }
    
    @Override
    public boolean equals( Object object ) {
        
        if ( this == object ) {
            return true;
        }
        
        if ( !( object instanceof Tshirt ) ) {
            return false;
        }
        
        Tshirt tshirt = ( Tshirt ) object;
        return this.getQuantity() == tshirt.getQuantity()
               && this.getName().equals( tshirt.getName() )
               && this.getColour().equals( tshirt.getColour() )
               && this.getSize().equals( tshirt.getSize() )
               && this.getComposition().equals( tshirt.getComposition() )
               && this.getProperty().equals( tshirt.getProperty() );
    }
    
    @Override
    public int hashCode() {
        return super.hashCode();
    }
    
    @Override
    public String toString() {
        return super.toString();
    }
}
