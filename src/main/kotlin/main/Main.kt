package main


import imagereader.ImageReader
import ocr.OCR


fun main() {

   val string = OCR.readFromImage(ImageReader.read())

   println(string)


}