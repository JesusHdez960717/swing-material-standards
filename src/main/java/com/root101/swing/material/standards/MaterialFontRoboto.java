/*
 * Copyright 2021 Root101 (jhernandezb96@gmail.com, +53-5-426-8660).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Or read it directly from LICENCE.txt file at the root of this project.
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.root101.swing.material.standards;

import java.awt.*;
import java.awt.font.TextAttribute;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * The MaterialFontRoboto font.
 *
 * @see <a
 * href="https://www.google.com/design/spec/resources/roboto-noto-fonts.html">MaterialFontRoboto
 * &amp; Noto fonts (Google design guidelines)</a>
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
public class MaterialFontRoboto {

    private static final Map<TextAttribute, Object> fontSettings = new HashMap<TextAttribute, Object>();
    public static final Font BLACK = loadFont("/fonts/Roboto-Black.ttf").deriveFont(Font.BOLD);
    public static final Font BLACK_ITALIC = loadFont("/fonts/Roboto-BlackItalic.ttf").deriveFont(Font.BOLD | Font.ITALIC);
    public static final Font BOLD = loadFont("/fonts/Roboto-Bold.ttf").deriveFont(Font.BOLD);
    public static final Font BOLD_ITALIC = loadFont("/fonts/Roboto-BoldItalic.ttf").deriveFont(Font.BOLD | Font.ITALIC);
    public static final Font ITALIC = loadFont("/fonts/Roboto-Italic.ttf").deriveFont(Font.ITALIC);
    public static final Font LIGHT = loadFont("/fonts/Roboto-Light.ttf").deriveFont(Font.PLAIN);
    public static final Font LIGHT_ITALIC = loadFont("/fonts/Roboto-LightItalic.ttf").deriveFont(Font.ITALIC);
    public static final Font MEDIUM = loadFont("/fonts/Roboto-Medium.ttf").deriveFont(Font.PLAIN);
    public static final Font MEDIUM_ITALIC = loadFont("/fonts/Roboto-MediumItalic.ttf").deriveFont(Font.ITALIC);
    public static final Font REGULAR = loadFont("/fonts/Roboto-Regular.ttf").deriveFont(Font.PLAIN);
    public static final Font THIN = loadFont("/fonts/Roboto-Thin.ttf").deriveFont(Font.PLAIN);
    public static final Font THIN_ITALIC = loadFont("/fonts/Roboto-ThinItalic.ttf").deriveFont(Font.ITALIC);

    private static Font loadFont(String fontPath) {
        if (fontSettings.isEmpty()) {
            fontSettings.put(TextAttribute.SIZE, (float) (11 * Toolkit.getDefaultToolkit().getScreenResolution() / 72.0));
            fontSettings.put(TextAttribute.KERNING, TextAttribute.KERNING_ON);
        }

        try (InputStream inputStream = MaterialFontRoboto.class.getResourceAsStream(fontPath)) {
            return Font.createFont(Font.TRUETYPE_FONT, inputStream).deriveFont(fontSettings);
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
            throw new RuntimeException("Font " + fontPath + " wasn't loaded");
        }
    }
}
