package Models.Order.Clothes.Enums.ForUserChoice;

public enum Availability {
    
    DEFAULT(),
    IN_STOCK( "In stock" ),
    ;
    
    private String description;
    
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription( String description ) {
        this.description = description;
    }
    
    Availability() { }
    
    Availability( String description ) {
        this.setDescription( description );
    }
}
