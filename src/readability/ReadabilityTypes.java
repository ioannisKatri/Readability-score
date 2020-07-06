package readability;

public enum ReadabilityTypes {
    ARI("ARI", "Automated Readability Index"),
    FK("FK", "Flesch–Kincaid readability tests"),
    SMOG("SMOG", "Simple Measure of Gobbledygook"),
    CL("CL", "Coleman–Liau index"),
    ALL("ALL", "All the readabilities");

    final String name;
    final String description;

    ReadabilityTypes(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public static ReadabilityTypes findType(String type) {

        for (ReadabilityTypes readabilityTypes: values()) {
            if (readabilityTypes.name.equals(type.toUpperCase())) {
                return readabilityTypes;
            }
        }
        return ReadabilityTypes.ALL;
    }
}