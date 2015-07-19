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
package com.redthirddivision.firestorm.rendering.textures;

/**
 * <strong>Project:</strong> Game <br>
 * <strong>File:</strong> SpriteSheet.java
 *
 * @author <a href = "http://redthirddivision.com/team/blp"> Matthew Rogers</a>
 */
public class SpriteSheet {
    
    private Texture texture;
    private int width, height;
    
    public SpriteSheet(Texture texture, int size){
        this(texture, size, size);
    }
    
    public SpriteSheet(Texture texture, int width, int height){
        this.texture = texture;
        this.width = width;
        this.height = height;
    }

    public Texture getTexture() {
        return texture;
    }
    
    public int getWidth() {
        return width;
    }
    
    public int getHeight() {
        return height;
    }
    
}
