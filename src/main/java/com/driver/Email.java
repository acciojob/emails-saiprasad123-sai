package com.driver;

public class Email {

    private String emailId;
    private String password;

    public Email(String emailId){
        this.emailId = emailId;
        this.password = "Accio@123";
    }

    public  String getEmailId() {
        return emailId;
    }

    public String getPassword() {
        return password;
    }

    public void changePassword(String oldPassword, String newPassword){
        //Change password only if the oldPassword is equal to current password and the new password meets all of the following:
        boolean isValid = true;

        if(newPassword.length()<8) isValid=false;

        boolean upper=false,lower=false;
        int count=0;

        for(int i=0;i<newPassword.length();i++){
            if(Character.isUpperCase(newPassword.charAt(i))){
                count++;
                upper=true;
            }
            if(Character.isLowerCase(newPassword.charAt(i))) {
                count++;
                lower = true;
            }
        }

        if(oldPassword.equals(this.password) && lower && count<newPassword.length()){
            this.password=newPassword;
        }

        // 1. It contains at least 8 characters
        // 2. It contains at least one uppercase letter
        // 3. It contains at least one lowercase letter
        // 4. It contains at least one digit
        // 5. It contains at least one special character. Any character apart from alphabets and digits is a special character
    }
}
