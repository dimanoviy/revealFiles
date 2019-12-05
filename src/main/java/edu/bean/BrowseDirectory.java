package edu.bean;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

public class BrowseDirectory {
    public static StringBuilder browseDirectoryRecursively(String userHomeDir, int depth, StringBuilder filesString) throws IOException {
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
