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
package com.root101.swing.material.standards.example;

import com.root101.swing.material.standards.MaterialColors;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.UnsupportedLookAndFeelException;
import com.root101.swing.derivable_icons.DerivableIcon;
import com.root101.swing.material.standards.MaterialIcons;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
public class MATERIAL_ICONS_EXAMPLE extends javax.swing.JFrame {

    public static final Field[] fields = MaterialIcons.class.getDeclaredFields();

    public static DerivableIcon getRandomIcon() {
        DerivableIcon c = null;
        for (int i = 0; i < 1000; i++) {
            try {
                c = (DerivableIcon) fields[new Random().nextInt(fields.length)].get(null);
                return c;
            } catch (Exception e) {
            }
        }
        return MaterialIcons.ADD;
    }

    public MATERIAL_ICONS_EXAMPLE() {
        initComponents();
        Arrays.sort(fields, new Comparator<Field>() {
            @Override
            public int compare(Field o1, Field o2) {
                return o1.getName().compareToIgnoreCase(o2.getName());
            }
        });

        for (Field field : fields) {
            if (Modifier.isStatic(field.getModifiers())
                    && DerivableIcon.class.isAssignableFrom(field.getType())) {
                try {
                    DerivableIcon c = (DerivableIcon) field.get(null);
                    String name = field.getName();
                    JLabel l = new JLabel();
                    l.setIcon(c);
                    l.setToolTipText(name);
                    this.panelBack.add(l);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }

        this.setExtendedState(JFrame.MAXIMIZED_BOTH);//maximize the window
    }

    private void initComponents() {

        panelBack = new JPanel();
        panelBack.setBackground(MaterialColors.WHITE);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.add(panelBack);

        pack();
    }

    public static void main(String args[]) throws UnsupportedLookAndFeelException {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MATERIAL_ICONS_EXAMPLE().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//:variables
    private JPanel panelBack;
    // End of variables declaration                   

}
