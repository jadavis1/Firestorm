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
package com.redthirddivision.firestorm.world;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import com.redthirddivision.firestorm.rendering.textures.Sprite;

/**
 * <strong>Project:</strong> Game <br>
 * <strong>File:</strong> Tile.java
 *
 * @author <a href = "http://redthirddivision.com/team/blp"> Matthew Rogers</a>
 */
public class Tile {

    protected float   x, y;
    protected Sprite  sprite;
    protected boolean solid;

    public Tile(float x, float y, Sprite sprite) {
        this.x = x;
        this.y = y;
        this.sprite = sprite;
        this.solid = true;
    }

    public void render(Graphics2D g) {
        sprite.render(g, x, y);
        g.setColor(Color.RED);
        g.draw(getTop());
        g.setColor(Color.BLUE);
        g.draw(getBottom());
        g.setColor(Color.MAGENTA);
        g.draw(getLeft());
        g.setColor(Color.ORANGE);
        g.draw(getRight());
    }

    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, sprite.getWidth(),
                sprite.getHeight());
    }

    public Rectangle getTop() {
        return new Rectangle((int) x + 6, (int) y, sprite.getWidth() - 6,
                4);
    }

    public Rectangle getBottom() {
        return new Rectangle((int) x + 6, (int)y + sprite.getHeight() - 4,
                sprite.getWidth() - 6,
                4);
    }

    public Rectangle getRight() {
        return new Rectangle((int) x + sprite.getWidth() - 4, (int) y + 6, 4,
                sprite.getHeight() - 6);
    }

    public Rectangle getLeft() {
        return new Rectangle((int) x, (int) y + 6, 4,
                sprite.getHeight() - 6);
    }

}
