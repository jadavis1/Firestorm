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

import com.redthirddivision.firestorm.utils.Fonts;

/**
 * <strong>Project:</strong> Firestorm <br>
 * <strong>File:</strong> Menu.java
 *
 * @author <a href = "http://redthirddivision.com/team/blp"> Matthew Rogers</a>
 */
public class Menu {
    
    private final String[] options = { "Play", "Options", "Exit" }; // selection 0, 1, or 2
    private int currentSelection;
    
    
    public void render(Graphics g){
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, Firestorm.WIDTH, Firestorm.HEIGHT);
        Fonts.drawString(g, new Font("Arial", Font.BOLD, 72), Color.ORANGE, Firestorm.TITLE, 80);
        
        for(int i = 0; i < options.length; i++){
            if(i == currentSelection)
                Fonts.drawString(g, new Font("Arial", Font.BOLD, 48), Color.YELLOW, options[i], 200 + i * 80);
            else Fonts.drawString(g, new Font("Arial", Font.PLAIN, 32), Color.WHITE, options[i], 200 + i * 80);
        }
    }
    
}
