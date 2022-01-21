package main


import pipeline.cv.ImageService
import pipeline.cv.toGrayScale
import pipeline.imagereader.ImageReader
import pipeline.ocr.OCR


fun main() {

    val gray = ImageService.loadImage(ImageReader.testPath).toGrayScale()

    val readString = OCR.readFromImage(gray)

    println(readString)

    ImageService.saveImage(gray, "src/main/kotlin/pipeline/screen", "testOut")

}