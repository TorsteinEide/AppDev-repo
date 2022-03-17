import jdk.swing.interop.SwingInterOpUtils;

import java.lang.reflect.Array;
import java.util.List;

public class UsernameValidator {
    //fields
    private String userName;
    private String[] validChars = {"1","2"};
    //constructor
    /**
     * Constructor initializes an object of class UsernameValidator
     */
    public UsernameValidator(){
    }

    public void checkUserNames(int numberOfNames, String[] userNames)
    {
        for(int i=0;i<numberOfNames;i++){
            if(validateUsername(userNames[i])){
                System.out.println("valid");
            } else {
                System.out.println("invalid");
            }

        }
    }

    public boolean validateUsername(String inputName)
    {
        boolean valid =false;
        String firstChar = inputName.substring(0, 1);
        if(inputName.length()<8)
        {
        } else if(inputName.length()>30){
        } else {
            if(inputName.matches("[a-zA-Z0-9\\._\\-]{3,}"))
            {
                if (firstChar.matches("[a-zA-Z]+$")){
                    valid=true;
                } else {
                }
            } else {
            }
        }
        return valid;
    }

    public static void main(String[] args) {
        UsernameValidator u = new UsernameValidator();
        String[] usernames = {"Julia" ,"Samantha","Samantha_21" ,"1Samantha" ,"Samantha?10_2A" ,"JuliaZ007" ,"Julia@007", "_Julia007"};
        u.checkUserNames(8, usernames);
    }
}
