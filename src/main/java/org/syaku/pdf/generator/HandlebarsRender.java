package org.syaku.pdf.generator;

import java.io.IOException;
import java.util.Map;

import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.Template;
import com.github.jknack.handlebars.io.ClassPathTemplateLoader;
import com.github.jknack.handlebars.io.TemplateLoader;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

/**
 * @author Seok Kyun. Choi. 최석균 (Syaku)
 * @since 2019-01-12
 */
@Log4j2
public class HandlebarsRender implements TemplateRender {
    @Setter
    private Handlebars handlebars;
    @Setter
    private String charset = "UTF-8";
    @Setter
    private String prefix = "/templates";
    @Setter
    private String suffix = ".hbs";


    private void init() {
        // spring boot starter handlebars.java 사용할 경우 필요 없음.
        if (handlebars == null) {
            TemplateLoader loader = new ClassPathTemplateLoader();
            loader.setPrefix(this.prefix);
            loader.setSuffix(this.suffix);
            this.handlebars = new Handlebars(loader);
        }

    }

    @Override
    public byte[] render(String templatePath, Map<String, Object> data) {
        try {
            this.init();
            Template template = handlebars.compile(templatePath);
            String source = template.apply(data);
            return source.getBytes(charset);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }
}
