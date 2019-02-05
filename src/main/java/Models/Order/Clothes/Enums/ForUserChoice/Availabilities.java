package Models.Order.Clothes.Enums.ForUserChoice;

public enum Availabilities {
    
    DEFAULT(),
    IN_STOCK( "In stock" ),
    ;
    
    private int    number;
    private String description;
    
    private void setNumber( int number ) {
        this.number = number;
    }
    
    private void setDescription( String description ) {
        this.description = description;
    }
    
    Availabilities() {
        this.setNumber( ordinal() );
        this.setDescription( "None" );
    }
    
    Availabilities( String description ) {
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
