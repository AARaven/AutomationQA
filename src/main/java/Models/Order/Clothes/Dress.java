package Models.Order.Clothes;

import Models.Order.Clothes.Enums.ForOrdering.Colours;
import Models.Order.Clothes.Enums.ForOrdering.Compositions;
import Models.Order.Clothes.Enums.ForOrdering.Properties;
import Models.Order.Clothes.Enums.ForOrdering.Sizes;

public class Dress extends Clothes {
    
    public Dress( String name ) {
        super( name );
    }
    
    public Dress( int quantity, String name, Colours colour,
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
        
        if ( !( object instanceof Dress ) ) {
            return false;
        }
        
        Dress dress = ( Dress ) object;
        return this.getQuantity() == dress.getQuantity()
               && this.getName().equals( dress.getName() )
               && this.getColour().equals( dress.getColour() )
               && this.getSize().equals( dress.getSize() )
               && this.getComposition().equals( dress.getComposition() )
               && this.getProperty().equals( dress.getProperty() );
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
