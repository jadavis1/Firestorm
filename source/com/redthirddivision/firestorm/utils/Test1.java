/*
 * Copyright 2016 Matthew Rogers.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.redthirddivision.firestorm.utils;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * <strong>Project:</strong> Firestorm
 * <strong>File:</strong> Test1.java
 *
 * @author Matthew Rogers
 */
public class Test1 implements Runnable {

    @Override
    public void run() {
        System.out.println("Test 1 started");
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            Logger.getLogger(Test1.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Test 1 ended");
    }

}
