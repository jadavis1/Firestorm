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
package com.redthirddivision.firestorm.rendering;

import java.awt.Graphics2D;

import com.redthirddivision.firestorm.Game;
import com.redthirddivision.firestorm.rendering.textures.Texture;

/**
 * <strong>Project:</strong> Firestorm <br>
 * <strong>File:</strong> ParallaxLayer.java
 *
 * @author <a href = "http://bossletsplays.com"> Matthew Rogers</a>
 */
public class ParallaxLayer {

    private Texture texture;
    private int     x, y;
    private int     width, height;
    private int     dx;
    private int     gap;
    private boolean left, right;

    public ParallaxLayer(Texture texture, int dx, int gap) {
        this.texture = texture;
        this.dx = dx;
        this.gap = gap;
        this.width = texture.getWidth();
        this.height = texture.getHeight();
        this.x = this.y = 0;
    }

    public ParallaxLayer(Texture texture, int dx) {
        this(texture, dx, 0);
    }

    public void setRight() {
        right = true;
        left = false;
    }

    public void setLeft() {
        right = false;
        left = true;
    }

    public void stop() {
        right = left = false;
    }

    public void move() {
        if (right) x = (x + dx) % (width + gap);
        else x = (x - dx) % width;
    }

    public void render(Graphics2D g) {
        if (x == 0)
            texture.render(g, 0, Game.WIDTH, 0, Game.WIDTH, y);
        else if (x > 0 && x < Game.WIDTH) {
            texture.render(g, x, Game.WIDTH, 0, Game.WIDTH - x, y);
            texture.render(g, 0, x, width - x, width, y);
        } else if (x >= Game.WIDTH)
            texture.render(g, 0, Game.WIDTH, width - x, width - x + Game.WIDTH, y);
        else if (x < 0 && x >= Game.WIDTH - width)
            texture.render(g, 0, Game.WIDTH, -x, Game.WIDTH - x, y);
        else if (x < Game.WIDTH - width) {
            texture.render(g, 0, width + x, -x, width, y);
            texture.render(g, gap + width + x, gap + Game.WIDTH, 0, Game.WIDTH - width - x, y);
        }
    }

}
