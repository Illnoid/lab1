package Vehicles;

/**
 * Vehicles.Scania is a subclass to the superclass Vehicles.Cars.
 * <br>
 * A Vehicles.Scania object has all the instance variables defined in Vehicles.Cars, with the exception
 * of unique instance variables only existing within Vehicles.Saab95. This state information includes:
 * <ul>
 * <li>Every instance variable in Vehicles.Cars</li>
 * <li>A double describing the angle of the flak</li>
 * </ul>
 */
public class Scania extends Cars implements Loadable {

    private double flakAngle;

    /**
     * Instantiates a new Vehicles.Scania.
     * The Vehicles.Scania has 2 doors and the flakangle is set to 1 so it can start directly when spawning.
     * The vehicle stands still when initializing.
     */
    public Scania() {
        setNrDoors(2);
        setModelName("Scania");
        setFlakAngle(1);
        stopEngine();
    }

    /**
     * Gets flakAngle.
     *
     * @return the flakAngle
     */
    public double getFlakAngle() {
        return flakAngle;
    }

    /**
     * Sets flakAngle. Only sets if angle <= 70 and angle >= 0.
     * If currentSpeed == 0, sets flakAngle if angle != 0.
     *
     * @param angle the angle
     */
    protected void setFlakAngle(double angle) {
        if (angle >= 0.0 && angle <= 70.0) {
            if (getCurrentSpeed() == 0 && angle == 0) {
                flakAngle = angle;
            } else if (getCurrentSpeed() == 0) {
                flakAngle = angle;
            }
        }
    }

    @Override
    public void setFlakDown(boolean flakDown) {
        if (flakDown) {
            setFlakAngle(0);
            return;
        }
        setFlakAngle(70);
    }

    @Override
    public boolean isFlakDown() {
        if (getFlakAngle() == 0) {
            return true;
        }
        return false;
    }

    @Override
    public void gas(double amount) {
        if (!isFlakDown()) {
            super.gas(amount);
        }
    }

    @Override
    public void startEngine() {
        if (!isFlakDown()) {
            super.startEngine();
        }
    }

}