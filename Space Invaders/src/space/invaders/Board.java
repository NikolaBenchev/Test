/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package space.invaders;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author 2017_stoyanio
 */
public class Board extends JPanel implements KeyListener, ActionListener{

    private int delay = 3;
    private Timer timer;
    private Player player;
    LinkedList<Bullet> bullets = new LinkedList<>();
    
    public Board(){
        this.setBackground(Color.black);
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer = new Timer(delay, this);
        timer.start();
        player = new Player(new Position(9 * 64, 4 * 128), 3, 50, "player");
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println(e.getKeyCode());
        switch(e.getKeyCode()){
            case 87: // W 
            case 38:
                player.move(0, -1);
                break;
            case 65: // A
            case 37:
                player.move(-1, 0);
                break;
            case 83: // S
            case 40:
                player.move(0, 1);
                break;
            case 68: // D
            case 39:
                player.move(1, 0);
                break;
            case 32: // Space (shoot)
                Bullet newBullet = player.shoot();
                bullets.add(newBullet);
                break;
        }
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i = 0; i < bullets.size(); i++){
            bullets.get(i).move(0, 1);
        }
        repaint();
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        for(int i = 0; i < bullets.size(); i++){
            bullets.get(i).draw(g, this);
        }
        player.draw(g, this);
    }
}
