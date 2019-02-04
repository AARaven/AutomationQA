package Models.Order.Clothes.Enums.ForUserChoice;

public enum Manufacturer {
    
    DEFAULT(),
    FASHION( "Fashion" ),
    ;
    
    private String description;
    
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription( String description ) {
        this.description = description;
    }
    
    Manufacturer() { }
    
    Manufacturer( String description ) {
        this.setDescription( description );
    }
}
