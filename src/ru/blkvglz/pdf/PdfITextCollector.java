package ru.blkvglz.pdf;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfWriter;

import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.util.Map;
import java.util.logging.LogManager;
import java.util.logging.Logger;

/**
 * @author <a href="mailto:ivan.aksenov@ru.ibm.com">Aksenov Ivan</a>
 */
public class PdfITextCollector {

	private final static Logger LOGGER = LogManager.getLogManager().getLogger(Logger.GLOBAL_LOGGER_NAME);

	private Map<String, BufferedImage> images;

	public PdfITextCollector(byte[] imageBytes) throws IOException, DocumentException {
		this.images = images;

		Document pdfDocument = new Document();
		OutputStream fileStream = new FileOutputStream("generated.pdf");
		PdfWriter writer = PdfWriter.getInstance(pdfDocument, fileStream);
		Image image = Image.getInstance(imageBytes);


		pdfDocument.add(image);

	}



	public void collect() {
//		PdfDocument

	}
}
