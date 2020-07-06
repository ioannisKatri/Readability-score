package readability.calculators;

import readability.ReadabilityScores;

import java.text.DecimalFormat;

public class ColemanLiauIndexCalculator implements ReadabilityCalculator{

    private final ReadabilityScores readabilityScores;
    private final Double score;
    DecimalFormat df = new DecimalFormat("#.##");


    public ColemanLiauIndexCalculator(ReadabilityScores readabilityScores) {
        this.readabilityScores = readabilityScores;
        this.score = calculateScore();
    }

    @Override
    public Double calculateScore() {
        if (this.score != null) {
            return Double.parseDouble(df.format(score));
        }

        double l = (readabilityScores.getCharacters() / readabilityScores.getWords()) * 100;
        double s = (readabilityScores.getSentences() / readabilityScores.getWords()) * 100;
        return 0.0588 * l - 0.296 * s - 15.8;
    }
}