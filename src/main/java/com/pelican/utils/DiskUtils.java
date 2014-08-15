package com.pelican.utils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by Artem
 * Date: 1/31/14 3:44 PM.
 */
public final class DiskUtils {

    public static String readString(String filename) throws IOException {
        return new String(Files.readAllBytes(Paths.get(filename)));
    }

    public static String readFile(File file) throws IOException {
        return new String(Files.readAllBytes(file.toPath()));
    }

}
