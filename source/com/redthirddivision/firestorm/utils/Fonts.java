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
package com.redthirddivision.firestorm.utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

import com.redthirddivision.firestorm.Firestorm;

/**
 * <strong>Project:</strong> Firestorm <br>
 * <strong>File:</strong> Fonts.java
 *
 * @author <a href = "http://redthirddivision.com/team/blp"> Matthew Rogers</a>
 */
public class Fonts {

    public static void drawString(Graphics g, Font f, Color c, String text, int x, int y) {
        g.setColor(c);
        g.setFont(f);
        g.drawString(text, x, y);
    }

    public static void drawString(Graphics g, Font f, Color c, String text) {
        FontMetrics fm = g.getFontMetrics(f);
        int x = (Firestorm.WIDTH - fm.stringWidth(text)) / 2; // Horizontal center
        int y = ((Firestorm.HEIGHT - fm.getHeight()) / 2) + fm.getAscent(); // Vertical center
        drawString(g, f, c, text, x, y);
    }

    public static void drawString(Graphics g, Font f, Color c, String text, double x) {
        FontMetrics fm = g.getFontMetrics(f);
        int y = ((Firestorm.HEIGHT - fm.getHeight()) / 2) + fm.getAscent(); // Vertical center
        drawString(g, f, c, text, (int) x, y);
    }

    public static void drawString(Graphics g, Font f, Color c, String text, int y) {
        FontMetrics fm = g.getFontMetrics(f);
        int x = (Firestorm.WIDTH - fm.stringWidth(text)) / 2; // Horizontal center
        drawString(g, f, c, text, x, y);
    }
    

}
