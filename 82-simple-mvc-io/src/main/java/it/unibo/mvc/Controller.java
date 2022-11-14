package it.unibo.mvc;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {

    private File currentFile;

    public Controller() {
        this.currentFile = new File(System.getProperty("user.home")
        + File.separator
        + "output.txt");
    }

    public void setCurrentFile(final File file) {
        this.currentFile = file;
    } 

    public File getCurrentFile() {
        return this.currentFile;
    }

    public String getCurrentFilePath() {
        return this.currentFile.getAbsolutePath();
    }

    public void writeInCurrentFile(String string) {
        try (final PrintStream ps = new PrintStream(currentFile, StandardCharsets.UTF_8)) {
            ps.print(string);
        } catch (final IOException e) {
            e.printStackTrace(); //NOPMD
        }
    }



}
