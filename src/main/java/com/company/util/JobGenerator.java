package com.company.util;

import com.company.model.Job;

import java.util.Random;

public class JobGenerator {
    private static String [] jobTitles = new String[] {"Manager", "Seller", "Janitor", "Programmer", "Insider", "Where am I?"};
    private static String [] companies = new String[] {"Google", "Facebook", "Apple", "Microsoft", "Company_001"};

    public static Job getRandomJob() {
        return new Job(getRandomTitle(), getRandomCompany());
    }

    private static String getRandomTitle() {
        int i = new Random().nextInt(jobTitles.length - 1);
        return jobTitles[i];
    }

    private static String getRandomCompany() {
        int i = new Random().nextInt(companies.length - 1);
        return companies[i];
    }


}
