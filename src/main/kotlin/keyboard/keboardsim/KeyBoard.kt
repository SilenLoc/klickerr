package keyboard.keboardsim

import keyboard.keyboardtrans.toExtKey
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
            it.toExtKey(),
            it.isUpperCase()
        )
    }


}




