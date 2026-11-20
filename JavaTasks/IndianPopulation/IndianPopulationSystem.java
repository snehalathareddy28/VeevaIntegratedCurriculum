package IndianPopulation;

import java.util.*;

public class IndianPopulationSystem {

    // State -> City -> Population
    static HashMap<String, HashMap<String, Integer>> stateCityData =
            new HashMap<>();

    // City -> Set of states (for global searching)
    static HashMap<String, Set<String>> cityIndex =
            new HashMap<>();

    // Normalize names to make searching case-insensitive
    static String normalize(String name) {
        return name.trim().toLowerCase();
    }

    // 1. Add a new state
    static void addState(String stateName) {

        String state = normalize(stateName);

        if (state.isEmpty()) {
            System.out.println("Invalid state name!");
            return;
        }

        if (stateCityData.containsKey(state)) {
            System.out.println("State already exists!");
            return;
        }

        stateCityData.put(state, new HashMap<>());

        System.out.println("State added successfully!");
    }

    // 2. Add a new city
    static void addCity(String stateName, String cityName, int population) {

        String state = normalize(stateName);
        String city = normalize(cityName);

        if (!stateCityData.containsKey(state)) {
            System.out.println("State does not exist!");
            return;
        }

        if (city.isEmpty() || population <= 0) {
            System.out.println("Invalid city name or population!");
            return;
        }

        HashMap<String, Integer> cities = stateCityData.get(state);

        if (cities.containsKey(city)) {
            System.out.println("City already exists! Use update operation.");
            return;
        }

        cities.put(city, population);

        cityIndex.putIfAbsent(city, new HashSet<>());
        cityIndex.get(city).add(state);

        System.out.println("City added successfully!");
    }

    // 3. Update city population
    static void updatePopulation(String stateName, String cityName,
                                 int newPopulation) {

        String state = normalize(stateName);
        String city = normalize(cityName);

        if (newPopulation <= 0) {
            System.out.println("Population must be positive!");
            return;
        }

        if (!stateCityData.containsKey(state)) {
            System.out.println("State not found!");
            return;
        }

        HashMap<String, Integer> cities = stateCityData.get(state);

        if (!cities.containsKey(city)) {
            System.out.println("City not found!");
            return;
        }

        cities.put(city, newPopulation);

        System.out.println("Population updated successfully!");
    }

    // 4. Query 1: Find city population using state and city
    static void findCityPopulation(String stateName, String cityName) {

        String state = normalize(stateName);
        String city = normalize(cityName);

        if (!stateCityData.containsKey(state)) {
            System.out.println("State not found!");
            return;
        }

        HashMap<String, Integer> cities = stateCityData.get(state);

        if (!cities.containsKey(city)) {
            System.out.println("City not found in this state!");
            return;
        }

        System.out.println("City: " + cityName);
        System.out.println("State: " + stateName);
        System.out.println("Population: " + cities.get(city));
    }

    // 5. Query 2: Display all cities and total population of a state
    static void displayStatePopulation(String stateName) {

        String state = normalize(stateName);

        if (!stateCityData.containsKey(state)) {
            System.out.println("State not found!");
            return;
        }

        HashMap<String, Integer> cities = stateCityData.get(state);

        long totalPopulation = 0;

        System.out.println("\nState: " + stateName);
        System.out.println("---------------------------");

        if (cities.isEmpty()) {
            System.out.println("No cities available!");
            return;
        }

        for (Map.Entry<String, Integer> entry : cities.entrySet()) {

            System.out.println(
                    entry.getKey() + " : " + entry.getValue()
            );

            totalPopulation += entry.getValue();
        }

        System.out.println("---------------------------");
        System.out.println("Total population: " + totalPopulation);
    }

    // 6. Query 3: Find cities exceeding population threshold
    static void filterCities(int threshold) {

        if (threshold < 0) {
            System.out.println("Invalid threshold!");
            return;
        }

        boolean found = false;

        System.out.println("\nCities above population " + threshold);
        System.out.println("---------------------------");

        for (Map.Entry<String, HashMap<String, Integer>> stateEntry
                : stateCityData.entrySet()) {

            String state = stateEntry.getKey();

            HashMap<String, Integer> cities = stateEntry.getValue();

            for (Map.Entry<String, Integer> cityEntry
                    : cities.entrySet()) {

                if (cityEntry.getValue() > threshold) {

                    System.out.println(
                            "City: " + cityEntry.getKey()
                                    + " | State: " + state
                                    + " | Population: " + cityEntry.getValue()
                    );

                    found = true;
                }
            }
        }

        if (!found) {
            System.out.println("No cities found above this threshold!");
        }
    }

