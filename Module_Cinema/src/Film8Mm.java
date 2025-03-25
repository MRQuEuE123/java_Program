public class Film8Mm extends AbstractFilmType {
    double projectionSpeed;
    double capacity;

    public Film8Mm(double projectionSpeed, double capacity) {
        super("8 mm", 0.1);
        this.projectionSpeed = projectionSpeed;
        this.capacity = capacity;
    }

    public double getProjectionSpeed() {
        return projectionSpeed;
    }

    public void setProjectionSpeed(double projectionSpeed) {
        if(!TechnicalSpecialist.validatePositivity(projectionSpeed))
            return;
        this.projectionSpeed = projectionSpeed;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        if(!TechnicalSpecialist.validatePositivity(capacity)) return;
        this.capacity = capacity;
    }


}
