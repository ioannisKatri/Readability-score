package readability;

import readability.calculators.*;
import readability.parsers.Parser;

import java.util.Scanner;

import static readability.ReadabilityTypes.*;

public class ReadabilityDashboard {
    private final Parser<ReadabilityScores> parser;

    public ReadabilityDashboard(Parser<ReadabilityScores> parser) {
        this.parser = parser;
    }


    public void showDashboard() {
        Scanner sc = new Scanner(System.in);
        ReadabilityScores readabilityScores = this.parser.parse();
        textScore(readabilityScores);

        System.out.print("Enter the score you want to calculate (ARI, FK, SMOG, CL, all): ");

        String type = sc.nextLine();
        readabilityScores(readabilityScores, type);
    }

    private void textScore(ReadabilityScores readabilityScores) {
        System.out.println("words: " + Math.round(readabilityScores.getWords()));
        System.out.println("Sentences: " + Math.round(readabilityScores.getSentences()));
        System.out.println("Characters: " + Math.round(readabilityScores.getCharacters()));
        System.out.println("Syllables: " + Math.round(readabilityScores.getSyllables()));
        System.out.println("Polysyllables: " + Math.round(readabilityScores.getPolysyllables()));
    }

    private void readabilityScores(ReadabilityScores readabilityScores, String type) {
        ReadabilityCalculator rc;
        ReadabilityTypes findType = findType(type);
        boolean isAll = findType.name.equals("ALL");

        System.out.println();
        switch (findType) {
            case ALL:
            case ARI:
                rc = new AutomatedReadabilityIndexCalculator(readabilityScores);
                System.out.println(ARI.description + ": " + rc.calculateScore() + " (about " + ageScore(rc.calculateScore()) + " year olds).");
                if (!isAll) break;
            case FK:
                rc = new FleschKincaidCalculator(readabilityScores);
                System.out.println(FK.description + ": " + rc.calculateScore() + " (about " + ageScore(rc.calculateScore()) + " year olds).");
                if (!isAll) break;
            case SMOG:
                rc = new SimpleMeasureOfGobbledygookCalculator(readabilityScores);
                System.out.println(SMOG.description + ": " + rc.calculateScore() + " (about " + ageScore(rc.calculateScore()) + " year olds).");
                if (!isAll) break;
            case CL:
                rc = new ColemanLiauIndexCalculator(readabilityScores);
                System.out.println(CL.description + ": " + rc.calculateScore() + " (about " + ageScore(rc.calculateScore()) + " year olds).");
                if (!isAll) break;
        }
    }

    private String ageScore(Double ageScore) {
        long roundedScore = Math.round(ageScore);
        String age = "";
        if (roundedScore == 1) {
            age = "5-6";
        } else if (roundedScore == 2) {
            age = "6-7";
        } else if (roundedScore == 3) {
            age = "7-9";
        } else if (roundedScore == 4) {
            age = "9-10";
        } else if (roundedScore == 5) {
            age = "10-11";
        } else if (roundedScore == 6) {
            age = "11-12";
        } else if (roundedScore == 7) {
            age = "12-13";
        } else if (roundedScore == 8) {
            age = "13-14";
        } else if (roundedScore == 9) {
            age = "14-15";
        } else if (roundedScore == 10) {
            age = "15-16";
        } else if (roundedScore == 11) {
            age = "16-17";
        } else if (roundedScore == 12) {
            age = "17-18";
        } else if (roundedScore == 13) {
            age = "18-24";
        } else {
            age = "24+";
        }

        return age;
    }
}