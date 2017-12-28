package com.company.util;

import com.company.model.Job;
import com.company.model.User;

import java.util.Random;

public class UserGenerator {

    private static String [] usernames = new String[] {"admin", "supervisor", "admin123", "employee", "hacker", "hacker_01"};

    private static String [] emailDomains = new String[] {"site.com", "hacker.co.il", "company.org", "google.com", "tel-ran.co.il"};

    private static String [] passwords = new String[] {"123456", "password", "enteryourpassword", "012345678", "iSrael"};

    public static User getRandomUser(Job job) {
        String username = getRandomUsername();
        String email = getRandomEmail(username);
        String password = getRandomPassword();

        return new User(username, password, email, job);
    }

    private static String getRandomUsername() {
        int usernamesIndex = new Random().nextInt(usernames.length - 1);
        return usernames[usernamesIndex];
    }

    private static String getRandomEmail(String username) {
        int emailDomainsIndex = new Random().nextInt(emailDomains.length - 1);

        return String.format("%s@%s", username, emailDomains[emailDomainsIndex]);
    }

    private static String getRandomPassword() {
        int passwordIndex = new Random().nextInt(passwords.length - 1);
        return passwords[passwordIndex];
    }
}
