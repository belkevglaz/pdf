package ru.blkvglz.pdf.listeners;

import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.parser.ImageRenderInfo;
import com.itextpdf.text.pdf.parser.PdfImageObject;
import com.itextpdf.text.pdf.parser.RenderListener;
import com.itextpdf.text.pdf.parser.TextRenderInfo;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.LogManager;
import java.util.logging.Logger;

/**
 * @author <a href="mailto:ivan.aksenov@ru.ibm.com">Aksenov Ivan</a>
 */
public class ImageRenderListener implements RenderListener {

	private final static Logger LOGGER = LogManager.getLogManager().getLogger(Logger.GLOBAL_LOGGER_NAME);

	private Map<Integer, PdfImageObject> bufferedImages = new HashMap<Integer, PdfImageObject>();

	public ImageRenderListener() {
	}

	public Map<Integer, PdfImageObject> getPdfImageObjects() {
		return bufferedImages;
	}

	@Override
	public void beginTextBlock() {
	}

	@Override
	public void renderText(TextRenderInfo renderInfo) {
	}

	@Override
	public void endTextBlock() {
	}

	public void renderImage(ImageRenderInfo renderInfo) {
		try {
			PdfImageObject image = renderInfo.getImage();
			PdfName filter = (PdfName) image.get(PdfName.FILTER);
			if (PdfName.DCTDECODE.equals(filter)) {
				bufferedImages.put(renderInfo.getRef().getNumber(), image);
				LOGGER.info("Listener [" + this.toString() + "]: Image #" + renderInfo.getRef().getNumber() + " extract to " + image.getImageBytesType().name());
			} else if (PdfName.JPXDECODE.equals(filter)) {
				bufferedImages.put(renderInfo.getRef().getNumber(), image);
				LOGGER.info("Listener [" + this.toString() + "]: Image #" + renderInfo.getRef().getNumber() + " extract to " + image.getImageBytesType().name());
			} else {
				bufferedImages.put(renderInfo.getRef().getNumber(), image);
				LOGGER.info("Listener [" + this.toString() + "]: Image #" + renderInfo.getRef().getNumber() + " extract to " + image.getImageBytesType().name());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