    // 7. Query 4: Global city search
    static void searchCityGlobally(String cityName) {

        String city = normalize(cityName);

        if (!cityIndex.containsKey(city)) {
            System.out.println("City not found in India!");
            return;
        }

        Set<String> states = cityIndex.get(city);

        System.out.println("\nGlobal Search Result:");

        for (String state : states) {

            int population =
                    stateCityData.get(state).get(city);

            System.out.println(
                    "City: " + cityName
                            + " | State: " + state
                            + " | Population: " + population
            );
        }
    }

    // 8. Remove a city
    static void removeCity(String stateName, String cityName) {

        String state = normalize(stateName);
        String city = normalize(cityName);

        if (!stateCityData.containsKey(state)) {
            System.out.println("State not found!");
            return;
        }

        HashMap<String, Integer> cities = stateCityData.get(state);

        if (!cities.containsKey(city)) {
            System.out.println("City not found!");
            return;
        }

        cities.remove(city);

        cityIndex.get(city).remove(state);

        if (cityIndex.get(city).isEmpty()) {
            cityIndex.remove(city);
        }

        System.out.println("City removed successfully!");
    }

    // 9. Remove a state
    static void removeState(String stateName) {

        String state = normalize(stateName);

        if (!stateCityData.containsKey(state)) {
            System.out.println("State not found!");
            return;
        }

        HashMap<String, Integer> cities = stateCityData.get(state);

        // Remove state from global city index
        for (String city : cities.keySet()) {

            cityIndex.get(city).remove(state);

            if (cityIndex.get(city).isEmpty()) {
                cityIndex.remove(city);
            }
        }

        stateCityData.remove(state);

        System.out.println("State removed successfully!");
    }

    // 10. Find the most populated city in a state
    static void findHighestPopulationCity(String stateName) {

        String state = normalize(stateName);

        if (!stateCityData.containsKey(state)) {
            System.out.println("State not found!");
            return;
        }

        HashMap<String, Integer> cities = stateCityData.get(state);

        if (cities.isEmpty()) {
            System.out.println("No cities available!");
            return;
        }

        String highestCity = null;
        int highestPopulation = 0;

        for (Map.Entry<String, Integer> entry : cities.entrySet()) {

            if (entry.getValue() > highestPopulation) {

                highestPopulation = entry.getValue();
                highestCity = entry.getKey();
            }
        }

        System.out.println("Highest population city: " + highestCity);
        System.out.println("Population: " + highestPopulation);
    }

    // 11. Display all states and cities
    static void displayAllData() {

        if (stateCityData.isEmpty()) {
            System.out.println("No data available!");
            return;
        }

        for (Map.Entry<String, HashMap<String, Integer>> stateEntry
                : stateCityData.entrySet()) {

            System.out.println("\nState: " + stateEntry.getKey());

            for (Map.Entry<String, Integer> cityEntry
                    : stateEntry.getValue().entrySet()) {

                System.out.println(
                        cityEntry.getKey() + " : " + cityEntry.getValue()
                );
            }
        }
    }

    // 12. Main method
    public static void main(String[] args) {

        // Adding states
        addState("Andhra Pradesh");
        addState("Telangana");
        addState("Karnataka");
        addState("Tamil Nadu");

        // Adding cities
        addCity("Andhra Pradesh", "Visakhapatnam", 2035922);
        addCity("Andhra Pradesh", "Vijayawada", 1034358);
        addCity("Andhra Pradesh", "Guntur", 647508);

        addCity("Telangana", "Hyderabad", 6809970);
        addCity("Telangana", "Warangal", 704570);

        addCity("Karnataka", "Bengaluru", 8443675);
        addCity("Karnataka", "Mysuru", 893062);

        addCity("Tamil Nadu", "Chennai", 4646732);
        addCity("Tamil Nadu", "Coimbatore", 1061447);

        // Query 1
        System.out.println("\n===== QUERY 1: CITY LOOKUP =====");
        findCityPopulation("Andhra Pradesh", "Guntur");

        // Query 2
        System.out.println("\n===== QUERY 2: STATE AGGREGATION =====");
        displayStatePopulation("Andhra Pradesh");

        // Query 3
        System.out.println("\n===== QUERY 3: THRESHOLD FILTER =====");
        filterCities(1000000);

        // Query 4
        System.out.println("\n===== QUERY 4: GLOBAL SEARCH =====");
        searchCityGlobally("Hyderabad");

        // Update population
        System.out.println("\n===== UPDATE POPULATION =====");
        updatePopulation("Andhra Pradesh", "Guntur", 700000);

        findCityPopulation("Andhra Pradesh", "Guntur");

        // Highest population city
        System.out.println("\n===== HIGHEST POPULATION CITY =====");
        findHighestPopulationCity("Karnataka");

        // Remove city
        System.out.println("\n===== REMOVE CITY =====");
        removeCity("Telangana", "Warangal");

        // Remove state
        System.out.println("\n===== REMOVE STATE =====");
        removeState("Tamil Nadu");

        // Display final data
        System.out.println("\n===== FINAL DATA =====");
        displayAllData();
    }
}
