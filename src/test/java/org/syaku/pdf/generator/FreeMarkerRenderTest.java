package org.syaku.pdf.generator;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import lombok.extern.log4j.Log4j2;

/**
 * @author Seok Kyun. Choi. 최석균 (Syaku)
 * @since 2019-01-12
 */
@Log4j2
public class FreeMarkerRenderTest {
    @Test
    public void test() {
        TemplateRender freeMarkerRender = new FreeMarkerRender();
        Map<String, Object> data = new HashMap<>();
        data.put("name", "syaku");
        byte[] bytes = freeMarkerRender.render("freemarker.ftl", data);
        assertEquals("나는 syaku 입니다.", new String(bytes));
    }
}
