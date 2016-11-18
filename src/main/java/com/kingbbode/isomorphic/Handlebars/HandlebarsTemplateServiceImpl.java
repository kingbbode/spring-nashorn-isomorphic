package com.kingbbode.isomorphic.handlebars;

import jdk.nashorn.api.scripting.NashornScriptEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by YG on 2016-09-19.
 */
@Service
public class HandlebarsTemplateServiceImpl implements HandlebarsTemplateService {
    @Autowired
    NashornScriptEngine scriptEngine;

    @Override
    public String render(HandleBarsTemplate handleBarsTemplate) {
        try {
            return (String) scriptEngine.invokeFunction("renderModule", handleBarsTemplate.getName(), handleBarsTemplate.getModel());
        } catch (Exception e) {
            return "";
        }
    }
}
