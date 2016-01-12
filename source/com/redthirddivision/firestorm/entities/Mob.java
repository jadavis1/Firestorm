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

import com.redthirddivision.firestorm.rendering.textures.Animation;
import com.redthirddivision.firestorm.rendering.textures.Texture;
import com.redthirddivision.firestorm.world.TileMap;

/**
 * <strong>Project:</strong> Game <br>
 * <strong>File:</strong> Mob.java
 *
 * @author <a href = "http://redthirddivision.com/team/blp"> Matthew Rogers</a>
 */
public abstract class Mob extends Entity {

    protected double    dx, dy;
    protected double    maxDY;
    protected double    gravity;
    protected boolean   falling;
    protected boolean   canJump;
    protected boolean   moving;
    protected Animation anime;

    public Mob(Texture texture, double x, double y, TileMap tileMap, Animation anime) {
        super(texture, x, y, tileMap);
        this.anime = anime;
        gravity = 0.5;
        maxDY = 7;
    }

    @Override
    public void tick() {
        if (dy > 0) falling = true;
        else if (dy < 0) falling = false;
        move();
        fall();
        if (dx != 0) moving = true;
        else moving = false;
        if (moving) anime.run();
    }

    @Override
    public void render(Graphics2D g, int offsetX, int offsetY) {
        if (!moving)
            super.render(g, offsetX, offsetY);
        else anime.render(g, x + offsetX, y + offsetY);
    }

    public void move() {
        boolean horiz = tileMap.getTileCollision(texture.getWidth(), x, y, x + dx, y, false);
        boolean vert = tileMap.getTileCollision(texture.getWidth(), x, y, x, y + dy, true);
        if (!horiz) x += dx;
        if (!vert) y += dy;
    }

    protected void fall() {
        dy += gravity;
        if (dy > maxDY) dy = maxDY;
    }

    protected void jump(double jumpHeight) {
        if (canJump) {
            dy -= jumpHeight;
            canJump = false;
        }
    }

    public void setCanJump(boolean canJump) {
        this.canJump = canJump;
    }

    public void setVelocityY(double dy) {
        this.dy = dy;
    }

    public boolean isFalling() {
        return falling;
    }

    public boolean isMovingLeft() {
        return dx < 0;
    }

    public boolean isMovingRight() {
        return dx > 0;
    }

    public boolean isMoving() {
        return moving;
    }

}
