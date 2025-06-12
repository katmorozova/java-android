package com.example.movies;

public class Rating {

    double kp;

    public Rating(double kp) {
        this.kp = kp;
    }

    public double getKp() {
        return kp;
    }

    @Override
    public String toString() {
        return "Rating{" +
                "kp=" + kp +
                '}';
    }
}
