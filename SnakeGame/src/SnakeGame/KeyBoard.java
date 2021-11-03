package SnakeGame;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import static SnakeGame.SnakeGame.*;
import static SnakeGame.Snake.*;

public class KeyBoard extends KeyAdapter {//Создание класса для обработки нажатий

    public void keyPressed(KeyEvent e) {

        //up
        if ((e.getKeyCode() == KeyEvent.VK_UP) && (control[2] == 0)) direction = 0; //Условие назначения числового значения нажатия
            //down
        else if ((e.getKeyCode() == KeyEvent.VK_DOWN) && (control[0] == 0)) direction = 2; //Условие назначения числового значения нажатия
            //right
        else if ((e.getKeyCode() == KeyEvent.VK_RIGHT) && (control[3] == 0)) direction = 1; //Условие назначения числового значения нажатия
            //left
        else if ((e.getKeyCode() == KeyEvent.VK_LEFT) && (control[1] == 0)) direction = 3; //Условие назначения числового значения нажатия

        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) System.exit(0); //Если будет нажата кнопка выход программа закроется
    }
}