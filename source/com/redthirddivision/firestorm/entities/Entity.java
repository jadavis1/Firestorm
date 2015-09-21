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
package com.redthirddivision.firestorm.entities;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import com.redthirddivision.firestorm.Game;
import com.redthirddivision.firestorm.rendering.textures.Texture;
import com.redthirddivision.firestorm.states.GameState;

/**
 * <strong>Project:</strong> Game <br>
 * <strong>File:</strong> Entity.java
 *
 * @author <a href = "http://redthirddivision.com/team/blp"> Matthew Rogers</a>
 */
public abstract class Entity {

    protected double    x, y;
    protected Texture    texture;
    protected GameState state;

    public Entity(Texture texture, double x, double y, GameState state) {
        this.texture = texture;
        this.x = x;
        this.y = y;
        this.state = state;
        state.addEntity(this);
    }

    public abstract void tick();

    public void render(Graphics2D g) {
        texture.render(g, x, y);
//        if (Game.DEBUG) {
//            g.setColor(Color.RED);
//            g.draw(getTop());
//            g.setColor(Color.BLUE);
//            g.draw(getBottom());
//            g.setColor(Color.MAGENTA);
//            g.draw(getLeft());
//            g.setColor(Color.ORANGE);
//            g.draw(getRight());
//        }
    }

    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, texture.getWidth(),
                texture.getHeight());
    }

    public Rectangle getTop() {
        return new Rectangle((int) x + 6, (int) y, texture.getWidth() - 6,
                4);
    }

    public Rectangle getBottom() {
        return new Rectangle((int) x + 6, (int) y + texture.getHeight() - 4,
                texture.getWidth() - 6,
                4);
    }

    public Rectangle getRight() {
        return new Rectangle((int) x + texture.getWidth() - 4, (int) y + 6, 4,
                texture.getHeight() - 6);
    }

    public Rectangle getLeft() {
        return new Rectangle((int) x, (int) y + 6, 4,
                texture.getHeight() - 6);
    }

}
