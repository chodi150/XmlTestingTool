package config;

/**
 * Created by Piotr on 19.05.2018.
 */
import org.springframework.context.ApplicationContext;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;

public class XMLConfig
{

    SpringResourceTemplateResolver xmlTemplateResolver(ApplicationContext appCtx) {
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();

        templateResolver.setApplicationContext(appCtx);
        templateResolver.setPrefix("classpath:/templates/");
        templateResolver.setSuffix(".xml");
        templateResolver.setTemplateMode("XML");
        templateResolver.setCharacterEncoding("UTF-8");
        templateResolver.setCacheable(false);

        return templateResolver;
    }

    public SpringTemplateEngine templateEngine(ApplicationContext appCtx) {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(xmlTemplateResolver(appCtx));
        return templateEngine;
    }

}