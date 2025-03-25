import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        FilmType[] filmTypes = {
                new FilmType(),
                new FilmType("Film16",1),
                new FilmType("Film32",1.5)
        };
        double maxTaxCoef=-100;
        double sumTaxCoef = 0;
        filmTypes[filmTypes.length - 1].taxCoefficient=1.3;
        for(FilmType filmType: filmTypes){
            filmType.display();
            double tax=filmType.getTaxCoefficient();
            if(maxTaxCoef<tax)maxTaxCoef=tax;
            sumTaxCoef+=tax;
        }

        System.out.println("Максимальный коефициент "+maxTaxCoef);
        System.out.println("AVG всех  коефициентов  "+sumTaxCoef/filmTypes.length);

        Film[] films = {
                // type, name, registrationNumber, mass (weight), year, genre, chroma
                new Film(filmTypes[0], "Бэтмен", "1111", 2022, 2015, "Боевик", Chroma.Color),
                new Film(filmTypes[0], "Супермен возвращается", "87812", 2500, 2014, "Боевик", Chroma.Color),
                new Film(filmTypes[0], "Пираты силиконовой долины", "4356", 12080, 2019, "Драма", Chroma.Color),
                new Film(filmTypes[1], "Гадкий я", "2866", 1200, 2006, "Мультфильм", Chroma.BW),
                new Film(filmTypes[1], "Армагеддон", "8876", 2200, 2019, "Боевик", Chroma.Color),
                new Film(filmTypes[2], "Полицейская академия", "4544", 3000, 2016, "Комедия", Chroma.BW),
                new Film(filmTypes[2], "Ограбление казино", "9087", 1200, 2020, "Боевик", Chroma.Color)
        };

        for(Film f : films){
            System.out.println(f);
        }
        bubbleSort(films);
        System.out.println();
        for(Film f : films){
            System.out.println(f);
        }
    }

    // Реализация сортировки пузырьком
    public static void bubbleSort(Film[] films) {
        int n = films.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (films[j].compareTo(films[j + 1]) > 0) {
                    // Меняем элементы местами
                    Film temp = films[j];
                    films[j] = films[j + 1];
                    films[j + 1] = temp;
                }
            }
        }
    }
}