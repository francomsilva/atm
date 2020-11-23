public class AccountOwner {

    private String salutation;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private long phoneNumber;
    private MailingAddress mailingAddress;


    public AccountOwner(String salutation, String firstName, String lastName, String emailAddress, long phoneNumber, MailingAddress mailingAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salutation = salutation;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.mailingAddress = mailingAddress;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getFormattedPhoneNumber() {
        String phoneNum = String.valueOf(this.phoneNumber);
        return ("(" + phoneNum.substring(0,3) + ") " + phoneNum.substring(3,6) + "-" + phoneNum.substring(6));
    }

    public String getLastName() {
        return lastName;
    }

    public MailingAddress getMailingAddress() {
        return mailingAddress;
    }

    public String getName(int format) {
        if (format == 1) {
            return (firstName + " " + lastName);
        } else if (format == 2) {
            if (salutation == null || salutation.equals("")) {
                return (firstName + " " + lastName);
            } else {
                return (salutation + ". " + lastName);
            }
        } else if (format == 3) {
            return (lastName + ", " + firstName);
        } else {
            return (firstName + " " + lastName);
        }
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public String getSalutation() {
        return salutation;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setMailingAddress(MailingAddress mailingAddress) {
        this.mailingAddress = mailingAddress;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setSalutation(String salutation) {
        this.salutation = salutation;
    }

    public String validateEmailAddress(String emailAddress) {
        if (emailAddress.length() < 7 || emailAddress.length() > 254) return null;
        if (emailAddress.charAt(emailAddress.length() - 3) != '.') return null;
        if (emailAddress.charAt(0) == '@' || emailAddress.charAt(0) == '.' || emailAddress.charAt(emailAddress.length() - 1) == '@' || emailAddress.charAt(emailAddress.length() - 1) == '.') return null;
        int i = emailAddress.indexOf("@") - emailAddress.indexOf(".");
        if (i == -1 || i == 1) return null;
        return emailAddress;
    }

    public long validatePhoneNumber(long phoneNumber) {
        if (Long.toString(phoneNumber).length() != 10) {
            return 0L;
        } else {
            return phoneNumber;
        }
    }

    public String validateSalutation(String salutation) {
        if (salutation.length() > 0) return salutation;
        return null;
    }

}