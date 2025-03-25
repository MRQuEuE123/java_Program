public abstract class  AbstractFilmType implements Startable{
    String typeName;
    double taxCoefficient;

    AbstractFilmType(String typeName, double taxCoefficient) {
        this.typeName = typeName;
        this.taxCoefficient = taxCoefficient;
    }
    AbstractFilmType(){
        this.typeName ="Film8";
        this.taxCoefficient =1.2;
    }
    @Override
    public String toString() {
        return String.format("%s,\"%2f\"", typeName, taxCoefficient);
    }

    public String getTypeName(){
        return typeName;
    }
    public void setTypeName(String typeName){
        this.typeName = typeName;
    }


    @Override
    public  double getTaxPerMonth(){
        return taxCoefficient*30;
    }
    public double getTaxCoefficient(){
        return taxCoefficient;
    }
    public void setTaxCoefficient(double taxCoefficient){
        this.taxCoefficient = taxCoefficient;
    }

}
