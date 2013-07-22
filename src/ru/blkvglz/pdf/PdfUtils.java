package ru.blkvglz.pdf;

import com.itextpdf.text.pdf.parser.PdfImageObject;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author <a href="mailto:ivan.aksenov@ru.ibm.com">Aksenov Ivan</a>
 */
public final class PdfUtils {


	public static void dropImageToFile(String name, PdfImageObject image) throws IOException {
		String filename;
		FileOutputStream os;
		filename = String.format("%s.%s", name, "jpg");
		os = new FileOutputStream(filename);
		os.write(image.getImageAsBytes());
		os.flush();
		os.close();
	}
}
