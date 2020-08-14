package com.study.server.basic.servlet;

import com.study.server.basic.Person;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.imageio.plugins.jpeg.JPEGImageReadParam;
import java.util.*;

/**
 * @author : Firewine
 * @version : 1.0
 * @Program Name: Mapping
 * @Create : 2020/1/12
 * @Description :
 */
public class Mapping {
    private String name;
    private Set<String> patterns;

    public Mapping() {
        patterns = new HashSet<String>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<String> getPatterns() {
        return patterns;
    }

    public void setPatterns(Set<String> patterns) {
        this.patterns = patterns;
    }

    public void addPatterns(String pattern) {
        this.patterns.add(pattern);
    }

    public void addPattern(String contents) {
        this.patterns.add(contents);
    }
}

