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
package com.redthirddivision.firestorm.utils;

/**
 * <strong>Project:</strong> Firestorm <br>
 * <strong>File:</strong> Util.java
 *
 * @author <a href = "http://redthirddivision.com/team/blp"> Matthew Rogers</a>
 */
public class Util {

    private static final String OS = System.getProperty("os.name").toUpperCase();

    public static String getOSName() {
        return OS;
    }

    /**
     * @return True if the player is on a Windows PC.
     * @since 1.0.0
     */
    public static boolean isWindows() {
        return OS.contains("WIN");
    }

    /**
     * @return True if the player is on a Mac.
     * @since 1.0.0
     */
    public static boolean isMac() {
        return OS.contains("MAC");
    }

    /**
     * @return True if the player is on a Unix machine.
     * @since 1.0.0
     */
    public static boolean isUnix() {
        return OS.contains("NIX") || OS.contains("NUX") || OS.contains("AIX");
    }

}
