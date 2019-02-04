package Models.User.Enums;

public enum Months {
    
    DEFAULT( "-" ),
    JANUARY( "January" ),
    FEBRUARY( "February" ),
    MARCH( "March" ),
    APRIL( "April" ),
    MAY( "May" ),
    JUNE( "June" ),
    JULY( "July" ),
    AUGUST( "August" ),
    SEPTEMBER( "September" ),
    OCTOBER( "October" ),
    NOVEMBER( "November" ),
    DECEMBER( "December" ),
    ;
    
    private int    number;
    private String name;
    
    public String getName() {
        return this.name;
    }
    
    public int getNumber() {
        return this.number;
    }
    
    Months( String name ) {
        this.name = name;
        this.number = ordinal();
    }
}
