package com.driver;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Gmail extends Email {

    class mail{

        public Date Date ;
        public String sender;
        public String message;

        public mail(java.util.Date Date, String sender, String message){

            this.Date=Date;
            this.sender=sender;
            this.message=message;

        }
    }




    int inboxCapacity=Integer.MAX_VALUE; //maximum number of mails inbox can store


    //Inbox: Stores mails. Each mail has date (Date), sender (String), message (String). It is guaranteed that message is distinct for all mails.
    ArrayList<mail> inbox = new ArrayList<>();
    //Trash: Stores mails. Each mail has date (Date), sender (String), message (String)
    ArrayList<mail> trash = new ArrayList<>();
    public Gmail(String emailId, int inboxCapacity) {
        super(emailId);

    }

    public void receiveMail(Date date, String sender, String message){
        // If the inbox is full, move the oldest mail in the inbox to trash and add the new mail to inbox.
        if(inbox.size()==inboxCapacity){
            mail deleted = inbox.get(0);
            trash.add(deleted);

            inbox.remove(deleted);


        }
        inbox.add(new mail(date,sender,message));
        // It is guaranteed that:
        // 1. Each mail in the inbox is distinct.
        // 2. The mails are received in non-decreasing order. This means that the date of a new mail is greater than equal to the dates of mails received already.

    }

    public void deleteMail(String message){

        for(int i=0;i<inbox.size();i++) {
            if (message.equals(inbox.get(i).message)){
                mail deleted = inbox.get(i);
                trash.add(deleted);
                inbox.remove(deleted);
                break;
            }
        }
        // Each message is distinct
        // If the given message is found in any mail in the inbox, move the mail to trash, else do nothing

    }

    public String findLatestMessage(){

        if(inbox.size()==0)
            return null;
        return inbox.get(inbox.size()-1).message;
        // If the inbox is empty, return null
        // Else, return the message of the latest mail present in the inbox

    }

    public String findOldestMessage(){
        // If the inbox is empty, return null
        if(inbox.size()==0)
            return null;
        return inbox.get(0).message;
        // Else, return the message of the oldest mail present in the inbox

    }

    public int findMailsBetweenDates(Date start, Date end){
        //find number of mails in the inbox which are received between given dates
        int count=0;
        for(int i=0;i<inbox.size();i++){
            mail msg = inbox.get(i);
            if(msg.Date.after(start) && msg.Date.before(end))
                count++;
            if(msg.Date.after(start)||msg.Date.before(end))
                count++;
        }
    return count;


        //It is guaranteed that start date <= end date

    }

    public int getInboxSize(){
        // Return number of mails in inbox
        return inbox.size();
    }

    public int getTrashSize(){
        // Return number of mails in Trash
        return trash.size();
    }

    public void emptyTrash(){
        // clear all mails in the trash
        trash.clear();
    }

    public int getInboxCapacity() {
        return this.inboxCapacity;
        // Return the maximum number of mails that can be stored in the inbox
    }
}

