package edu.colostate.cs.cs414.soggyZebras.rollerball.Client.menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

/**
 * represents the registration screen
 */
public class RegPanel extends MenuPanel {

    boolean registering;

    public RegPanel(MenuGUI menuGUI) {
        super("register", menuGUI);
        // TODO: add forms for registering
        refresh();
    }

    @Override
    public void refresh() {
        removeAll();
        add(new JLabel("username: "));
        add(new TextField(30));
        add(new JLabel("email: "));
        add(new TextField(30));
        add(new JLabel("password: "));
        add(new JPasswordField(21));
        add(createLinkedActionButton("Register", new RegisterListener()));
        add(createLinkedButton("Back", "register_login"));
        registering = false;
        revalidate();
        repaint();
    }

    class RegisterListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String username = ((TextField)getComponent(1)).getText().trim();
            String email = ((TextField)getComponent(3)).getText().trim();
            String password = String.valueOf(((JPasswordField)getComponent(5)).getPassword()).trim();
            try {
                if (!registering) {
                    registering = true;
                    add(new JLabel("Registering..."));
                    revalidate();
                    repaint();
                    getMenuGUI().client.register(username, password, email);
                }
            } catch (IOException e1) {
                e1.printStackTrace();
            } catch (NoSuchAlgorithmException e1) {
                e1.printStackTrace();
            }
        }
    }
}
