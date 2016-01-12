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

import java.awt.Graphics2D;

/**
 * <strong>Project:</strong> Firestorm <br>
 * <strong>File:</strong> ParallaxEngine.java
 *
 * @author <a href = "http://bossletsplays.com"> Matthew Rogers</a>
 */
public class ParallaxEngine {

    private ParallaxLayer[] layers;

    public ParallaxEngine(ParallaxLayer... layers) {
        this.layers = layers;
    }

    public void setRight() {
        for (int i = 0; i < layers.length; i++)
            layers[i].setRight();
    }

    public void setLeft() {
        for (int i = 0; i < layers.length; i++)
            layers[i].setLeft();
    }

    public void stop() {
        for (int i = 0; i < layers.length; i++)
            layers[i].stop();
    }

    public void move() {
        for (int i = 0; i < layers.length; i++)
            layers[i].move();
    }

    public void render(Graphics2D g) {
        for (int i = 0; i < layers.length; i++)
            layers[i].render(g);
    }

}
