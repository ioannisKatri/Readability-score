package readability.calculators;

import readability.ReadabilityScores;

import java.text.DecimalFormat;

public class FleschKincaidCalculator implements ReadabilityCalculator{

    private final ReadabilityScores readabilityScores;
    private final Double score;
    DecimalFormat df = new DecimalFormat("#.##");


    public FleschKincaidCalculator(ReadabilityScores readabilityScores) {
        this.readabilityScores = readabilityScores;
        this.score = calculateScore();
    }

    @Override
    public Double calculateScore() {
        if (score != null) {
            return Double.parseDouble(df.format(score));

        }

        return 0.39 * (this.readabilityScores.getWords() / this.readabilityScores.getSentences())
                + 11.8 * (this.readabilityScores.getSyllables() / this.readabilityScores.getWords())
                -15.59;
    }

    public Double getScore() {
        return score;
    }
}