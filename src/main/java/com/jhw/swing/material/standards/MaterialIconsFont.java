/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.root101.swing.material.standards;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Toolkit;
import java.awt.font.TextAttribute;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class MaterialIconsFont {

    private static final Map<TextAttribute, Object> fontSettings = new HashMap<>();
    public static final Font ICON_FONT = loadFont("/MaterialIcons-Regular.ttf");

    private static Font loadFont(String fontResourcePath) {
        if (fontSettings.isEmpty()) {
            fontSettings.put(TextAttribute.SIZE, new Float(11 * Toolkit.getDefaultToolkit().getScreenResolution() / 72.0));
            fontSettings.put(TextAttribute.KERNING, TextAttribute.KERNING_ON);
        }

        try (InputStream inputStream = MaterialIconsFont.class.getResourceAsStream(fontResourcePath)) {
            return Font.createFont(Font.TRUETYPE_FONT, inputStream).deriveFont(fontSettings);
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
            throw new RuntimeException("Font " + fontResourcePath + " wasn't loaded");
        }
    }

}
