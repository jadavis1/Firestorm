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
package com.redthirddivision.firestorm.rendering.ui;

import com.redthirddivision.firestorm.rendering.textures.Texture;

/**
 * <strong>Project:</strong> Firestorm <br>
 * <strong>File:</strong> SplashScreenDriver.java
 *
 * @author <a href = "http://bossletsplays.com"> Matthew Rogers</a>
 */
public class SplashScreenDriver {
    
    private SplashScreen screen;
    
    public SplashScreenDriver() {
        screen = new SplashScreen(new Texture("splash"));
        screen.setLocationRelativeTo(null);
        screen.setMaxProgress(1000);
        screen.setVisible(true);
        
//        for(int i = 0; i <= 1000; i++){
//            for(int j = 0; j <= 50000; j++){
//                String t = "ewf" + (i + j);
//            }
//            screen.setProgress(i);
//        }
        
        screen.setVisible(false);
    }

}
