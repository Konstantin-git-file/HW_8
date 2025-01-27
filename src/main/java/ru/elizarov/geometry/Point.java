package ru.elizarov.geometry;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
//@NoArgsConstructor - удален, чтобы нельзя было создать точку без указания координат (условие из задачи 1.4.1.)
public class Point {
    private int x;
    private int y;

    public String getTextRepresentation() {
        return "{" + x + ";" + y + "}";
    }

    public double distanceTo(Point other) {
        if (other == null) {
            throw new IllegalArgumentException("Другая точка не может быть null.");
        }
        int dx = this.x - other.x;
        int dy = this.y - other.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    public String getDescription() {
        return "Точка в координате {" + x + ";" + y + "}";
    }
}
