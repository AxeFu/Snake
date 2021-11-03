package SnakeGame; //Папка где находится программа и её составляющие.

import java.awt.*; //Перенос нужных библиотек.
import javax.swing.*; //Перенос нужных библиотек.
import java.awt.event.*; //Перенос нужных библиотек.

public class SnakeGame extends JPanel implements ActionListener { //Создание обьекта-класса с именем SnakeGame

    private static int speed = 10; //Числовое значение скорости.
    static byte[] control = new byte[]{0, 0, 0, 0}; //Числовое значение нажатой клавиши.

    private Snake s = new Snake(5,6,5,5); //Выделение памяти обьекту змейка.
    private Apple apple = new Apple(Math.abs ((int) (Math.random() * SnakeGame.WIDTH - 1)),Math.abs ((int) (Math.random() * SnakeGame.HEIGHT - 1))); //Выделение памяти обьекту Яблоко.
    private Timer timer = new Timer(1500/speed,this); //Выделение памяти обьекту таймер который заставляет обновлятся экран.

    SnakeGame() { //Создание метода класса игры змейка.
        JOptionPane.showMessageDialog(null,"Чтобы выйти нажмите Esc");//При запуске выводит сообщение.
        apple.setRandomPosition();
        timer.start();//Запуск таймера.
        addKeyListener(new KeyBoard());//Добавление сканера нажатий.
        setFocusable(true);//Для работы сканера нажатий.
    }

    public void paint(Graphics g) { //Создание метода паинт который будет отрисовывать игру и показывать игроку.
        g.setColor(Color.BLACK); //Выбор цвета кисти Черный
        g.fillRect(0 ,0 ,Start.WIDTH*Start.SCALE,Start.HEIGHT*Start.SCALE);//Создание квадрата на весь экран.

        for (int x = 32; x < Start.WIDTH*Start.SCALE; x+=Start.SCALE) {//Цыкл для отрисовки пикселей
            g.setColor(Color.DARK_GRAY);//Выбор цвета кисти Темно серый.
            g.drawLine(x,0,x,Start.HEIGHT*Start.SCALE); //Отрисовка линий отдалённых от друг друга на размер клетки.
        }

        for (int y = 32; y < Start.HEIGHT*Start.SCALE; y+=Start.SCALE) {//Цыкл для отрисовки пикселей
            g.setColor(Color.DARK_GRAY); //Выбор цвета кисти Темно серый.
            g.drawLine(0,y,Start.WIDTH*Start.SCALE,y); //Отрисовка линий отдалённых от друг друга на размер клетки.
        }

        g.setColor(Color.RED);//Выбор цвета кисти Красный.
        g.fillOval(apple.posX*Start.SCALE+3, apple.posY*Start.SCALE+3,Start.SCALE-6,Start.SCALE-6);//Отрисовать круг (Яблоко).

        for (int l = 1; l < s.length; l++) {//Цикл для отрисовки змейки
            g.setColor(Color.GREEN);//Цвет звеньев Зелёный
            g.fillRect(s.sX[l]*Start.SCALE+1, s.sY[l]*Start.SCALE+1,Start.SCALE-1,Start.SCALE-1);//Отрисовка змейки на экране в зависимости от числового значения положения.
            g.setColor(Color.WHITE);//Цвет головы Белый
            g.fillRect(s.sX[0]*Start.SCALE+1, s.sY[0]*Start.SCALE+1,Start.SCALE-1,Start.SCALE-1);//Отрисовка змейки на экране в зависимости от числового значения положения.
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) { //Метод для считывания логики.
        s.move();//Движение
        if ((s.sX[0] == apple.posX) &&(s.sY[0] == apple.posY)) {//Проверка съела ли змейка яблоко
            apple.setRandomPosition();
            s.length++;
        }
        for (int l = 1; l < s.length; l++) { //Если яблоко появилось внутри змейки оно меняет положение
            if ((s.sX[l] == apple.posX) && (s.sY[l] == apple.posY)) {
                apple.setRandomPosition();
            }
            if ((s.sX[l] == s.sX[0]) && (s.sY[l] == s.sY[0])) {//Условия проигрыша.
                timer.stop();//Таймер стоп
                JOptionPane.showMessageDialog(null,"Ваш счет: " + (s.length-1));//Сообщение
                s.length = 2;//Обнуление прогресса
                timer.start();//Таймер старт
            }
        }
        repaint();//Обновить кадр
    }
}
