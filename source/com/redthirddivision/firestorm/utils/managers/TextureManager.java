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
package com.redthirddivision.firestorm.utils.managers;

import java.awt.image.BufferedImage;

/**
 * <strong>Project:</strong> Firestorm <br>
 * <strong>File:</strong> TextureManager.java
 *
 * @author <a href = "http://redthirddivision.com/team/blp"> Matthew Rogers</a>
 */
public class TextureManager extends ResourceManager {
    
    private BufferedImage image;
    
    public TextureManager(BufferedImage image){
        this.image = image;
    }
    
    public BufferedImage getImage() {
        return image;
    }

}
