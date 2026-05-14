package designPatterns.strategy;

public class Main {
    public static void main(String[] args) {
        MeniuRestaurant restaurant = new MeniuRestaurant();
        restaurant.adaugaOferta(new OfertaMeniu("Salata", 150, 10));
        restaurant.adaugaOferta(new OfertaMeniu("Burger", 800, 50));
        restaurant.adaugaOferta(new OfertaMeniu("Piept Pui cu Legume", 300, 5));

        // Client 1 vrea putine calorii (ar trebui sa returneze Salata - 150 cal)
        restaurant.setStrategieAlegere(new StrategieCaloriiMinim());
        OfertaMeniu recomandare1 = restaurant.obtineMeniuIdeal();
        System.out.println("Recomandare calorii minim: " + recomandare1.getDenumireMeniu());

        // Client 2 vrea putini carbohidrati (ar trebui sa returneze Pui cu Legume - 5 carb)
        restaurant.setStrategieAlegere(new StrategieCarbohidratiMinim());
        OfertaMeniu recomandare2 = restaurant.obtineMeniuIdeal();
        System.out.println("Recomandare carbohidrati minim: " + recomandare2.getDenumireMeniu());
    }
}
