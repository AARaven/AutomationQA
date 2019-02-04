package Models.Order.Clothes.Enums.ForOrdering;

public enum Properties {
    
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
    
    Properties() { }
    
    Properties( String description ) {
        this.setDescription( description );
    }
}
