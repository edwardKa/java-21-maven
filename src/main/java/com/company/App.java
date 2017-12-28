package com.company;

import com.company.model.User;
import com.company.util.JobGenerator;
import com.company.util.UserGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class App {
    private static final String FILENAME = "C:\\Dev\\tel-ran\\maven-project\\users.txt";

    private static ObjectMapper objectMapper = new ObjectMapper();


    public static void main(String[] args) throws IOException {
        List<User> users = Arrays.asList(
                UserGenerator.getRandomUser(JobGenerator.getRandomJob()), //1
                UserGenerator.getRandomUser(JobGenerator.getRandomJob()), //2
                UserGenerator.getRandomUser(JobGenerator.getRandomJob()), //3
                UserGenerator.getRandomUser(JobGenerator.getRandomJob()), //4
                UserGenerator.getRandomUser(JobGenerator.getRandomJob()), //5
                UserGenerator.getRandomUser(JobGenerator.getRandomJob()), //6
                UserGenerator.getRandomUser(JobGenerator.getRandomJob()), //7
                UserGenerator.getRandomUser(JobGenerator.getRandomJob()), //8
                UserGenerator.getRandomUser(JobGenerator.getRandomJob()), //9
                UserGenerator.getRandomUser(JobGenerator.getRandomJob())  //10
        );


        String json = getJson(users);
        String prettyPrintJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(users);
        System.out.println("Will be written to file");
        System.out.println(json);
        System.out.println("----------------------------");
        System.out.println("Will be shown to the customer");
        System.out.println(prettyPrintJson);
        writeContent(json);

        //-----------------------Done writing-----------------------

//        System.out.println(getUsersFromFile(getFileContent()));
        System.out.println("-----------------------------");
        System.out.println();
        String fileContent = getFileContent();
        List<User> usersFromFile = getUsersFromFile(fileContent);
        usersFromFile.forEach(user -> System.out.println(String.format("Username: %s | Password: %s | Works at: %s | Position: %s",
                user.getUsername(),
                user.getPassword(),
                user.getJob().getCompany(),
                user.getJob().getTitle())));


    }



    private static String getFileContent() throws IOException {
        List<String> strings = FileUtils.readLines(new File(FILENAME));
        StringBuilder builder = new StringBuilder();
        strings.forEach(builder::append);

        return builder.toString();
    }

    private static List<User> getUsersFromFile(String jsonContent) throws IOException {
        //*****ATTENTION HERE*****
        //************************
        //************************
        //************************
        //************************
        //************************
        //Create a new instance of new TypeReference<List<User>>(){ }

        return objectMapper.readValue(jsonContent, new TypeReference<List<User>>(){});
    }

    private static String getJson(List<User> myUsers) throws JsonProcessingException {
        return objectMapper.writeValueAsString(myUsers);
    }

    private static void writeContent(String json) throws IOException {

        FileUtils.write(new File(FILENAME), json);
    }
}



