package Models.Order.Clothes;

import Models.Order.Clothes.Enums.ForOrdering.Colours;
import Models.Order.Clothes.Enums.ForOrdering.Compositions;
import Models.Order.Clothes.Enums.ForOrdering.Properties;
import Models.Order.Clothes.Enums.ForOrdering.Sizes;

public class Blouse extends Clothes {
    
    public Blouse( String name ) {
        super( name );
    }
    
    public Blouse( int quantity, String name, Colours colour,
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
        
        if ( !( object instanceof Blouse ) ) {
            return false;
        }
        
        Blouse blouse = ( Blouse ) object;
        return this.getQuantity() == blouse.getQuantity()
               && this.getName().equals( blouse.getName() )
               && this.getColour().equals( blouse.getColour() )
               && this.getSize().equals( blouse.getSize() )
               && this.getComposition().equals( blouse.getComposition() )
               && this.getProperty().equals( blouse.getProperty() );
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
