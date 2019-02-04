package Models.Order.Clothes.Enums.ForOrdering;

public enum Compositions {
    
    DEFAULT(),
    COTTON( "Cotton" ),
    VISCOSE( "Viscose" ),
    POLYESTER( "Polyester" ),
    ;
    
    private String description;
    
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription( String description ) {
        this.description = description;
    }
    
    Compositions() { }
    
    Compositions( String description ) {
        this.setDescription( description );
    }
}
