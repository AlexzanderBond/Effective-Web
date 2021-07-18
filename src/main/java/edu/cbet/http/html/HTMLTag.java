package edu.cbet.http.html;

import java.util.Map;

public class HTMLTag {
    private final String tagName;
    private final Map<String, String> attributes;

    HTMLTag(String tagName, Map<String, String> attributes) {
        this.tagName = tagName;
        this.attributes = attributes;
    }

    public boolean hasAttribute(String name) {
        return attributes.containsKey(name);
    }

    public String getAttributeValue(String name) {
        try {
            return attributes.get(name);
        } catch (Exception e) { //In the case the map throws an exception instead of returning a null value
            return null;
        }
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }

    public String getTagName() {
        return tagName;
    }


}
