package fr.geeklegend.ac.utilities;

import org.bukkit.Location;
import org.bukkit.event.player.PlayerMoveEvent;

public class Distance {
    private Location from, to;

    private double xDiff, yDiff, zDiff;

    private boolean isGoingUp, isGoingDown;

    public Distance(PlayerMoveEvent event) {
        this.from = event.getFrom();
        this.to = event.getTo();
        this.xDiff = (Math.max(from.getX(), to.getX())) - (Math.min(from.getX(), to.getX()));
        this.yDiff = (Math.max(from.getY(), to.getY())) - (Math.min(from.getY(), to.getY()));
        this.zDiff = (Math.max(from.getZ(), to.getZ())) - (Math.min(from.getZ(), to.getZ()));
    }

    public Distance(Location a, Location b) {
        this.from = a;
        this.to = b;
        this.xDiff = Math.abs(a.getX() - b.getX());
        this.yDiff = Math.abs(a.getY() - b.getY());
        this.zDiff = Math.abs(a.getZ() - b.getZ());
    }

    public Location getFrom() {
        return from;
    }

    public void setFrom(Location from) {
        this.from = from;
    }

    public Location getTo() {
        return to;
    }

    public void setTo(Location to) {
        this.to = to;
    }

    public double getxDiff() {
        return xDiff;
    }

    public void setxDiff(double xDiff) {
        this.xDiff = xDiff;
    }

    public double getyDiff() {
        return yDiff;
    }

    public void setyDiff(double yDiff) {
        this.yDiff = yDiff;
    }

    public double getzDiff() {
        return zDiff;
    }

    public void setzDiff(double zDiff) {
        this.zDiff = zDiff;
    }

    public boolean isGoingUp() {
        return isGoingUp;
    }

    public void setGoingUp(boolean goingUp) {
        isGoingUp = goingUp;
    }

    public boolean isGoingDown() {
        return isGoingDown;
    }

    public void setGoingDown(boolean goingDown) {
        isGoingDown = goingDown;
    }
}
