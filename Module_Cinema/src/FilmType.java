public class FilmType {
    String typeName;
    double taxCoefficient;

    FilmType(String typeName, double taxCoefficient) {
        this.typeName = typeName;
        this.taxCoefficient = taxCoefficient;
    }
    FilmType(){
        this.typeName ="Film8";
        this.taxCoefficient =1.2;
    }

    public String getTypeName(){
        return typeName;
    }
    public void setTypeName(String typeName){
        this.typeName = typeName;
    }

    public double getTaxCoefficient(){
        return taxCoefficient;
    }
    public void setTaxCoefficient(double taxCoefficient){
        this.taxCoefficient = taxCoefficient;
    }

    public String getString(){
        return typeName+";"+ '"'+taxCoefficient+'"';
    }
    public void display(){
        System.out.println("typeName = "+typeName +"\ntaxCoefficient = "+taxCoefficient);
    }
    @Override
    public String toString() {
        return String.format("%s,\"%2f\"", typeName, taxCoefficient);
    }
}
