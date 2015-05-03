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
package com.redthirddivision.firestorm.rendering;

import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import com.redthirddivision.firestorm.utils.managers.TextureManager;

/**
 * <strong>Project:</strong> Firestorm <br>
 * <strong>File:</strong> Texture.java
 *
 * @author <a href = "http://redthirddivision.com/team/blp"> Matthew Rogers</a>
 */
public class Texture {

    private final static Map<String, TextureManager> texMap = new HashMap<String, TextureManager>();
    private TextureManager manager;
    private String fileName;
    
    
    public Texture(String fileName){
        this.fileName = fileName;
        TextureManager oldTexture = texMap.get(fileName);
        if(oldTexture != null){
            manager = oldTexture;
            manager.addReference();
        }
        else{
            try {
                System.out.println("Loading texture: " + fileName);
                manager = new TextureManager(ImageIO.read(new File("./resources/textures/" + fileName + ".png")));
                texMap.put(fileName, manager);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    @Override
    protected void finalize() throws Throwable {
        if(manager.removeReference() && !fileName.isEmpty()){
            texMap.remove(fileName);
            System.out.println("removing texture from memory: " + fileName);
        }
        super.finalize();
    }
    
    public void render(Graphics g, double x, double y) {
        g.drawImage(manager.getImage(), (int) x, (int) y, null);
    }

}
