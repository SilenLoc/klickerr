package pipeline.ocr

import net.sourceforge.tess4j.Tesseract
import java.awt.image.BufferedImage


object OCR {


    fun readFromImage(bufferedImage: BufferedImage): String? {
        val api = Tesseract()
        api.setDatapath("src/main/resources/tess/")
        api.setLanguage("eng")

        return api.doOCR(bufferedImage)
    }

}