package com.company.yavlash.entity;

import com.company.yavlash.observer.Observable;
import com.company.yavlash.observer.Observer;
import com.company.yavlash.observer.TriangleEvent;
import com.company.yavlash.util.IdGenerator;

import java.util.Comparator;

public class Triangle implements Observable {
    private Long triangleId;
    private Point pointA;
    private Point pointB;
    private Point pointC;
    private Observer observer;

    public Triangle() {
    }

    public Triangle(Point pointA, Point pointB, Point pointC) {
        triangleId = IdGenerator.generateId();
        this.pointA = pointA;
        this.pointB = pointB;
        this.pointC = pointC;
    }

    public Long getTriangleId() {
        return triangleId;
    }

    public void setTriangleId(Long triangleId) {
        this.triangleId = triangleId;
    }

    public Point getPointA() {
        return pointA;
    }

    public void setPointA(Point pointA) {
        this.pointA = pointA;
        notifyObservers();
    }

    public Point getPointB() {
        return pointB;
    }

    public void setPointB(Point pointB) {
        this.pointB = pointB;
        notifyObservers();
    }

    public Point getPointC() {
        return pointC;
    }

    public void setPointC(Point pointC) {
        this.pointC = pointC;
        notifyObservers();
    }

    @Override
    public void attach(Observer observer) {
        this.observer = observer;
    }

    @Override
    public void detach(Observer observer) {
        this.observer = null;
    }

    @Override
    public void notifyObservers() {
        if (observer != null) {
            var triangleEvent = new TriangleEvent(this);
            observer.parametersChange(triangleEvent);
        }
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {return true;}
        if (object == null || getClass() != object.getClass()) {return false;}
        Triangle aThat = (Triangle) object;

        if(getPointA() == null) {
            if(aThat.getPointA() != null){return false;}
        } else if(!getPointA().equals(aThat.getPointA())){return false;}

        if(getPointB() == null) {
            if(aThat.getPointB() != null){return false;}
        } else if(!getPointB().equals(aThat.getPointB())){return false;}

        if(getPointC() == null) {
            return aThat.getPointC() == null;
        } else return getPointC().equals(aThat.getPointC());
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (getPointA() == null ? 0 : getPointA().hashCode());
        result = prime * result + (getPointB() == null ? 0 : getPointB().hashCode());
        result = prime * result + (getPointC() == null ? 0 : getPointC().hashCode());
        return result;
    }

    @Override
    public String toString() {
        return new StringBuilder(getClass().getSimpleName())
                .append("{")
                .append("triangleId=").append(getTriangleId())
                .append(", pointA=").append(getPointA())
                .append(", pointB=").append(getPointB())
                .append(", pointC=").append(getPointC())
                .append("}")
                .toString();
    }

    public static class IdComparator implements Comparator<Triangle> {
        @Override
        public int compare(Triangle triangleFirst, Triangle triangleSecond) {
            Long firstId = triangleFirst.getTriangleId();
            Long secondId = triangleSecond.getTriangleId();
            return Double.compare(firstId, secondId);
        }
    }

    public static class AreaComparator implements Comparator<Triangle> {
        @Override
        public int compare(Triangle triangleFirst, Triangle triangleSecond) {
            TriangleWarehouse warehouse = TriangleWarehouse.getInstance();
            double areaFirst = warehouse.get(triangleFirst.getTriangleId()).getArea();
            double areaSecond = warehouse.get(triangleSecond.getTriangleId()).getArea();
            return Double.compare(areaFirst, areaSecond);
        }
    }

    public static class PerimeterComparator implements Comparator<Triangle> {
        @Override
        public int compare(Triangle triangleFirst, Triangle triangleSecond) {
            TriangleWarehouse warehouse = TriangleWarehouse.getInstance();
            double perimeterFirst = warehouse.get(triangleFirst.getTriangleId()).getPerimeter();
            double perimeterSecond = warehouse.get(triangleSecond.getTriangleId()).getPerimeter();
            return Double.compare(perimeterFirst, perimeterSecond);
        }
    }

    public static class FirstPointComparator implements Comparator<Triangle> {
        @Override
        public int compare(Triangle triangleFirst, Triangle triangleSecond) {
            String firstPoint = triangleFirst.getPointA().toString();
            String secondPoint = triangleSecond.getPointA().toString();
            return CharSequence.compare(firstPoint, secondPoint);
        }
    }

    public static class SecondPointComparator implements Comparator<Triangle> {
        @Override
        public int compare(Triangle triangleFirst, Triangle triangleSecond) {
            String firstPoint = triangleFirst.getPointB().toString();
            String secondPoint = triangleSecond.getPointB().toString();
            return CharSequence.compare(firstPoint, secondPoint);
        }
    }

    public static class ThirdPointComparator implements Comparator<Triangle> {
        @Override
        public int compare(Triangle triangleFirst, Triangle triangleSecond) {
            String firstPoint = triangleFirst.getPointC().toString();
            String secondPoint = triangleSecond.getPointC().toString();
            return CharSequence.compare(firstPoint, secondPoint);
        }
    }
}