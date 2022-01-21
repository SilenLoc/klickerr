package screenreader

import java.awt.Rectangle
import java.awt.Robot
import java.awt.Toolkit
import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO

object ScreenCatcher{

    private val robot = Robot()

    private val screen = Rectangle(Toolkit.getDefaultToolkit().screenSize)

    private var counter = 0


    fun createScreenShot(): BufferedImage {
        val image: BufferedImage = robot.createScreenCapture(screen)

        val file = File("src/main/resources/screens/screencap$counter.png")

        val status = ImageIO.write(image,"png", file)
        counter++

        println("captured: $status / path: ${file.absolutePath}")
        return image
    }



}