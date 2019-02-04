package Models.Order.Clothes.Enums.ForUserChoice;

public enum Styles {
    
    DEFAULT(),
    CASUAL( "Casual" ),
    DRESSY( "Dressy" ),
    GIRLY( "Girly" ),
    ;
    
    private String description;
    
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription( String description ) {
        this.description = description;
    }
    
    Styles() { }
    
    Styles( String description ) {
        this.setDescription( description );
    }
}
