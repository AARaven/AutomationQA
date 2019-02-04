package Models.Order.Clothes.Enums.ForOrdering;

public enum Size {
    
    DEFAULT(),
    L( "Large" ),
    M( "Medium" ),
    S( "Small" ),
    ;
    
    String description;
    
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription( String description ) {
        this.description = description;
    }
    
    Size() { }
    
    Size( String description ) {
        this.setDescription( description );
    }
}
