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
package com.redthirddivision.firestorm.rendering.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.redthirddivision.firestorm.Game;
import com.redthirddivision.firestorm.utils.Fonts;

/**
 * <strong>Project:</strong> Game <br>
 * <strong>File:</strong> Button.java
 *
 * @author <a href = "http://redthirddivision.com/team/blp"> Matthew Rogers</a>
 */
public class Button extends Rectangle {

    private Font    font, selectedFont;
    private Color   color, selectedColor;
    private boolean selected;
    private String  text;
    private int     textY;
    
    public Button(String text, int textY, Font font, Font selectedFont, Color color, Color selectedColor) {
        this.text = text;
        this.textY = textY;
        this.font = font;
        this.selectedFont = selectedFont;
        this.color = color;
        this.selectedColor = selectedColor;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
    
    
    public void render(Graphics g){
        if(selected)
            Fonts.drawString(g, selectedFont, selectedColor, text, textY);
        else
            Fonts.drawString(g, font, color, text, textY);
        
        FontMetrics fm = g.getFontMetrics();
        this.x = (Game.WIDTH - fm.stringWidth(text)) / 2;
        this.y = textY - fm.getHeight();
        this.width = fm.stringWidth(text);
        this.height = fm.getHeight();
        g.drawRect(x, y, width, height);
    }
    

}
