package readability.calculators;

import readability.ReadabilityScores;

import java.text.DecimalFormat;

public class AutomatedReadabilityIndexCalculator implements ReadabilityCalculator {

    private final ReadabilityScores readabilityScores;
    private final Double score;
    DecimalFormat df = new DecimalFormat("#.##");

    public AutomatedReadabilityIndexCalculator(ReadabilityScores readabilityScores) {
        this.readabilityScores = readabilityScores;
        this.score = calculateScore();
    }

    @Override
    public Double calculateScore() {
        if (score != null) {
            return Double.parseDouble(df.format(score));
        }

        return 4.71 * (readabilityScores.getCharacters() / readabilityScores.getWords()) + 0.5 * (readabilityScores.getWords() / readabilityScores.getSentences()) - 21.43;
    }

    public Double getScore() {
        return score;
    }
}