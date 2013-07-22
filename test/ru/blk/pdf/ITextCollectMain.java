package ru.blk.pdf;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @author <a href="mailto:ivan.aksenov@ru.ibm.com">Aksenov Ivan</a>
 */
public class ITextCollectMain {

	public static void main(String[] args) throws DocumentException, IOException {
		FileInputStream imageStream = new FileInputStream("D:\\projects\\java\\PdfTransformation\\docs\\images\\2012.jpg");

		Document pdfDocument = new Document();
		OutputStream fileStream = new FileOutputStream("D:\\projects\\java\\PdfTransformation\\docs\\pdfs\\generated.pdf");
		PdfWriter writer = PdfWriter.getInstance(pdfDocument, fileStream);
		Image image = Image.getInstance("D:\\projects\\java\\PdfTransformation\\docs\\images\\2012.jpg");

		pdfDocument.open();
		pdfDocument.add(image);
		pdfDocument.add(image);
		pdfDocument.add(image);
		pdfDocument.add(image);
		pdfDocument.close();

	}
}
