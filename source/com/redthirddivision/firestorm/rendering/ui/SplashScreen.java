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

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JWindow;
import javax.swing.SwingUtilities;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import com.redthirddivision.firestorm.rendering.textures.Texture;

/**
 * <strong>Project:</strong> Firestorm <br>
 * <strong>File:</strong> SplashScreen.java
 *
 * @author <a href = "http://bossletsplays.com"> Matthew Rogers</a>
 */
public class SplashScreen extends JWindow {

    private BorderLayout borderLayout;
    private JLabel       imgLabel;
    private JPanel       southPanel;
    private FlowLayout   southFlow;
    private JProgressBar progressBar;
    private ImageIcon    imgIcon;

    public SplashScreen(Texture texture) {
        this.imgIcon = new ImageIcon(texture.getImage());
        borderLayout = new BorderLayout();
        imgLabel = new JLabel();
        southPanel = new JPanel();
        southFlow = new FlowLayout();
        progressBar = new JProgressBar();
        progressBar.setStringPainted(true);
        try {
            init();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void init() throws Exception {
        imgLabel.setIcon(imgIcon);
        getContentPane().setLayout(borderLayout);
        southPanel.setLayout(southFlow);
        southPanel.setBackground(Color.BLACK);
        getContentPane().add(imgLabel, BorderLayout.CENTER);
        getContentPane().add(southPanel, BorderLayout.SOUTH);
        southPanel.add(progressBar, null);
        pack();
    }

    public void setMaxProgress(int maxProgress) {
        progressBar.setMaximum(maxProgress);
    }

    public void setProgress(int progress) {
        float percentage = ((float) progress / (float) progressBar.getMaximum()) * 100;

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                progressBar.setValue(progress);
                progressBar.setString("Loading: " + percentage + "%");
            }
        });
    }

}
