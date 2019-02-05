package Models.Order.Clothes;

import Models.Order.Clothes.Enums.ForOrdering.Colours;
import Models.Order.Clothes.Enums.ForOrdering.Compositions;
import Models.Order.Clothes.Enums.ForOrdering.Properties;
import Models.Order.Clothes.Enums.ForOrdering.Sizes;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

public abstract class Clothes {
    
    @Getter @Setter protected int          quantity;
    @Getter @Setter protected String       name;
    @Getter @Setter protected Sizes        size;
    @Getter @Setter protected Colours      colour;
    @Getter @Setter protected Compositions composition;
    @Getter @Setter protected Properties   property;
    
    
    private Clothes() { }
    
    protected Clothes( String name ) {
        this.setQuantity( 1 );
        this.setName( name );
        this.setSize( Sizes.DEFAULT );
        this.setColour( Colours.DEFAULT );
        this.setComposition( Compositions.DEFAULT );
        this.setProperty( Properties.DEFAULT );
    }
    
    protected Clothes( int quantity, String name, Colours colour,
                       Compositions composition, Properties property,
                       Sizes size ) {
        this.setQuantity( quantity );
        this.setName( name );
        this.setColour( colour );
        this.setComposition( composition );
        this.setProperty( property );
        this.setSize( size );
    }
    
    @Override
    public int hashCode() {
        return Objects.hash( this.getQuantity(),
                             this.getName(),
                             this.getColour(),
                             this.getComposition(),
                             this.getProperty(),
                             this.getSize() );
    }
    
    @Override
    public String toString() {
        return String.format( "%s" +
                              "\n{ " +
                              "\nquantity ='%d'" +
                              "\nname ='%s'" +
                              "\ncolour ='%s'" +
                              "\ncomposition ='%s'" +
                              "\nproperty ='%s'" +
                              "\nsize ='%s' " +
                              "\n}",
                              this.getClass().getSimpleName(),
                              this.getQuantity(),
                              this.getName(),
                              this.getColour(),
                              this.getComposition(),
                              this.getProperty(),
                              this.getSize() );
    }
}
