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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

import com.redthirddivision.firestorm.rendering.Texture;

/**
 * <strong>Project:</strong> Firestorm <br>
 * <strong>File:</strong> Firestorm.java
 *
 * @author <a href = "http://redthirddivision.com/team/blp"> Matthew Rogers</a>
 */
public class Firestorm extends Canvas implements Runnable {

    public static final String TITLE  = "Firestorm";
    public static final int    WIDTH  = 640;
    public static final int    HEIGHT = WIDTH / 4 * 3;

    private boolean            running;
    private Texture texture, t2, t3, t4;
    
    public Firestorm(){
        texture = new Texture("test");
        t2 = new Texture("test");
        t3 = new Texture("test");
        t4 = new Texture("test");
    }

    private void tick() {}

    private void render() {
        BufferStrategy bs = getBufferStrategy();
        if (bs == null) {
            createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();
        ////////////////////////////////////////////////

        g.setColor(Color.RED);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        texture.render(g, 100, 100);
        t2.render(g, 100, 150);
        t3.render(g, 150, 100);
        t4.render(g, 200, 200);
        ////////////////////////////////////////////////
        g.dispose();
        bs.show();
    }

    private void start() {
        if (running) return;
        running = true;
        new Thread(this, "FirestormMain-Thread").start();
    }

    private void stop() {
        if (!running) return;
        running = false;
    }

    @Override
    public void run() {
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

    public static void main(String[] args) {
        Firestorm game = new Firestorm();
        JFrame frame = new JFrame(TITLE);
        frame.add(game);
        frame.setSize(WIDTH, HEIGHT);
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
        frame.requestFocus();
        game.start();
    }

}
