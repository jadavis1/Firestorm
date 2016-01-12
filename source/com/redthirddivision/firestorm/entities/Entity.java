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

import java.awt.Graphics2D;

import com.redthirddivision.firestorm.rendering.textures.Texture;
import com.redthirddivision.firestorm.world.TileMap;

/**
 * <strong>Project:</strong> Game <br>
 * <strong>File:</strong> Entity.java
 *
 * @author <a href = "http://redthirddivision.com/team/blp"> Matthew Rogers</a>
 */
public abstract class Entity {

    protected double  x, y;
    protected Texture texture;
    protected TileMap tileMap;

    public Entity(Texture texture, double x, double y, TileMap tileMap) {
        this.texture = texture;
        this.x = x;
        this.y = y;
        this.tileMap = tileMap;
        tileMap.addEntity(this);
    }

    public abstract void tick();

    public void render(Graphics2D g, int offsetX, int offsetY) {
        texture.render(g, x + offsetX, y + offsetY);
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

}
