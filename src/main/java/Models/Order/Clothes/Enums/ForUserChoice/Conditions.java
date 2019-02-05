package Models.Order.Clothes.Enums.ForUserChoice;

public enum Conditions {
    
    DEFAULT(),
    NEW( "New" ),
    ;
    
    private int    number;
    private String description;
    
    private void setNumber( int number ) {
        this.number = number;
    }
    
    private void setDescription( String description ) {
        this.description = description;
    }
    
    Conditions() {
        this.setNumber( ordinal() );
        this.setDescription( "None" );
    }
    
    Conditions( String description ) {
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
