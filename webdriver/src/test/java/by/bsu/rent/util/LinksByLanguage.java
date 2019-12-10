package by.bsu.rent.util;

import by.bsu.rent.model.Language;

import java.util.HashMap;
import java.util.Map;

public class LinksByLanguage {
    private static final String ENGLISH = "English";
    private static final String GERMAN = "Deutsch";
    private static final String RUSSIAN = "Russian";

    private static final String ENGLISH_LINK = "https://www.economycarrentals.com/en-us";
    private static final String GERMAN_LINK = "https://www.economycarrentals.com/de-de";
    private static final String RUSSIAN_LINK = "https://www.economycarrentals.com/ru-ru";

    private HashMap<Language,String> links;

    public LinksByLanguage(HashMap<Language, String> links) {
        this.links = links;
    }

    public static LinksByLanguage init () {
        HashMap<Language,String> allLinks = new HashMap<>();
        allLinks.put(new Language(GERMAN),GERMAN_LINK);
        allLinks.put(new Language(ENGLISH),ENGLISH_LINK);
        allLinks.put(new Language(RUSSIAN),RUSSIAN_LINK);
        return new LinksByLanguage(allLinks);
    }

    public String getLinkByLanguage(Language language) {
        return links.get(language);
    }

    public HashMap<Language, String> getLinks() {
        return links;
    }

    public void setLinks(HashMap<Language, String> links) {
        this.links = links;
    }
}
