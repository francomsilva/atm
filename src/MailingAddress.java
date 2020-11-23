public class MailingAddress {

    private String primaryStreet;
    private String secondaryStreet;
    private String state;
    private String city;
    private String postalCode;

    private final String[] statesName = {"Alaska", "Alabama", "Arkansas", "Arizona", "California", "Colorado", "Connecticut", "Delaware", "Florida", "Georgia", "Hawaii", "Iowa", "Idaho", "Illinois", "Indiana", "Kansas", "Kentucky", "Louisiana", "Massachusetts", "Maryland", "Maine", "Michigan", "Minnesota", "Missouri", "Mississippi", "Montana", "North Carolina", "North Dakota", "Nebraska", "New Hampshire", "New Jersey", "New Mexico", "Nevada", "New York", "Ohio", "Oklahoma", "Oregon", "Pennsylvania", "Puerto Rico", "Rhode Island", "South Carolina", "South Dakota", "Tennessee", "Texas", "Utah", "Virginia", "Virgin Islands", "Vermont", "Washington", "Wisconsin", "West Virginia", "Wyoming"};

    private final String[] statesAbbreviation = { "AK", "AL", "AR",  "AZ", "CA", "CO", "CT", "DE", "FL", "GA", "HI", "IA", "ID", "IL", "IN", "KS", "KY", "LA", "MA", "MD", "ME", "MI", "MN", "MO", "MS", "MT", "NC", "ND", "NE", "NH", "NJ", "NM", "NV", "NY", "OH", "OK", "OR", "PA", "PR", "RI", "SC", "SD", "TN", "TX", "UT", "VA", "VI", "VT", "WA", "WI", "WV", "WY"};

    public MailingAddress(String primaryStreet, String secondaryStreet, String city, String state, String postalCode) {
        this.primaryStreet = primaryStreet;
        this.secondaryStreet = secondaryStreet;
        this.state = state;
        this.city = city;
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public String getFormattedAddress() {
        return (this.primaryStreet + " " + city + ", " + state + " " + postalCode); //????????????????????
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getPrimaryStreet() {
        return primaryStreet;
    }

    public String getSecondaryStreet() {
        return secondaryStreet;
    }

    public String getState() {
        return state;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setPostalCode (String postalCode) {
        this.postalCode = postalCode;
    }

    public void setPrimaryStreet (String primaryStreet) {
        this.primaryStreet = primaryStreet;
    }

    public void setSecondaryStreet (String secondaryStreet) {
        this.secondaryStreet = secondaryStreet;
    }

    public void setState (String state) {
        this.state = state;
    }

    public String validateCity(String city) {
        if (this.city.length() > 0) {
            return city;
        } else {
            return null;
        }
    }

    public String validatePostalCode(String postalCode) {
        if (postalCode.length() == 5) {
            return postalCode;
        } else {
            return null;
        }
    }

    public String validateState(String state) {
        for(int x = 0; x < statesName.length; x++) {
            if(state.equals(statesAbbreviation[x]) || state.equals(statesName[x])) {
                return state;
            }
        }
        return null;
    }

    public String validateStreet(String street) {
        if (street != null && street.length() > 0) {
            return street;
        }
        return null;
    }

}