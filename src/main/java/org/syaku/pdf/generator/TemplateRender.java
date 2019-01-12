package org.syaku.pdf.generator;

import java.util.Map;

/**
 * @author Seok Kyun. Choi. 최석균 (Syaku)
 * @since 2019-01-12
 */
public interface TemplateRender {
  byte[] render(String templatePath, Map<String, Object> data);
}
