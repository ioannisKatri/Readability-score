package readability.calculators;

import readability.ReadabilityScores;

import java.text.DecimalFormat;

public class SimpleMeasureOfGobbledygookCalculator implements ReadabilityCalculator{

    private final ReadabilityScores readabilityScores;
    private final Double score;
    DecimalFormat df = new DecimalFormat("#.##");


    public SimpleMeasureOfGobbledygookCalculator(ReadabilityScores readabilityScores) {
        this.readabilityScores = readabilityScores;
        this.score = calculateScore();
    }

    @Override
    public Double calculateScore() {
        if (score != null) {
            return Double.parseDouble(df.format(score));
        }

        return 1.043 *
                Math.sqrt(readabilityScores.getPolysyllables() * 30D / readabilityScores.getSentences())
                + 3.1291;
    }

    public Double getScore() {
        return score;
    }
}