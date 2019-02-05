package Models.User.Enums;

public enum States {
    
    DEFAULT(),
    ALABAMA( "Alabama" ),
    ALASKA( "Alaska" ),
    ARIZONA( "Arizona" ),
    ARKANSAS( "Arkansas" ),
    CALIFORNIA( "California" ),
    COLORADO( "Colorado" ),
    CONNECTICUT( "Connecticut" ),
    DELAWARE( "Delaware" ),
    DISTRICT_OF_COLUMBIA( "District of Columbia" ),
    FLORIDA( "Florida" ),
    GEORGIA( "Georgia" ),
    HAWAII( "Hawaii" ),
    IDAHO( "Idaho" ),
    ILLINOIS( "Illinois" ),
    INDIANA( "Indiana" ),
    IOWA( "Iowa" ),
    KANSAS( "Kansas" ),
    KENTUCKY( "Kentucky" ),
    LOUISIANA( "Louisiana" ),
    MAINE( "Maine" ),
    MARYLAND( "Maryland" ),
    MASSACHUSETTS( "Massachusetts" ),
    MICHIGAN( "Michigan" ),
    MINNESOTA( "Minnesota" ),
    MISSISSIPPI( "Mississippi" ),
    MISSOURI( "Missouri" ),
    MONTANA( "Montana" ),
    NEBRASKA( "Nebraska" ),
    NEVADA( "Nevada" ),
    NEW_HAMPSHIRE( "New Hampshire" ),
    NEW_JERSEY( "New Jersey" ),
    NEW_MEXICO( "New Mexico" ),
    NEW_YORK( "New York" ),
    NORTH_CAROLINA( "North Carolina" ),
    NORTH_DAKOTA( "North Dakota" ),
    OHIO( "Ohio" ),
    OKLAHOMA( "Oklahoma" ),
    OREGON( "Oregon" ),
    PENNSYLVANIA( "Pennsylvania" ),
    PUERTO_RICO( "Puerto Rico" ),
    RHODE_ISLAND( "Rhode Island" ),
    SOUTH_CAROLINA( "South Carolina" ),
    SOUTH_DAKOTA( "South Dakota" ),
    TENNESSEE( "Tennessee" ),
    TEXAS( "Texas" ),
    US_VIRGIN_ISLANDS( "US Virgin Islands" ),
    UTAH( "Utah" ),
    VERMONT( "Vermont" ),
    VIRGINIA( "Virginia" ),
    WASHINGTON( "Washington" ),
    WEST_VIRGINIA( "West Virginia" ),
    WISCONSIN( "Wisconsin" ),
    WYOMING( "Wyoming" ),
    ;
    
    private int    number;
    private String description;
    
    private void setNumber( int number ) {
        this.number = number;
    }
    
    private void setDescription( String description ) {
        this.description = description;
    }
    
    States() {
        this.setNumber( ordinal() );
        this.setDescription( "" );
    }
    
    States( String description ) {
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

