package keyboard.keyboardtrans

import java.awt.event.KeyEvent



fun Char.toExtKey() = KeyEvent.getExtendedKeyCodeForChar(this.code)

