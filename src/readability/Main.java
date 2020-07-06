package readability;

import readability.parsers.Parser;
import readability.parsers.TextParser;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        boolean isArgsProvided = args[0] == null;
        String path = isArgsProvided ? args[0] : "./in.txt";

        File file = new File(path);
        Scanner sc = new Scanner(file);
        StringBuilder sb = new StringBuilder();

        while (sc.hasNextLine()) {
            sb.append(sc.nextLine());
        }

//        https://regex101.com/r/BAeN1A/1/
        Parser<ReadabilityScores> parser = new TextParser(sb.toString());
        ReadabilityDashboard dashboard = new ReadabilityDashboard(parser);
        dashboard.showDashboard();
    }
}