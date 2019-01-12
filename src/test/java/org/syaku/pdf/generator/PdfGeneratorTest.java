package org.syaku.pdf.generator;

import org.junit.Test;

/**
 * @author Seok Kyun. Choi. 최석균 (Syaku)
 * @since 2019-01-12
 */
public class PdfGeneratorTest {
    @Test
    public void freemarker() {
        PdfGenerator pdfGenerator = new PdfGenerator();
        pdfGenerator.setTemplateRender(new FreeMarkerRender());
        pdfGenerator.file("pdf.ftl", null, "/Users/syaku/develop/IntelliJ/freemarker.pdf");
    }

    @Test
    public void handlebars() {
        PdfGenerator pdfGenerator = new PdfGenerator();
        pdfGenerator.setTemplateRender(new HandlebarsRender());
        pdfGenerator.file("pdf", null, "/Users/syaku/develop/IntelliJ/handlebars.pdf");
    }
}
