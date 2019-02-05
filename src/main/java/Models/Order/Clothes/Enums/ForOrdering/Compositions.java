package Models.Order.Clothes.Enums.ForOrdering;

public enum Compositions {
    
    DEFAULT(),
    COTTON( "Cotton" ),
    POLYESTER( "Polyester" ),
    VISCOSE( "Viscose" ),
    ;
    
    private int    number;
    private String description;
    
    private void setNumber( int number ) {
        this.number = number;
    }
    
    private void setDescription( String description ) {
        this.description = description;
    }
    
    Compositions() {
        this.setNumber( ordinal() );
        this.setDescription( "None" );
    }
    
    Compositions( String description ) {
        this.setNumber( ordinal() );
        this.setDescription( description );
    }
    
    public int getNumber() {
        return this.number;
    }
    
    public String getDescription() {
        return this.description;
    }
}
