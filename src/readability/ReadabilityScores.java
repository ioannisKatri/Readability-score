package readability;

public class ReadabilityScores {
    private final Double words;
    private final Double sentences;
    private final Double characters;
    private final Double syllables;
    private final Double polysyllables;

    public ReadabilityScores(final Double words, final Double sentences, final Double characters, final Double syllables, final Double polysyllables) {
        this.words = words;
        this.sentences = sentences;
        this.characters = characters;
        this.syllables = syllables;
        this.polysyllables = polysyllables;
    }

    public Double getWords() {
        return words;
    }

    public Double getSentences() {
        return sentences;
    }

    public Double getCharacters() {
        return characters;
    }

    public Double getSyllables() {
        return syllables;
    }

    public Double getPolysyllables() {
        return polysyllables;
    }
}