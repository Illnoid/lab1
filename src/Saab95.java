import java.awt.*;

public class Saab95 extends Cars {
    /**
     * Saab95 is a subclass to the superclass Cars.
     * <br>
     * A Saab95 object has all the instance variables defined in Cars, with the exception
     * of unique instance variables only existing within Saab95. This state information includes:
     *  <ul>
     *      <li>Every instance variable in Cars</li>
     *      <li>A boolean determining if the turbo is on</li>
     *  </ul>
     */

    private boolean turboOn; // The current state of turbo.

    /**
     * Default class constructor.
     */
    public Saab95(){
        setNrDoors(2);
        setColor(Color.red);
        setEnginePower(125);
        turboOn = false;
        setModelName("Saab95");
        stopEngine();
    }

    /**
     * Changes turboOn to true.
     */
    public void setTurboOn(){
        turboOn = true;
    }

    /**
     * Changes turboOff to false.
     */
    public void setTurboOff(){
        turboOn = false;
    }

    /**
     *
     * @return turboOn
     */
    public boolean getTurboOn() {
        return turboOn;
    }

    /**
     * Checks if turboOn == true, modifies the double turbo accordingly.
     * @return the speedFactor for a Saab95 object.
     */
    @Override
    protected double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }

}