package Models.Order.Clothes.Enums.ForUserChoice;

public enum Condition {
    
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
    
    Condition() { }
    
    Condition( String description ) {
        this.setDescription( description );
    }
    
}
