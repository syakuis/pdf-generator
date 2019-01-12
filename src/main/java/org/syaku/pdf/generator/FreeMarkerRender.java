package org.syaku.pdf.generator;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.TemplateException;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

/**
 * @author Seok Kyun. Choi. 최석균 (Syaku)
 * @since 2019-01-12
 */
@Log4j2
public class FreeMarkerRender implements TemplateRender {
    @Setter
    private Configuration configuration;

    @Setter
    private String charset = "UTF-8";

    private void init() {
        // spring boot starter freemarker 사용할 경우 필요 없음.
        if (this.configuration == null) {
            this.configuration = new Configuration(Configuration.VERSION_2_3_28);
            configuration.setDefaultEncoding(charset);
            configuration.setClassForTemplateLoading(getClass(), "/templates");
        }
    }


    @Override
    public byte[] render(String templatePath, Map<String, Object> data) {
        try (ByteArrayOutputStream output = new ByteArrayOutputStream();
             Writer write = new OutputStreamWriter(output, charset)) {
            this.init();
            configuration.getTemplate(templatePath).process(data, write);
            return output.toByteArray();
        } catch(TemplateException | IOException e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }
}
