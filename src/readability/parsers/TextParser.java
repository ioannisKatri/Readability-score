package readability.parsers;

import readability.ReadabilityScores;
import java.util.regex.Pattern;

public class TextParser implements Parser<ReadabilityScores> {

    private final String text;

    public TextParser(String text) {
        this.text = text;
    }

    @Override
    public ReadabilityScores parse() {
        findPolysyllables();
        return new ReadabilityScores(findWords(),
                findSentences(),
                findChars(),
                findSyllables(),
                findPolysyllables());
    }

    private double findSyllables() {
        Pattern pattern = Pattern.compile("([AIOUYaiouy]){1,3}|e\\w|E\\w|\\b\\w[^AIOUYEaiouye]*e\\b");
        return pattern.matcher(text).results().count();
    }

    public double findPolysyllables() {
        Pattern pattern = Pattern.compile("(\\b\\w*[AIOUYEaiouye]{1,2}\\w+)(\\w*[AIOUYEaiouye]{1,2}\\w+)(\\w*[AIOUYaiouy]{1,2}|e\\w+)(\\w*\\b)");
        return pattern.matcher(text).results().count();
    }

    private double findWords() {
        return this.text.split("\\s+").length;
    }

    private double findChars() {
        return this.text.replaceAll("\\s+", "").split("").length;
    }

    private double findSentences() {
        return this.text.split("(?:[!.?])").length;
    }
}