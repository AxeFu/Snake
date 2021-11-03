package SnakeGame; //Папка где находится программа и её составляющие.

class Snake { //Создание обьекта-класса с именем Snake.

    int length= 2; //Числовое значение длины змейки.
    static int direction = 2; //Числовое значение направления змейки по умолчанию.

    int[] sX = new int[Start.HEIGHT * Start.WIDTH + 1]; //Количевство звеньев змейки 401.
    int[] sY = new int[Start.HEIGHT * Start.WIDTH + 1]; //Количевство звеньев змейки 401.

    Snake(int x1, int y1, int x2, int y2) { //Создание метода змейка определяющего её место положение.
        sX[0] = x1; //X координата головы
        sX[1] = x2; //X координата Звенья
        sY[0] = y1; //Y координата головы
        sY[1] = y2; //Y координата Звенья
    }

    void move() { //Вызов встроенного метода move-Движение.

        for (int l = length; l > 0; l--) { //Создание звеньев и их перемещение при увеличении длинны.
            sX[l] = sX[l-1];
            sY[l] = sY[l-1];
        }

        //up Вверх
        if (direction == 0) {
            sY[0]--;
            SnakeGame.control[0] = 1;
            SnakeGame.control[2] = 1;
            SnakeGame.control[1] = 0;
            SnakeGame.control[3] = 0;
        }
        //down Вниз
        if (direction == 2) {
            sY[0]++;
            SnakeGame.control[2] = 1;
            SnakeGame.control[0] = 1;
            SnakeGame.control[1] = 0;
            SnakeGame.control[3] = 0;
        }
        //right Вправо
        if (direction == 1) {
            sX[0]++;
            SnakeGame.control[1] = 1;
            SnakeGame.control[3] = 1;
            SnakeGame.control[0] = 0;
            SnakeGame.control[2] = 0;
        }
        //left Влево
        if (direction == 3) {
            sX[0]--;
            SnakeGame.control[3] = 1;
            SnakeGame.control[1] = 1;
            SnakeGame.control[0] = 0;
            SnakeGame.control[2] = 0;
        }

        if (sY[0] > Start.HEIGHT - 1) sY[0] = 0; //Переход змейки с одной стороны экрана на другую.
        if (sY[0] < 0) sY[0] = Start.HEIGHT - 1; //Переход змейки с одной стороны экрана на другую.

        if (sX[0] > Start.WIDTH - 1)sX[0] = 0; //Переход змейки с одной стороны экрана на другую.
        if (sX[0] < 0) sX[0] = Start.WIDTH - 1; //Переход змейки с одной стороны экрана на другую.

    }
}
