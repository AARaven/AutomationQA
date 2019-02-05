package Models.Order.Clothes.Enums.ForOrdering;

public enum Sizes {
    
    DEFAULT(),
    S( "Small" ),
    M( "Medium" ),
    L( "Large" ),
    ;
    
    private int    number;
    private String description;
    
    private void setNumber( int number ) {
        this.number = number;
    }
    
    private void setDescription( String description ) {
        this.description = description;
    }
    
    Sizes() {
        this.setNumber( ordinal() );
        this.setDescription( "None" );
    }
    
    Sizes( String description ) {
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
