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
import com.redthirddivision.firestorm.states.GameState;
import com.redthirddivision.firestorm.world.Tile;

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

    public Mob(Texture texture, double x, double y, GameState state, Animation anime) {
        super(texture, x, y, state);
        this.anime = anime;
        falling = true;
        gravity = 0.5;
        maxDY = 7;
    }

    @Override
    public void tick() {
        move();
        fall();
        if(dx != 0) moving = true;
        else moving = false;
        if(moving) anime.run();
    }
    
    @Override
    public void render(Graphics2D g) {
        if(!moving)
            super.render(g);
        else anime.render(g, x, y);
    }

    public void move() {
        if (!hasHorizontalCollision()) x += dx;
        if (!hasVerticalCollision()) y += dy;
    }

    protected boolean hasVerticalCollision() {
        for (int i = 0; i < state.getTiles().size(); i++) {
            Tile t = state.getTiles().get(i);
            if (getBottom().intersects(t.getTop()) && dy > 0) {
                canJump = true;
                falling = false;
                dy = 0;
                return true;
            } else falling = true;
            if (getBounds().intersects(t.getBottom()) && dy < 0) {
                dy = 0;
                return true;
            }
        }

        return false;
    }

    protected boolean hasHorizontalCollision() {
        for (int i = 0; i < state.getTiles().size(); i++) {
            Tile t = state.getTiles().get(i);
            if (getBounds().intersects(t.getRight()) && dx < 0) {
                dx = 0;
                return true;
            }
            if (getBounds().intersects(t.getLeft()) && dx > 0) {
                dx = 0;
                return true;
            }
        }

        return false;
    }

    protected void fall() {
        if (falling) {
            dy += gravity;
            if (dy > maxDY) dy = maxDY;
        }
    }

    protected void jump(double jumpHeight) {
        if (canJump) {
            dy -= jumpHeight;
            canJump = false;
        }
    }

}
