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

import javax.imageio.ImageIO;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * <strong>Project:</strong> Game <br>
 * <strong>File:</strong> Texture.java
 *
 * @author <a href = "http://redthirddivision.com/team/blp"> Matthew Rogers</a>
 */
public class Texture {

    private final static Map<String, BufferedImage> texMap = new HashMap<String, BufferedImage>();

    private BufferedImage image;
    private String        fileName;
    private int           width, height;

    public Texture(String fileName) {
        this.fileName = fileName;
        BufferedImage oldTexture = texMap.get(fileName);
        if (oldTexture != null)
            this.image = oldTexture;
        else {
            try {
                System.out.println("Loading texture: " + fileName);
                this.image = ImageIO.read(new File("./resources/textures/" + fileName + ".png"));
                texMap.put(fileName, image);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        this.width = image.getWidth();
        this.height = image.getHeight();
    }

    public Texture(Texture spriteSheet, int x, int y, int width, int height) {
        this.width = width;
        this.height = height;
        String key = spriteSheet.fileName + "_" + x + "_" + y;
        BufferedImage old = texMap.get(key);
        if (old != null) this.image = old;
        else this.image = spriteSheet.image.getSubimage(
                x * width - width,
                y * height - height,
                width, height);
    }

    public Texture(Texture spriteSheet, int x, int y, int size) {
        this(spriteSheet, x, y, size, size);
    }

    public void render(Graphics g, double x, double y) {
        g.drawImage(image, (int) x, (int) y, null);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

}
