package by.bsu.rent.util;

import by.bsu.rent.model.Language;

import java.util.HashMap;
import java.util.Map;

public class LinksByLanguage {
    private HashMap<Language,String> links;

    public LinksByLanguage(HashMap<Language, String> links) {
        this.links = links;
    }

    public static LinksByLanguage init () {
        HashMap<Language,String> allLinks = new HashMap<>();
        allLinks.put(new Language("Deutsch"),"https://www.economycarrentals.com/de-de");
        allLinks.put(new Language("English"),"https://www.economycarrentals.com/en-us");
        allLinks.put(new Language("Russian"),"https://www.economycarrentals.com/ru-ru");
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
