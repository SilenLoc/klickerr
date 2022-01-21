package imagereader

import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO


object ImageReader {

    fun read(): BufferedImage {
        return ImageIO.read(File("src/main/resources/screens/test.jpg"))
    }

    fun readBW(): BufferedImage {

        val image = ImageIO.read(File("src/main/resources/screens/test.jpg"))

        val shellImage = BufferedImage(image.width, image.height, BufferedImage.TYPE_BYTE_BINARY)

        val graph = image.createGraphics()
        graph.drawImage(shellImage,0,0,null)
        return shellImage
    }
}