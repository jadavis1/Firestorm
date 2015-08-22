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
import java.util.ArrayList;

import com.redthirddivision.firestorm.entities.Entity;
import com.redthirddivision.firestorm.world.Tile;
import com.redthirddivision.firestorm.world.World;

/**
 * <strong>Project:</strong> Game <br>
 * <strong>File:</strong> GameState.java
 *
 * @author <a href = "http://redthirddivision.com/team/blp"> Matthew Rogers</a>
 */
public class GameState implements State {

    private ArrayList<Entity> entities;
    private ArrayList<Tile>   tiles;
    private World world;

    @Override
    public void init() {
        entities = new ArrayList<Entity>();
        tiles = new ArrayList<Tile>();
//        new Player(new Sprite("player"), 100, 100, this);
        world = new World("level1", this);
    }

    @Override
    public void enter() {}

    @Override
    public void tick(StateManager stateManager) {
        for (Entity e : entities)
            e.tick();
    }

    @Override
    public void render(Graphics2D g) {
        for (Entity e : entities)
            e.render(g);
        for (Tile t : tiles)
            t.render(g);
    }

    @Override
    public void exit() {
        entities.clear();
    }

    @Override
    public String getName() {
        return "level1";
    }

    public void addEntity(Entity entity) {
        entities.add(entity);
    }
    
    public void addTile(Tile tile){
        tiles.add(tile);
    }
    
    public ArrayList<Tile> getTiles() {
        return tiles;
    }

}
