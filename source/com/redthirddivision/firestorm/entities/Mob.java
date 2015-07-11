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

import com.redthirddivision.firestorm.rendering.textures.Sprite;
import com.redthirddivision.firestorm.states.GameState;

/**
 * <strong>Project:</strong> Firestorm <br>
 * <strong>File:</strong> Mob.java
 *
 * @author <a href = "http://redthirddivision.com/team/blp"> Matthew Rogers</a>
 */
public abstract class Mob extends Entity {

    protected double dx, dy;

    public Mob(Sprite sprite, double x, double y, GameState state) {
        super(sprite, x, y, state);
    }

    @Override
    public void tick() {
        move();
    }

    public void move() {
        x += dx;
        y += dy;
    }

}
