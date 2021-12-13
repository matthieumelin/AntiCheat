package fr.geeklegend.ac.processors;

import fr.geeklegend.ac.data.PlayerData;
import fr.geeklegend.ac.utilities.LocationUtils;
import io.github.retrooper.packetevents.packetwrappers.play.in.flying.WrappedPacketInFlying;

public class MovementProcessor {
    private final PlayerData data;

    private double x, y, z,
            lastX, lastY, lastZ,
            deltaX, deltaY, deltaZ, deltaXZ,
            lastDeltaX, lastDeltaY, lastDeltaZ, lastDeltaXZ;
    private int airTicks, edgeBlockTicks;
    private boolean isNearBoat, isInLiquid, isInWeb, onClimable, onGround, isAtTheEdgeOfABlock;

    public MovementProcessor(final PlayerData data) {
        this.data = data;
    }

    public void handle(WrappedPacketInFlying wrappedPacketInFlying) {
        if (wrappedPacketInFlying.isMoving()) {
            lastX = x;
            lastY = y;
            lastZ = z;

            x = wrappedPacketInFlying.getPosition().getX();
            y = wrappedPacketInFlying.getPosition().getY();
            z = wrappedPacketInFlying.getPosition().getZ();

            lastDeltaX = deltaX;
            lastDeltaY = deltaY;
            lastDeltaZ = deltaZ;
            lastDeltaXZ = deltaXZ;

            deltaX = x - lastX;
            deltaY = y - lastY;
            deltaZ = z - lastZ;
            deltaXZ = Math.sqrt((deltaX * deltaX) + (deltaZ * deltaZ));

            if (LocationUtils.isCloseToGround(data.getPlayer().getLocation())) {
                airTicks = 0;
            } else airTicks++;

            if (LocationUtils.isAtEdgeOfABlock(data.getPlayer())) {
                edgeBlockTicks++;
            } else edgeBlockTicks = 0;

            isNearBoat = LocationUtils.isNearBoat(data.getPlayer());
            isInLiquid = LocationUtils.isInLiquid(data.getPlayer());
            isInWeb = LocationUtils.isCollidingWithWeb(data.getPlayer());
            onClimable = LocationUtils.isCollidingWithClimbable(data.getPlayer());
            onGround = wrappedPacketInFlying.isOnGround();
        }
    }

    public PlayerData getData() {
        return data;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public double getLastX() {
        return lastX;
    }

    public void setLastX(double lastX) {
        this.lastX = lastX;
    }

    public double getLastY() {
        return lastY;
    }

    public void setLastY(double lastY) {
        this.lastY = lastY;
    }

    public double getLastZ() {
        return lastZ;
    }

    public void setLastZ(double lastZ) {
        this.lastZ = lastZ;
    }

    public double getDeltaX() {
        return deltaX;
    }

    public void setDeltaX(double deltaX) {
        this.deltaX = deltaX;
    }

    public double getDeltaY() {
        return deltaY;
    }

    public void setDeltaY(double deltaY) {
        this.deltaY = deltaY;
    }

    public double getDeltaZ() {
        return deltaZ;
    }

    public void setDeltaZ(double deltaZ) {
        this.deltaZ = deltaZ;
    }

    public double getDeltaXZ() {
        return deltaXZ;
    }

    public void setDeltaXZ(double deltaXZ) {
        this.deltaXZ = deltaXZ;
    }

    public double getLastDeltaX() {
        return lastDeltaX;
    }

    public void setLastDeltaX(double lastDeltaX) {
        this.lastDeltaX = lastDeltaX;
    }

    public double getLastDeltaY() {
        return lastDeltaY;
    }

    public void setLastDeltaY(double lastDeltaY) {
        this.lastDeltaY = lastDeltaY;
    }

    public double getLastDeltaZ() {
        return lastDeltaZ;
    }

    public void setLastDeltaZ(double lastDeltaZ) {
        this.lastDeltaZ = lastDeltaZ;
    }

    public double getLastDeltaXZ() {
        return lastDeltaXZ;
    }

    public void setLastDeltaXZ(double lastDeltaXZ) {
        this.lastDeltaXZ = lastDeltaXZ;
    }

    public int getAirTicks() {
        return airTicks;
    }

    public void setAirTicks(int airTicks) {
        this.airTicks = airTicks;
    }

    public int getEdgeBlockTicks() {
        return edgeBlockTicks;
    }

    public void setEdgeBlockTicks(int edgeBlockTicks) {
        this.edgeBlockTicks = edgeBlockTicks;
    }

    public boolean isNearBoat() {
        return isNearBoat;
    }

    public void setNearBoat(boolean nearBoat) {
        isNearBoat = nearBoat;
    }

    public boolean isInLiquid() {
        return isInLiquid;
    }

    public void setInLiquid(boolean inLiquid) {
        isInLiquid = inLiquid;
    }

    public boolean isInWeb() {
        return isInWeb;
    }

    public void setInWeb(boolean inWeb) {
        isInWeb = inWeb;
    }

    public boolean isOnClimable() {
        return onClimable;
    }

    public void setOnClimable(boolean onClimable) {
        this.onClimable = onClimable;
    }

    public boolean isOnGround() {
        return onGround;
    }

    public void setOnGround(boolean onGround) {
        this.onGround = onGround;
    }

    public boolean isAtTheEdgeOfABlock() {
        return isAtTheEdgeOfABlock;
    }

    public void setAtTheEdgeOfABlock(boolean atTheEdgeOfABlock) {
        isAtTheEdgeOfABlock = atTheEdgeOfABlock;
    }
}
