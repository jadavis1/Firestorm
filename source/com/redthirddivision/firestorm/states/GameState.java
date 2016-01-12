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
package com.redthirddivision.firestorm.states;

import java.awt.Graphics2D;

import com.redthirddivision.firestorm.Game;
import com.redthirddivision.firestorm.world.TileMap;

/**
 * <strong>Project:</strong> Game <br>
 * <strong>File:</strong> GameState.java
 *
 * @author <a href = "http://redthirddivision.com/team/blp"> Matthew Rogers</a>
 */
public class GameState implements State {


    private TileMap tileMap;
    
    @Override
    public void init() {
        tileMap = new TileMap("level1");
    }

    @Override
    public void enter() {}

    @Override
    public void tick(StateManager stateManager) {
        tileMap.tick();
    }

    @Override
    public void render(Graphics2D g) {
        tileMap.render(g, Game.WIDTH, Game.HEIGHT);
    }

    @Override
    public void exit() {
    }

    @Override
    public String getName() {
        return "level1";
    }

}
