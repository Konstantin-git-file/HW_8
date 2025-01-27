package ru.elizarov.geometry;

import lombok.Data;

@Data
class Line implements Measurable {
    private Point start;
    private Point end;

    public Line(Point start, Point end) {
        this.start = new Point(start.getX(), start.getY());
        this.end = new Point(end.getX(), end.getY());
    }

    public Line(int startX, int startY, int endX, int endY) {
        this.start = new Point(startX, startY);
        this.end = new Point(endX, endY);
    }

    public double getLength() {
        return Math.sqrt(Math.pow(end.getX() - start.getX(), 2) + Math.pow(end.getY() - start.getY(), 2));
    }

    public void setStart(int x, int y) {
        this.start.setX(x);
        this.start.setY(y);
    }

    public void setEnd(int x, int y) {
        this.end.setX(x);
        this.end.setY(y);
    }

    @Override
    public String toString() {
        return "Линия от " + start.getTextRepresentation() + " до " + end.getTextRepresentation();
    }
}