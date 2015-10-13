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

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;

import com.redthirddivision.firestorm.input.KeyInput;
import com.redthirddivision.firestorm.input.MouseInput;
import com.redthirddivision.firestorm.states.GameState;
import com.redthirddivision.firestorm.states.MenuState;
import com.redthirddivision.firestorm.states.StateManager;
import com.redthirddivision.firestorm.utils.Util;

/**
 * <strong>Project:</strong> Game <br>
 * <strong>File:</strong> Game.java
 *
 * @author <a href = "http://redthirddivision.com/team/blp"> Matthew Rogers</a>
 */
public class Game extends Canvas implements Runnable {

    public static final String  TITLE  = "Game";
    public static final int     WIDTH  = 640;
    public static final int     HEIGHT = WIDTH / 4 * 3;
    public static final boolean DEBUG  = false;

    private boolean running;

    private StateManager stateManager;

    public static Game INSTANCE;

    public Game() {
        addKeyListener(new KeyInput());
        MouseInput mi = new MouseInput();
        addMouseListener(mi);
        addMouseMotionListener(mi);
        stateManager = new StateManager();

        stateManager.addState(new MenuState());
        stateManager.addState(new GameState());

        INSTANCE = this;
    }

    private void tick() {
        stateManager.tick();
    }

    private void render() {
        BufferStrategy bs = getBufferStrategy();
        if (bs == null) {
            createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();
        Graphics2D g2d = (Graphics2D) g;
        // At least on Ubuntu we seem not to need to translate the canvas
        if(!Util.isUnix())
            g2d.translate(-6, -28);
        ////////////////////////////////////////////////

        g2d.setColor(Color.BLACK);
        g2d.fillRect(0, 0, WIDTH, HEIGHT);

        stateManager.render(g2d);

        ////////////////////////////////////////////////
        g.dispose();
        bs.show();
    }

    protected void start() {
        if (running) return;
        running = true;
        new Thread(this, "FirestormMain-Thread").start();
    }

    public void stop() {
        if (!running) return;
        running = false;
    }

    @Override
    public void run() {
        requestFocus();
        double target = 60.0;
        double nsPerTick = 1000000000.0 / target;
        long lastTime = System.nanoTime();
        long timer = System.currentTimeMillis();
        double unprocessed = 0.0;
        int fps = 0;
        int tps = 0;
        boolean canRender = false;

        while (running) {
            long now = System.nanoTime();
            unprocessed += (now - lastTime) / nsPerTick;
            lastTime = now;

            if (unprocessed >= 1.0) {
                tick();
                KeyInput.update();
                MouseInput.update();
                unprocessed--;
                tps++;
                canRender = true;
            } else canRender = false;

            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (canRender) {
                render();
                fps++;
            }

            if (System.currentTimeMillis() - 1000 > timer) {
                timer += 1000;
                System.out.printf("FPS: %d | TPS: %d\n", fps, tps);
                fps = 0;
                tps = 0;
            }

        }

        System.exit(0);
    }

}
