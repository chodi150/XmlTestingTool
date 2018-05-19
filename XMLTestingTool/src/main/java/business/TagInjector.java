package business;

import exception.NotValidXmlException;
import org.springframework.context.ApplicationContext;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;
import util.DateUtil;
import util.ExceptionUtil;
import util.FileUtil;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * Created by Piotr on 19.05.2018.
 */
public class TagInjector {
    private SpringTemplateEngine templateEngine;

    public TagInjector(SpringTemplateEngine templateEngine){
        this.templateEngine = templateEngine;
    }
    public void produceXmlWithInjectedTags(Map<String, Object> valuesMap, String templateFilename) throws IOException {

        Context context = new Context(null, valuesMap);
        String content = templateEngine.process(templateFilename + ".xml", context);
        FileUtil.saveFile(templateFilename + DateUtil.getCurrentDate() + ".xml", content);

    }
}
