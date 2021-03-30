package com.tcodes;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileSearcher {

    private File entryDir;


    public FileSearcher()
    {
        // Setting entry point at Home directory of user
        entryDir = new File(System.getProperty("user.home"));
    }

    public void getFiles(String regex)
    {
        // Method to display all matched files

        ArrayList<Path> matchedFilePaths = getFileMatches(regex);

        for(Path filePath : matchedFilePaths){
            System.out.println(filePath.toAbsolutePath());
        }
    }

    private ArrayList<Path> getFileMatches(String regex)
    {
        // The central method to find all Files that match regex
        ArrayList<Path> allFilePaths = getAllFilePaths(entryDir.listFiles());
        ArrayList<Path> filteredPaths = new ArrayList<>();
        Pattern pattern = Pattern.compile(regex);

        filteredPaths = getPathMatches(allFilePaths, pattern);

        return filteredPaths;
    }

    private ArrayList<Path> getPathMatches(ArrayList<Path> allFilePaths, Pattern pattern)
    {
        ArrayList<Path> matchedPaths = new ArrayList<>();

        for(Path path : allFilePaths){
            Matcher matcher = pattern.matcher(path.getFileName().toString());
            if(matcher.find()){
                matchedPaths.add(path);
            }
        }

        return matchedPaths;
    }

    private ArrayList<Path> getAllFilePaths(File[] dirFiles)
    {
        // Gets all files in a given directory

        ArrayList<Path> paths = new ArrayList<>();

        try {
            for(File file : dirFiles){
                if(file.isFile()){
                    paths.add(file.toPath());
                }
            }
        }
        catch (NullPointerException nullPointerException){
            // Empty directory
            System.out.println("Home directory has no files");
        }

        return paths;
    }

}
