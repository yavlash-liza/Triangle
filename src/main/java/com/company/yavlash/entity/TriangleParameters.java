package com.company.yavlash.entity;

public class TriangleParameters {
    private double perimeter;
    private double area;

    public TriangleParameters(double perimeter, double area) {
        this.perimeter = perimeter;
        this.area = area;
    }

    public double getPerimeter() {
        return perimeter;
    }

    public void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        TriangleParameters aThat = (TriangleParameters) object;

        if(getPerimeter() != aThat.getPerimeter()){return false;}
        return getArea() == aThat.getArea();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Double.hashCode(getPerimeter());
        result = prime * result + Double.hashCode(getArea());
        return result;
    }

    @Override
    public String toString() {
        return new StringBuilder(getClass().getSimpleName())
                .append("{")
                .append("perimeter=").append(getPerimeter())
                .append(", area=").append(getArea())
                .append("}")
                .toString();
    }
}