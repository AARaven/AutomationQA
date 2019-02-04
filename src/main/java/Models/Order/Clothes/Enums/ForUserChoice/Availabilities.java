package Models.Order.Clothes.Enums.ForUserChoice;

public enum Availabilities {
    
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
    
    Availabilities() { }
    
    Availabilities( String description ) {
        this.setDescription( description );
    }
}
