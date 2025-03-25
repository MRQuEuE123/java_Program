public class Film16Mm extends AbstractFilmType{
    double projectionSpeed;
    double capacity;

    public Film16Mm(double projectionSpeed, double capacity) {
        super("16 mm", 0.2);
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
