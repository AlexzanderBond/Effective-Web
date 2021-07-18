package edu.cbet.http.html;

import java.util.HashMap;
import java.util.Map;

public class HTMLTagBuilder {
    private String tagName;
    private final HashMap<String, String> attributes;

    HTMLTagBuilder(String tagName) {
        this.attributes = new HashMap<>();
        this.tagName = tagName;
    }

    public void name(String tagName) {
        this.tagName = tagName;
    }

    public void attribute(String name, String value) {
        this.attributes.put(name, value);
    }

    public HTMLTag build() {
        return new HTMLTag(tagName, Map.copyOf(attributes));
    }
}
