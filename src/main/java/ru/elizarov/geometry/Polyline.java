package ru.elizarov.geometry;

import lombok.Data;

/*
1.3.2 Ломаная линия. Создайте сущность Ломаная, которая будет представлять собой ломаную линию (см. пример на рис.1.13). Ломаная линия представляет собой набор следующих характеристик:
    • Имеет массив Точек (из задачи 1.1.1), через которые линия проходит.
    • Может быть приведена к строковой форме вида “Линия [Т1,T2,…,TN]”, где TN – это результат приведения к строке Точки с номером N
Необходимо выполнить следующие задачи:
    1. Создать первую Ломаную, проходящую через точки {1;5}, {2;8}, {5;3}
    2. Создайте вторую Ломаную, чья первая и последняя Точка совпадает с таковыми у первой Ломаной, но в качестве середины имеет точки: {2,-5}, {4,-8}
    3. Сдвиньте начало первой Ломаной таким образом, чтобы одновременно сдвинулось начало второй Ломаной.
 */
@Data
//@AllArgsConstructor
public class Polyline implements Measurable{
    private Point[] points;

    // конструктор без параметров (создает пустую ломаную) - условие по п.1.4.3.
    public Polyline() {
        this.points = new Point[0]; // Пустой массив точек
    }

    // конструктор с набором точек - условие по п.1.4.3.
    public Polyline(Point[] points) {
        this.points = points;
    }

    public double getLength() {
        double length = 0;
        for (int i = 1; i < points.length; i++) {
            length += points[i - 1].distanceTo(points[i]);
        }
        return length;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Ломаная [");
        for (int i = 0; i < points.length; i++) {
            result.append(points[i].getTextRepresentation());
            if (i < points.length - 1) {
                result.append(", ");
            }
        }
        result.append("]");
        return result.toString();
    }

    public void shift(int dx, int dy) {
        for (Point point : points) {
            point.setX(point.getX() + dx);
            point.setY(point.getY() + dy);
        }
    }
}

