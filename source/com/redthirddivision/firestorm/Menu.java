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
package com.redthirddivision.firestorm;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

import com.sun.glass.events.KeyEvent;

import com.redthirddivision.firestorm.input.KeyInput;
import com.redthirddivision.firestorm.input.MouseInput;
import com.redthirddivision.firestorm.rendering.ui.Button;
import com.redthirddivision.firestorm.utils.Fonts;

/**
 * <strong>Project:</strong> Firestorm <br>
 * <strong>File:</strong> Menu.java
 *
 * @author <a href = "http://redthirddivision.com/team/blp"> Matthew Rogers</a>
 */
public class Menu {

    private final Button[] options;
    private int            currentSelection;

    public Menu() {
        options = new Button[3];
        options[0] = new Button("Play", 200 + 0 * 80,
                new Font("Arial", Font.PLAIN, 32), new Font("Arial", Font.BOLD, 48),
                Color.WHITE, Color.YELLOW);
        options[1] = new Button("Options", 200 + 1 * 80,
                new Font("Arial", Font.PLAIN, 32), new Font("Arial", Font.BOLD, 48),
                Color.WHITE, Color.YELLOW);
        options[2] = new Button("Exit", 200 + 2 * 80,
                new Font("Arial", Font.PLAIN, 32), new Font("Arial", Font.BOLD, 48),
                Color.WHITE, Color.YELLOW);
    }

    public void tick() {

        if(KeyInput.wasPressed(KeyEvent.VK_UP) || KeyInput.wasPressed(KeyEvent.VK_W)){
            currentSelection--;
            if(currentSelection < 0) currentSelection = options.length - 1;
        }
        
        if(KeyInput.wasPressed(KeyEvent.VK_DOWN) || KeyInput.wasPressed(KeyEvent.VK_S)){
            currentSelection++;
            if(currentSelection >= options.length) currentSelection = 0;
        }
        
        boolean clicked = false;
        for (int i = 0; i < options.length; i++) {
            if (options[i].intersects(new Rectangle(MouseInput.getX(), MouseInput.getY(), 1, 1))) {
                currentSelection = i;
                clicked = MouseInput.wasPressed(MouseEvent.BUTTON1);
            }
        }
        
        if (clicked || KeyInput.wasPressed(KeyEvent.VK_ENTER))
            select();
    }

    private void select() {
        switch (currentSelection) {
            case 0:
                System.out.println("Play");
                break;
            case 1:
                System.out.println("Options");
                break;
            case 2:
                System.out.println("Exit");
                Firestorm.INSTANCE.stop();
                break;
        }
    }

    public void render(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, Firestorm.WIDTH, Firestorm.HEIGHT);
        Fonts.drawString(g, new Font("Arial", Font.BOLD, 72), Color.ORANGE, Firestorm.TITLE, 80);

        for (int i = 0; i < options.length; i++) {
            if (i == currentSelection) options[i].setSelected(true);
            else options[i].setSelected(false);

            options[i].render(g);
        }
    }

}
