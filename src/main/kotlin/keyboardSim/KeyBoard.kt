package keyboardSim

import java.awt.Robot
import java.awt.event.KeyEvent

object KeyBoard {

    private val robot = Robot()

    private fun click(int: Int, upperCase: Boolean) {
        if(upperCase){
            uppercaseClickKey(int)
        } else {
            clickKey(int)
        }
    }

    private fun uppercaseClickKey(int: Int){
        robot.keyPress(KeyEvent.VK_SHIFT)
        clickKey(int)
        robot.keyRelease(KeyEvent.VK_SHIFT)
    }

    private fun clickKey(int:Int){
        robot.keyPress(int)
        robot.keyRelease(int)
    }

    fun writeWord(word: String) = word.uppercase().forEach {
        click(
            it.toKey(),
            it.isUpperCase()
        )
    }


}

fun Char.toKey() = when {
    this == 'A' -> KeyEvent.VK_A
    this == 'B' -> KeyEvent.VK_B
    this == 'C' -> KeyEvent.VK_C
    this == 'D' -> KeyEvent.VK_D
    this == 'E' -> KeyEvent.VK_E
    this == 'F' -> KeyEvent.VK_F
    this == 'G' -> KeyEvent.VK_G
    this == 'B' -> KeyEvent.VK_B
    this == 'B' -> KeyEvent.VK_B
    this == 'B' -> KeyEvent.VK_B
    this == 'B' -> KeyEvent.VK_B
    this == 'B' -> KeyEvent.VK_B
    this == 'B' -> KeyEvent.VK_B
    this == 'B' -> KeyEvent.VK_B

    else -> KeyEvent.VK_0
}


