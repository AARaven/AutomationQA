package Models.User.Enums;

public enum Genders {
    
    DEFAULT(),
    MALE( "male" ),
    FEMALE( "female" );
    
    private int number;
    private String description;
    
    private void setNumber( int number ) {
        this.number = number;
    }
    
    private void setDescription( String description ) {
        this.description = description;
    }
    
    Genders() {
        this.setNumber( ordinal() );
        this.setDescription( "None" );
    }
    
    Genders( String description ) {
        this.setNumber( ordinal() );
        this.setDescription( description );
    }
    
    public int getNumber() {
        return this.number;
    }
    
    public String getDescription() {
        return this.description;
    }
}
