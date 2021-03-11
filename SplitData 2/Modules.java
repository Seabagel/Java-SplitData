import java.io.*;
import java.util.*;

import java.nio.file.Files;

public class Modules {
    public static void main(String[] args) throws IOException {
        // Scanner sc = new Scanner(System.in);
        // String input = sc.nextLine();
        // String output = sc.nextLine();
        // copyFiles(input, output);
        String sentence = "Somebody used too Few Little spoons";
        String input = "used,skidaddle;";
        String[] wordsArr = input.split(";");
        for (String x : wordsArr) {
            sentence = sentence.replaceAll(x.split(",")[0], x.split(",")[1]);
            System.out.println(sentence);
        }
    }

    // C:\Users\seabagell\Dropbox\Portfolio\Coding\Java\JWriter\dump\New Text
    // Document - Copy (2).txt
    public static void copyFiles(String source, String destination, boolean replaceBool, String replaceInput)
            throws IOException {
        // select folder
        File src = new File(source);
        File[] listFile = src.listFiles();

        // iterate the files in the folder
        for (File var : listFile) {
            String newSentence = var.getName();
            System.out.println(newSentence);

            if (replaceBool) {
                String sentence = newSentence + "";
                String input = replaceInput + ""; // "used,skidaddle;";
                String[] splitWhole = input.split(";");
                for (String x : splitWhole) {
                    String[] splitSentence = x.split(",");
                    newSentence = (sentence.replaceAll(splitSentence[0], splitSentence[1])).trim().replaceAll(" +", " ");
                    System.out.println(sentence);
                }
            }
            // if (replaceBool) {
            // // Main class code
            // String regex = replaceInput;
            // String[] wordsArr = result[1].split(";");
            // for (String x : wordsArr) {
            // newSentence = newSentence.replaceAll(x.split(",")[0], x.split(",")[1]);
            // }
            // System.out.println(sentence);
            // }

            // capitalize the sentence
            String[] words = var.toString().substring(var.toString().lastIndexOf("\\") + 1).split(" ");
            for (int i = 0; i < words.length; i++) {
                String word = Character.toUpperCase(words[i].charAt(0)) + words[i].substring(1);
                if (i == words.length) {
                    newSentence += word;
                } else {
                    newSentence += word + " ";
                }
            }

            // copy the file
            File tar = new File(destination + "\\" + var.getName());
            if (var.isFile()) {
                if (!tar.exists()) {
                    Files.copy(var.toPath(), tar.toPath());
                    tar.renameTo(new File(destination + "\\" + newSentence));
                } else {
                    System.out.println(tar.getName() + " already exists");
                    // StandardCopyOption.REPLACE_EXISTING
                }
            }
        }

    }
}