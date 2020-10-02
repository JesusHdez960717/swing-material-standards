package com.jhw.swing.material.standards.example;

import com.jhw.swing.material.standards.MaterialColors;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.UnsupportedLookAndFeelException;
import com.jhw.swing.derivable_icons.DerivableIcon;
import com.jhw.swing.material.standards.MaterialIcons;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
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
