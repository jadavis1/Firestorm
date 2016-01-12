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

import java.awt.Graphics2D;
import java.util.HashMap;
import java.util.Map;

import com.redthirddivision.firestorm.rendering.textures.Texture;

/**
 * <strong>Project:</strong> Game <br>
 * <strong>File:</strong> Tile.java
 *
 * @author <a href = "http://redthirddivision.com/team/blp"> Matthew Rogers</a>
 */
public class Tile {

    private static final Texture            terrain = new Texture("spritesheet_template");
    private static final Map<Integer, Tile> tileMap = new HashMap<Integer, Tile>();
    protected Texture                       sprite;
    protected boolean                       solid;
    protected int                           id;

    public static final Tile tile1 = new Tile(0xFFFFFFFF, new Texture(terrain, 1, 1, 64));
    public static final Tile tile2 = new Tile(0xFFFF0000, new Texture(terrain, 1, 2, 64));

    private Tile(int id, Texture sprite) {
        this.id = id;
        this.sprite = sprite;
        solid = true;
        tileMap.put(id, this);
    }

    public void render(Graphics2D g, int x, int y) {
        sprite.render(g, x, y);
    }

    public boolean isSolid() {
        return solid;
    }

    public static Tile getFromID(int id) {
        return tileMap.get(id);
    }

}
