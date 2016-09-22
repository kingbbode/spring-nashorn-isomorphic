package com.kingbbode.isomorphic.config;

import jdk.nashorn.api.scripting.NashornScriptEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.script.ScriptTemplateConfigurer;
import org.springframework.web.servlet.view.script.ScriptTemplateViewResolver;

import javax.script.ScriptEngineManager;
import java.io.InputStreamReader;

@Configuration
public class ApplicationConfig {
    @Autowired
    private ResourceLoader resourceLoader;
    
    @Bean
    public ViewResolver viewResolver() {
        ScriptTemplateViewResolver viewResolver = new ScriptTemplateViewResolver();
        viewResolver.setPrefix("/templates/");
        viewResolver.setSuffix(".hbs");
        return viewResolver;
    }

    @Bean
    public ScriptTemplateConfigurer configurer() {
        ScriptTemplateConfigurer configurer = new ScriptTemplateConfigurer();
        configurer.setEngine(scriptEngine());
        configurer.setRenderFunction("render");
        configurer.setSharedEngine(true);
        return configurer;
    }

    @Bean
    public NashornScriptEngine scriptEngine() {
        NashornScriptEngine nashornScriptEngine = (NashornScriptEngine) new ScriptEngineManager().getEngineByName("nashorn");
        try {
            nashornScriptEngine.eval(new InputStreamReader(resourceLoader.getResource("classpath:static/polyfill.js").getInputStream(), "UTF-8"));
            nashornScriptEngine.eval(new InputStreamReader(resourceLoader.getResource("classpath:META-INF/resources/webjars/handlebars/4.0.5/handlebars.min.js").getInputStream(), "UTF-8"));
            nashornScriptEngine.eval(new InputStreamReader(resourceLoader.getResource("classpath:static/js/templates.js").getInputStream(), "UTF-8"));
            nashornScriptEngine.eval(new InputStreamReader(resourceLoader.getResource("classpath:static/render.js").getInputStream(), "UTF-8"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return nashornScriptEngine;
    }
}
