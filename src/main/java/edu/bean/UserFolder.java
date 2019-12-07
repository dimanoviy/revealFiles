package edu.bean;

import javax.ejb.Stateless;
import java.io.*;

import static edu.bean.BrowseDirectory.browseDirectoryRecursively;

@Stateless
public class UserFolder {

    public String revealFiles() throws IOException {
        StringBuilder filesString = new StringBuilder();
        browseDirectoryRecursively(System.getProperty("user.dir"), 1, filesString);
        return filesString.toString();
    }
}