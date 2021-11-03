package SnakeGame; //Папка где находится программа и её составляющие.

class Apple { //Создание класса обьекта Яблоко.

    int posY; //Координаты X и Y Яблока.
    int posX;

    Apple(int x, int y) { //Создание метода яблока определяющего его положение.
        posX = x;
        posY = y;
    }

    void setRandomPosition() { //Создание метода случайной позиции яблока.
        posX = Math.abs ((int) (Math.random() * Start.WIDTH - 1)); //Генератор случайных чисел в пределах экрана по X
        posY = Math.abs ((int) (Math.random() * Start.HEIGHT - 1)); //Генератор случайных чисел в пределах экрана по Y
    }
}
