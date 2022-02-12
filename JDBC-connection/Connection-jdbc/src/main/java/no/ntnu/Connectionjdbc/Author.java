package no.ntnu.Connectionjdbc;

/**
 * This class represents an author
 */
public class Author {
    //fields
    private int authorID;
    private String firstName;
    private String lastName;

    public Author(int authorID, String firstName, String lastName)
    {
        this.authorID=authorID;
        this.firstName=firstName;
        this.lastName=lastName;
    }

    public int getAuthorID() {
        return authorID;
    }

    public void setAuthorID(int authorID) {
        this.authorID = authorID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
