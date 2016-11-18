package com.kingbbode.isomorphic.handlebars;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by YG on 2016-09-19.
 */
public class HandleBarsTemplate {

    public HandleBarsTemplate(String name) {
        this.name = name;
        this.model = new HashMap<>();
    }

    private String name;
    private Map<String, Object> model;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Object> getModel() {
        return model;
    }

    public void setModel(Map<String, Object> model) {
        this.model = model;
    }

    public HandleBarsTemplate put(String name, Object value) {
        this.model.put(name, value);
        return this;
    }
}
