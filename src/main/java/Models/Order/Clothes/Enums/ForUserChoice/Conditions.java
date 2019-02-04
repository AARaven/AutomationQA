package Models.Order.Clothes.Enums.ForUserChoice;

public enum Conditions {
    
    DEFAULT(),
    NEW( "New" ),
    ;
    
    private String description;
    
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription( String description ) {
        this.description = description;
    }
    
    Conditions() { }
    
    Conditions( String description ) {
        this.setDescription( description );
    }
    
}
