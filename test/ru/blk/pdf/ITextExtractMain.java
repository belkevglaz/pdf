package ru.blk.pdf;


import com.itextpdf.text.pdf.parser.*;
import ru.blkvglz.pdf.PdfITextExtractor;
import ru.blkvglz.pdf.PdfUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;

/**
 * @author <a href="mailto:ivan.aksenov@ru.ibm.com">Aksenov Ivan</a>
 */
public class ITextExtractMain {

	public static String path = "D:\\projects\\java\\PdfTransformation\\docs\\pdfs\\";
	public static String pathImages = "D:\\projects\\java\\PdfTransformation\\docs\\images\\";
	public static String pdfName = "ipad_user_guide.pdf";

	public static void main(String[] args) throws IOException {
		FileInputStream stream = new FileInputStream(path + pdfName);
		PdfITextExtractor extractor = new PdfITextExtractor(stream);
		Map<Integer, PdfImageObject> images = extractor.extractAllPages();
		for (Integer imageRef : images.keySet()) {
			PdfUtils.dropImageToFile(pathImages + imageRef, images.get(imageRef));
		}
	}

}
