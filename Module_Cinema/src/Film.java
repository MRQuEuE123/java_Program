import java.util.Objects;

public class Film implements Comparable <Film>{
    FilmType filmType;
    String name;
    String registrationNumber;
    double weight;
    int year;
    String genre;
    Chroma chroma;

    public Film(FilmType filmType, String name, String registrationNumber, double weight, int year, String genre, Chroma chroma) {

        if(!TechnicalSpecialist.validateRegistrationNumber(registrationNumber)) return;
        if(!TechnicalSpecialist.validateFilmType(filmType)) return;
        if(!TechnicalSpecialist.validateColor(chroma))return;
        if(!TechnicalSpecialist.validateWeight(weight))return;
        if(!TechnicalSpecialist.validateManufactureYear(year))return;
        if(!TechnicalSpecialist.validateName(name))return;

        this.filmType = filmType;
        this.name = name;
        this.registrationNumber = registrationNumber;
        this.weight = weight;
        this.year = year;
        this.genre = genre;
        this.chroma = chroma;
    }

    public Film() {

    }

    public FilmType getFilmType() {
        return filmType;
    }

    public void setFilmType(FilmType filmType) {
        if(!TechnicalSpecialist.validateFilmType(filmType)) return;
        this.filmType = filmType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(!TechnicalSpecialist.validateName(name))return;
        this.name = name;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        if(!TechnicalSpecialist.validateRegistrationNumber(registrationNumber)) return;
        this.registrationNumber = registrationNumber;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        if(!TechnicalSpecialist.validateWeight(weight))return;
        this.weight = weight;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if(!TechnicalSpecialist.validateManufactureYear(year))return;
        this.year = year;
    }

    public String getGenre() {

        return genre;
    }

    public void setGenre(String genre) {
        if(!TechnicalSpecialist.validateName(genre))return;
        this.genre = genre;
    }

    public Chroma getChroma() {
        return chroma;
    }

    public void setChroma(Chroma chroma) {
        if(!TechnicalSpecialist.validateColor(chroma))return;
        this.chroma = chroma;
    }


    public  double getCalcTaxPerMonth(){
        return (weight *0.0013)
                +(filmType.getTaxCoefficient()*30)+5;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,\"%.2f\",\"%d\",\"%s\",%s,\"%.2f\"",
                filmType.getString(),          // строковое поле в кавычках
                name,               // строковое поле в кавычках
                registrationNumber, // числовое поле без кавычек
                weight,               // числовое с плавающей точкой
                year,               // целое число
                genre,              // строковое поле в кавычках
                chroma, // булево как строка
                getCalcTaxPerMonth()      // налог с двумя знаками после запятой
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Film film = (Film) o;
        return Objects.equals(filmType, film.filmType) &&
                Objects.equals(name, film.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(filmType, name);
    }
    @Override
    public int compareTo(Film other) {
        // Сравнение по году
        int yearCompare = Integer.compare(this.year, other.year);
        if (yearCompare != 0) {
            return yearCompare;
        }
        // Если годы равны, сравниваем по названию
        return this.name.compareTo(other.name);
    }

}
