package Models.Order.Clothes.Enums.ForUserChoice;

public enum Style {
    
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
    
    Style() { }
    
    Style( String description ) {
        this.setDescription( description );
    }
}
