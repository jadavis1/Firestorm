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

import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import com.redthirddivision.firestorm.entities.Player;
import com.redthirddivision.firestorm.states.GameState;

/**
 * <strong>Project:</strong> Firestorm <br>
 * <strong>File:</strong> World.java
 *
 * @author <a href = "http://redthirddivision.com/team/blp"> Matthew Rogers</a>
 */
public class World {
    
    private String name;
    private int width;
    private int height;
    private int[] pixels;
    
    public World(String name, GameState state){
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File("./resources/levels/" + name + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.name = name;
        this.width = image.getWidth();
        this.height = image.getHeight();
        pixels = image.getRGB(0, 0, width, height, null, 0, width);
        for(int y = 0; y < height; y++){
            for(int x = 0; x < width; x++){
                int id = pixels[x + y * width];
                if(id == 0xFF0000FF)
                    new Player(x * 32, y * 32, state);
                else if(Tile.getFromID(id) != null)
                    state.addTile(new Tile(id, x, y));
            }
        }
    }

}
