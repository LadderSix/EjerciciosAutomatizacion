package JavaExercises;

public class IMBDApp {
    public static void main(String[] args) {
        String actorsName = "Tom Cruise";
        int yearOfBorn = 1962;
        int age = 2020- yearOfBorn;

        String[] movieTitles = {
                "The Last Samurai", "Minority Report","Top Gun", "Rain Man","Cocktail","The Mummy","American Made"
        };

        float[] movieRatings = {
            7.7F, 7.6F, 6.9F, 8.0F, 5.9F, 5.4F, 7.1F
        };

        System.out.println("Actor's Name: " + actorsName);
        System.out.println("Born: "+ yearOfBorn + "(" + age + "years old)");

        System.out.println("Movies: ");

        for (int i=0; i < movieTitles.length; i++){
            System.out.println(movieTitles[i] + " - "+ getRatings(movieRatings[i]));
        }

    }

    static String getRatings(float rating){

        if (rating <= 5.0){
            return "bad";
        } else if (rating >5.0 && rating <= 6.5){
            return "average";
        } else if (rating >6.5 && rating <= 7.0){
            return "good";
        } else if (rating >7.0 && rating <= 8.0){
            return  "very good";
        }else{
            return "Amazing";
        }
    }
}
