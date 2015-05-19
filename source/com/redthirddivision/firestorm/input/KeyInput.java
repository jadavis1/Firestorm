/*   Copyright 2015 Matthew Rogers "BossLetsPlays"
*
*   Licensed under the Apache License, Version 2.0 (the "License");
*   you may not use this file except in compliance with the License.
*   You may obtain a copy of the License at
*
*     http://www.apache.org/licenses/LICENSE-2.0
*
*   Unless required by applicable law or agreed to in writing, software
*   distributed under the License is distributed on an "AS IS" BASIS,
*   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
*   See the License for the specific language governing permissions and
*   limitations under the License.
*/
package com.redthirddivision.firestorm.input;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * <strong>Project:</strong> Firestorm <br>
 * <strong>File:</strong> KeyInput.java
 *
 * @author <a href = "http://redthirddivision.com/team/blp"> Matthew Rogers</a>
 */
public class KeyInput extends KeyAdapter {

    private static final int       NUM_KEYS = 256;

    private static final boolean[] keys     = new boolean[NUM_KEYS];
    private static final boolean[] lastKeys = new boolean[NUM_KEYS];

    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;
    }

    public static void update() {
        for (int i = 0; i < NUM_KEYS; i++)
            lastKeys[i] = keys[i];
    }

    public static boolean isDown(int keyCode) {
        return keys[keyCode];
    }

    public static boolean wasPressed(int keyCode) {
        return isDown(keyCode) && !lastKeys[keyCode];
    }

    public static boolean wasReleased(int keyCode) {
        return !isDown(keyCode) && lastKeys[keyCode];
    }

}
