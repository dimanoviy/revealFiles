package edu.bean;

import javax.ejb.Stateless;
import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

@Stateless
public class UserFolder {

    public String revealFiles() throws IOException {
        StringBuilder filesString = new StringBuilder();
        browseDirectoryRecursively(System.getProperty("user.home"), 1, filesString);
        return filesString.toString();
    }

    private static StringBuilder browseDirectoryRecursively(String userHomeDir, int depth, StringBuilder filesString) throws IOException {
        DirectoryStream<Path> dirListing = java.nio.file.Files.newDirectoryStream(Paths.get(userHomeDir));

        for (Path entry : dirListing) {
            BasicFileAttributes fileAttributes = java.nio.file.Files.readAttributes(entry, BasicFileAttributes.class);
            if (fileAttributes.isDirectory() && (depth > 0)) {
                filesString.append("<ul>DIR: " + entry.toAbsolutePath());
                browseDirectoryRecursively(entry.toAbsolutePath().toString(), depth - 1, filesString);
                filesString.append("</ul>");
            } else {
                filesString.append("<ul>" + entry.toAbsolutePath() + "</ul>");
            }
        }

        return filesString;
    }
}