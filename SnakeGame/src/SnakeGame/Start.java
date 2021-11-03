package SnakeGame; //Папка где находится программа и её составляющие.

import java.awt.*; //Перенос нужных библиотек.
import javax.swing.*; //Перенос нужных библиотек.

public class Start extends JFrame { //Создание обьекта-класса с именем файла и присваивание ему свойств окна.

    private static Dimension screen = Toolkit.getDefaultToolkit().getScreenSize(); //Сбор данных о размере экрана.
    static final int SCALE = 32; //Размер клеток.
    static final int WIDTH = screen.width/SCALE; //Ширина окна.
    static final int HEIGHT = (screen.height)/SCALE; //Высота окна.

    private Start() { //Метод класса.
        setSize(WIDTH*SCALE,HEIGHT*SCALE); //Установка размеров окна.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Установка условия чтобы выключить программу.
        setResizable(false); //Запрет на изменение размера окна.
        setLocationRelativeTo(null);//Появление окна по середине экрана.
        setUndecorated(true);//Удаление рамки окна.
        add(new SnakeGame());//Добавление правил игры находящиеся в другом классе с именем SnakeGame.
        setVisible(true);//Сделать окно видимым.
    }

    public static void main(String[] args) { //Запуск программы.
        SwingUtilities.invokeLater(Start::new);
    }
}
