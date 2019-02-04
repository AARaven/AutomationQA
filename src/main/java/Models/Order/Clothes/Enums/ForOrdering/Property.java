package Models.Order.Clothes.Enums.ForOrdering;

public enum Property {
    
    DEFAULT(),
    COLORFUL( "Colorful" ),
    MIDI( "Midi" ),
    MAXI( "Maxi" ),
    SHORT( "Short" ),
    ;
    
    private String description;
    
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription( String description ) {
        this.description = description;
    }
    
    Property() { }
    
    Property( String description ) {
        this.setDescription( description );
    }
}
