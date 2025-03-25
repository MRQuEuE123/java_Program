
public class TechnicalSpecialist {
    public static final int LOWER_LIMIT_MANUFACTURE_YEAR = 1886;

    static public boolean validateManufactureYear(int year) {
        return LOWER_LIMIT_MANUFACTURE_YEAR >=year && year<100000 ;
    }

    static public boolean validateWeight(double weight) {
        return weight >=0;
    }

    static public boolean validateColor(Chroma color) {
        return color != null;
    }

    static public boolean validateFilmType(FilmType type) {
        return type.typeName !=null && type.taxCoefficient >0;
    }

    static public boolean validateRegistrationNumber(String number) {
        return number !=null &&  number.matches("\\d{4}");
    }
    static public boolean validateName(String name){
        return name !=null;
    }
    static public boolean validatePositivity(double value){
        return value >=0;
    }

}