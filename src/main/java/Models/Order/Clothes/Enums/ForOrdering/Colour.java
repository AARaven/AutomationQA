package Models.Order.Clothes.Enums.ForOrdering;

public enum Colour {
    
    DEFAULT(),
    BEIGE( "Beige" ),
    BLACK( "Black" ),
    BLUE( "Blue" ),
    YELLOW( "Yellow" ),
    WHITE( "White" ),
    ORANGE( "Orange" ),
    GREEN( "Green" ),
    PINK( "Pink" ),
    ;
    
    private String description;
    
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription( String description ) {
        this.description = description;
    }
    
    Colour() { }
    
    Colour( String description ) {
        this.setDescription( description );
    }
}
