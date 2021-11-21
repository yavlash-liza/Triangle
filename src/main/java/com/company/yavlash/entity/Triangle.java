package com.company.yavlash.entity;

import java.util.Objects;

public class Triangle {
    private static Long id;
    static {
        id = 0L;
    }

    private Long triangleId;
    private Point pointA;
    private Point pointB;
    private Point pointC;

    public Triangle() {
    }

    public Triangle(Point pointA, Point pointB, Point pointC) {
        this.triangleId = ++id;
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
    }

    public Point getPointB() {
        return pointB;
    }

    public void setPointB(Point pointB) {
        this.pointB = pointB;
    }

    public Point getPointC() {
        return pointC;
    }

    public void setPointC(Point pointC) {
        this.pointC = pointC;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {return true;}
        if (object == null || getClass() != object.getClass()) {return false;}
        Triangle aThat = (Triangle) object;

        if(!Objects.equals(getTriangleId(), aThat.getTriangleId())){return false;}

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
        result = prime * result + (getTriangleId() == null ? 0 : getTriangleId().hashCode());
        result = prime * result + (getPointA() == null ? 0 : getPointA().hashCode());
        result = prime * result + (getPointB() == null ? 0 : getPointB().hashCode());
        result = prime * result + (getPointC() == null ? 0 : getPointC().hashCode());
        return result;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "triangleId=" + triangleId +
                ", pointA=" + pointA +
                ", pointB=" + pointB +
                ", pointC=" + pointC +
                '}';
    }
}