package lab4.points.api.v1;

import java.time.LocalDateTime;

public class PointDto {

    private final double x;
    private final double y;
    private final double r;

    private final boolean hit;
    private final LocalDateTime created;

    public boolean isHit() {
        return hit;
    }

    public double getR() {
        return r;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public PointDto(double x, double y, double r, boolean hit, LocalDateTime created) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.hit = hit;
        this.created = created;
    }
}
