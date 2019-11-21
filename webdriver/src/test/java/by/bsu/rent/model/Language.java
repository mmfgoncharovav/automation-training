package by.bsu.rent.model;


import java.util.Objects;

public class Language {
    private String language;

    public Language(String language) {
        this.language = language;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Language language1 = (Language) o;
        return language.equals(language1.language);
    }

    @Override
    public int hashCode() {
        return Objects.hash(language);
    }

    @Override
    public String toString() {
        return "Language{" +
                "language='" + language + '\'' +
                '}';
    }
}
