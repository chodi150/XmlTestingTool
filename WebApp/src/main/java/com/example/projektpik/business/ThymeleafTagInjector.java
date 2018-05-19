package com.example.projektpik.business;

import org.springframework.context.ApplicationContext;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * Created by Piotr on 17.04.2018.
 */
public class ThymeleafTagInjector
{
    ApplicationContext applicationContext;

    public ThymeleafTagInjector(ApplicationContext applicationContext){
        this.applicationContext = applicationContext;
    }
    public void injectTag(Map<String, Object> valuesMap, String templateFilename){

        SpringTemplateEngine engine = (SpringTemplateEngine) applicationContext.getBean("springTemplateEngine");
        Context context = new Context();
        valuesMap.forEach(context::setVariable);

        String content = engine.process(templateFilename, context);
        File file = new File( templateFilename + ".xml");
        FileWriter fw = null;
        try {
            fw = new FileWriter(file);
            fw.write(content);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
