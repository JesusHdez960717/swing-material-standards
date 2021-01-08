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

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.InputStream;

/**
 * Coleccion de imagenes utiles para el diseño.
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
public class MaterialImages {

    public static final BufferedImage TOGGLE_BUTTON_OFF = loadImg("/imgs/toggle_off.png");
    public static final BufferedImage TOGGLE_BUTTON_ON = loadImg("/imgs/toggle_on.png");
    public static final BufferedImage ERROR = loadImg("/imgs/error.png");
    public static final BufferedImage CREATE = loadImg("/imgs/create.png");
    public static final BufferedImage EDIT = loadImg("/imgs/edit.png");
    public static final BufferedImage WARNING = loadImg("/imgs/warning.png");
    public static final BufferedImage QUESTION = loadImg("/imgs/question.png");
    public static final BufferedImage INFORMATION = loadImg("/imgs/information.png");

    private MaterialImages() {
    }

    public static BufferedImage loadImg(String imgPath) {
        try (InputStream inputStream = MaterialImages.class.getResourceAsStream(imgPath)) {
            return ImageIO.read(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Image " + imgPath + " wasn't loaded");
        }
    }
}
