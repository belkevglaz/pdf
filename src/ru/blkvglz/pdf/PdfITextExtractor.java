package ru.blkvglz.pdf;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfImageObject;
import com.itextpdf.text.pdf.parser.PdfReaderContentParser;
import ru.blkvglz.pdf.listeners.ImageRenderListener;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.logging.LogManager;
import java.util.logging.Logger;

/**
 * @author <a href="mailto:ivan.aksenov@ru.ibm.com">Aksenov Ivan</a>
 */
public class PdfITextExtractor {

	private final static Logger LOGGER = LogManager.getLogManager().getLogger(Logger.GLOBAL_LOGGER_NAME);

	private ImageRenderListener listener;
	private PdfReaderContentParser parser;
	private Integer pageCount = 0;

	private void init(PdfReader reader) {
		parser = new PdfReaderContentParser(reader);
		listener = new ImageRenderListener();
		this.pageCount = reader.getNumberOfPages();
	}

	public PdfITextExtractor(InputStream pdfStream) {
		try {
			PdfReader reader = new PdfReader(pdfStream);
			init(reader);
		} catch (IOException e) {
			LOGGER.severe("Does not work :(");
		}
	}

	public PdfITextExtractor(String filePath) {
		try {
			PdfReader reader = new PdfReader(filePath);
			init(reader);
		} catch (IOException e) {
			LOGGER.severe("Does not work :(");
		}
	}

	public Map<Integer, PdfImageObject> extractPage(Integer pageNumber) throws IOException {
		parser.processContent(pageNumber, listener);
		return listener.getPdfImageObjects();
	}


	public Map<Integer, PdfImageObject> extractPages(Integer[] pages) throws IOException {
		for (Integer page : pages)
			parser.processContent(page, listener);
		return listener.getPdfImageObjects();
	}


	public Map<Integer, PdfImageObject> extractAllPages() throws IOException {
		for (int i = 1; i <= pageCount; i++)
			parser.processContent(i, listener);
		return listener.getPdfImageObjects();
	}


}
