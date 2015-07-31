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
package com.redthirddivision.firestorm.states;

import java.awt.Graphics2D;
import java.util.HashMap;
import java.util.Map;

/**
 * <strong>Project:</strong> Game <br>
 * <strong>File:</strong> StateManager.java
 *
 * @author <a href = "http://redthirddivision.com/team/blp"> Matthew Rogers</a>
 */
public class StateManager {

    private Map<String, State> map;
    private State              currentState;

    public StateManager() {
        map = new HashMap<String, State>();
    }
    
    public void addState(State state){
        map.put(state.getName().toUpperCase(), state);
        state.init();
        if(currentState == null){
            state.enter();
            currentState = state;
        }
    }
    
    public void setState(String name){
        State state = map.get(name.toUpperCase());
        if(state == null){
            System.err.println("State <" + name + "> does not exist!");
            return;
        }
        currentState.exit();
        state.enter();
        currentState = state;
    }
    
    public void tick(){
        currentState.tick(this);
    }
    
    public void render(Graphics2D g){
        currentState.render(g);
    }

}
