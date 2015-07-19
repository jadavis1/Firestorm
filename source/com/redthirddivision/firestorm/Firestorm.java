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
package com.redthirddivision.firestorm;

import javax.swing.JFrame;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * <strong>Project:</strong> Firestorm <br>
 * <strong>File:</strong> Firestorm.java
 *
 * @author <a href = "http://redthirddivision.com/team/blp"> Matthew Rogers</a>
 */
public class Firestorm {
    
    public static void main(String[] args) {
        Game game = new Game();
        JFrame frame = new JFrame(Game.TITLE);
        frame.add(game);
        frame.setSize(Game.WIDTH, Game.HEIGHT);
        frame.setResizable(false);
        frame.setFocusable(true);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.err.println("Exiting Game");
                game.stop();
            }
        });

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        game.start();
    }

}
