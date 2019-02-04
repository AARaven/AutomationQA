package Models.User.Enums;

public enum Genders {
    
    MALE( "male" ),
    FEMALE( "female" );
    
    private String description;
    
    Genders( String gender ) {
        this.description = gender;
    }
    
    public String getDescription() {
        return this.description;
    }
    
}
