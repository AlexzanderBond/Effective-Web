package edu.cbet.http.html;

public class HTMLTagFactory {
    private static final HTMLTagFactory DEFAULT = new HTMLTagFactory();
    private HTMLTagFactory() {}

    public HTMLTagBuilder newTag(String tagName) {
        return new HTMLTagBuilder(tagName);
    }

    public static HTMLTagFactory getDefault() {
        return DEFAULT;
    }
}
