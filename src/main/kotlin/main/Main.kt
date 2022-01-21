package main


import pipeline.cv.ImageService
import pipeline.cv.scale
import pipeline.cv.sharpen
import pipeline.cv.toGrayScale
import pipeline.imagereader.ImageReader
import pipeline.ocr.OCR


fun main() {

    val gray = ImageService.loadImage(ImageReader.testPath).toGrayScale().sharpen().scale(10)

    val readString = OCR.readFromImage(gray)

    println(readString)

    ImageService.saveImage(gray, "src/main/resources/screens", "testOut")

}