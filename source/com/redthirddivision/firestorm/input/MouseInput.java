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

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * <strong>Project:</strong> Game <br>
 * <strong>File:</strong> MouseInput.java
 *
 * @author <a href = "http://redthirddivision.com/team/blp"> Matthew Rogers</a>
 */
public class MouseInput extends MouseAdapter {

    private static final int       NUM_BUTTONS = 10;

    private static final boolean[] buttons     = new boolean[NUM_BUTTONS];
    private static final boolean[] lastButtons = new boolean[NUM_BUTTONS];
    private static int             x           = -1, y = -1;
    public static int              lastX       = x, lastY = y;
    private static boolean         moving;

    @Override
    public void mousePressed(MouseEvent e) {
        buttons[e.getButton()] = true;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        buttons[e.getButton()] = false;
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        x = e.getX();
        y = e.getY();
        moving = true;
    }

    public static void update() {
        for (int i = 0; i < NUM_BUTTONS; i++)
            lastButtons[i] = buttons[i];

        //TODO: Do we need to check for how long the mouse has been still?
        //i.e, only set moving to false when the mouse has been static for 5 seconds (5x60 ticks)
        if (x == lastX && y == lastY) moving = false;
        lastX = x;
        lastY = y;
    }

    public static boolean isDown(int button) {
        return buttons[button];
    }

    public static boolean wasPressed(int button) {
        return isDown(button) && !lastButtons[button];
    }

    public static boolean wasReleased(int button) {
        return !isDown(button) && lastButtons[button];
    }

    public static int getX() {
        return x;
    }

    public static int getY() {
        return y;
    }

    public static boolean isMoving() {
        return moving;
    }

}
