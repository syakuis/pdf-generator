package org.syaku.pdf.generator;

/**
 * @author Seok Kyun. Choi. 최석균 (Syaku)
 * @since 2019-01-12
 */
public class PdfGeneratorException extends Exception {
    public PdfGeneratorException() {
        super();
    }

    public PdfGeneratorException(String message) {
        super(message);
    }

    public PdfGeneratorException(String message, Throwable cause) {
        super(message, cause);
    }

    public PdfGeneratorException(Throwable cause) {
        super(cause);
    }

    protected PdfGeneratorException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
