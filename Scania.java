import java.awt.*;

public class Scania extends PlatformVehicle {

    public Scania(double x, double y) {
        super(2, 250, Color.black, "Scania", x, y, 10);
    }

    public void tiltPlatform(int degrees) {
        if(this.isStationary()){
            this.setPlatformAngle(this.getPlatformAngle() + degrees);

            if (this.getPlatformAngle() > 70) {
                this.setPlatformAngle(70);
            } else if (this.getPlatformAngle() < 0) {
                this.setPlatformAngle(0);
            }
        }
    }

    @Override
    public double speedFactor() {
        return 1;
    }



}
