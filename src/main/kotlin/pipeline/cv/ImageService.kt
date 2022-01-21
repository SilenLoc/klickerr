package pipeline.cv


import java.awt.Color
import java.awt.image.BufferedImage
import java.awt.image.BufferedImageOp
import java.awt.image.ConvolveOp
import java.awt.image.Kernel
import java.io.File
import javax.imageio.ImageIO


object ImageService {


    fun loadImage(path: String): BufferedImage = ImageIO.read(File(path))

    fun saveImage(image: BufferedImage, path: String, name: String) {
        ImageIO.write(image, "png", File("$path/$name.png"))
    }
}

fun BufferedImage.sharpen(): BufferedImage {
    val kernel = Kernel(3, 3, floatArrayOf(-1f, -1f, -1f, -1f, 9f, -1f, -1f, -1f, -1f))
    val op: BufferedImageOp = ConvolveOp(kernel)
    return op.filter(this, null)
}

fun BufferedImage.scale(times: Int): BufferedImage {
    val targetHeight = this.height * times
    val targetWidth = this.width * times

    val resizedImage = BufferedImage(targetWidth, targetHeight, 1)
    val graphics2D = resizedImage.createGraphics()
    graphics2D.drawImage(this, 0, 0, targetWidth, targetHeight, null)
    graphics2D.dispose()
    return resizedImage
}

fun BufferedImage.toGrayScale(): BufferedImage {

    (0 until this.height).forEach { y ->
        println("y: $y")
        (0 until this.width).forEach { x->
            println("x: $x")
            val rgb = this.getRGB(x,y)
            val a: Int = rgb shr 24 and 0xff
            val r: Int = rgb shr 16 and 0xff
            val g: Int = rgb shr 8 and 0xff
            val b: Int = rgb and 0xff

            val avg = (r+g+b)/3

            val newRgb = a shl 24 or (avg shl 16) or (avg shl 8) or avg
            this.setRGB(x, y, newRgb )
        }
    }
    return this
}


fun BufferedImage.removeNoise(): BufferedImage {

    (0 until this.height).forEach { y ->
        println("y: $y")
        (0 until this.width).forEach { x->
            println("x: $x")
            val rgb = this.getRGB(x,y)
            val a: Int = rgb shr 24 and 0xff
            val r: Int = rgb shr 16 and 0xff
            val g: Int = rgb shr 8 and 0xff
            val b: Int = rgb and 0xff

            val avg = (r+g+b)/10

            val newRgb = a shl 24 or (avg shl 16) or (avg shl 8) or avg
            this.setRGB(x, y, newRgb )
        }
    }
    return this
}