package org.syaku.pdf.generator;

import java.io.*;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.core.io.ClassPathResource;
import org.w3c.dom.Document;
import org.xhtmlrenderer.pdf.ITextFontResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;
import org.xml.sax.SAXException;

import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.BaseFont;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

/**
 * @author Seok Kyun. Choi. 최석균 (Syaku)
 * @since 2019-01-12
 */
@Log4j2
public class PdfGenerator {
    @Setter
    private String charset = "UTF-8";
    @Setter
    private String[] fonts = new String[]{"/static/NanumGothic-Regular.ttf"};

    @Setter
    private TemplateRender templateRender;

    public void setFont(String... fonts) {
        this.fonts = fonts;
    }

    private DocumentBuilder getDocumentBuilder() throws ParserConfigurationException {
        DocumentBuilderFactory fac = DocumentBuilderFactory.newInstance();
        fac.setNamespaceAware(false);
        fac.setValidating(false);
        fac.setFeature("http://xml.org/sax/features/namespaces", false);
        fac.setFeature("http://xml.org/sax/features/validation", false);
        fac.setFeature("http://apache.org/xml/features/nonvalidating/load-dtd-grammar", false);
        fac.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
        return fac.newDocumentBuilder();
    }

    private void publish(byte[] source, OutputStream output) throws PdfGeneratorException{
        try {
            Document document = getDocumentBuilder().parse(new ByteArrayInputStream(source));

            ITextRenderer renderer = new ITextRenderer();
            ITextFontResolver fontResolver = renderer.getFontResolver();
            for (String font : fonts) {
                fontResolver.addFont(new ClassPathResource(font).getPath(), BaseFont.IDENTITY_H, true);
            }
            renderer.setDocument(document, null);
            renderer.layout();
            renderer.createPDF(output);
            renderer.finishPDF();
        } catch (DocumentException | ParserConfigurationException | SAXException | IOException e) {
            throw new PdfGeneratorException(e);
        }
    }

    /**
     * 특정 경로에 파일을 생성할때
     * @param templatePath 템플릿 경로
     * @param data 템플릿 바인딩 데이터
     * @param outputFile 생성할 pdf 파일 경로
     * @return 성공여부
     */
    public boolean file(String templatePath, Map<String,Object> data, String outputFile) {
        try (OutputStream output = new FileOutputStream(new File(outputFile))) {
            this.publish(this.templateRender.render(templatePath, data), output);
        } catch (IOException | PdfGeneratorException e) {
            log.error(e.getMessage(), e);
            return false;
        }

        return true;
    }

    /**
     * pdf 를 byte 로 얻기
     * @param templatePath 템플릿 경로
     * @param data 템플릿 바인딩 데이터
     * @return byte[] | null
     */
    public byte[] resource(String templatePath, Map<String,Object> data) {
        try (ByteArrayOutputStream output = new ByteArrayOutputStream()) {
            this.publish(this.templateRender.render(templatePath, data), output);
            return output.toByteArray();
        } catch (IOException | PdfGeneratorException e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }

}
