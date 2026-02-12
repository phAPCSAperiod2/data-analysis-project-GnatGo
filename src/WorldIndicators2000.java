/**
 * Represents one row from your dataset.
 *
 * TODO:
 *  - Rename the class to match your dataset (e.g., Pokemon, StateData, CountryStat)
 *  - Add at least 3 private attributes based on your CSV columns
 *  - Write a constructor that initializes all attributes
 *  - Add getter methods for the attributes you need in your analysis
 *  - Override toString() to display the object's data
 *  - Add Javadoc comments for the class and all methods
 */
public class WorldIndicators2000 {

    // TODO: Add at least 3 private attributes
    // Example:
    // private String name;
    // private int population;
    // private double value;
    private String countryName;
    private double infantMortalityRate;
    private int co2Emissions;


    // TODO: Create a constructor that takes all attributes as parameters
    public WorldIndicators2000(String newCountryName, double newInfantMortalityRate, int newCo2Emissions) {
        this.countryName = newCountryName;
        this.infantMortalityRate = newInfantMortalityRate;
        this.co2Emissions = newCo2Emissions;
    }


    // TODO: Add getters for attributes you need
    public String getCountryName() {
        return this.countryName;
    }

    public double getInfantMortalityRate() {
        return this.infantMortalityRate;
    }

    public int getCo2Emissions() {
        return this.co2Emissions;
    }

    // TODO: Add other data analysis methods
    public static double averageInfantMortalityOfHigh(WorldIndicators2000[] dataList) {
        int emissionsLimit = 100000;
        int numCountries = 0;
        double totalInfantMortality = 0.0;
        for (int i = 0; i < dataList.length; i++) {
            if (dataList[i].getCo2Emissions() >= emissionsLimit) {
                numCountries++;
                totalInfantMortality += dataList[i].getInfantMortalityRate();
            }
        }
        return totalInfantMortality / numCountries;
    }

    public static double averageInfantMortalityOfLow(WorldIndicators2000[] dataList) {
        int emissionsLimit = 100000;
        int numCountries = 0;
        double totalInfantMortality = 0.0;
        for (int i = 0; i < dataList.length; i++) {
            if (dataList[i].getCo2Emissions() < emissionsLimit) {
                numCountries++;
                totalInfantMortality += dataList[i].getInfantMortalityRate();
            }
        }
        return totalInfantMortality / numCountries;
    }

    public static double compareAverages(double highAverage, double lowAverage) {
        if (highAverage > lowAverage) {
            return highAverage - lowAverage;
        } 
        
        else {
            return lowAverage - highAverage;
        }
    }

    
    // TODO: Override toString() to return a readable representation of your object
    @Override
    public String toString() {
        return "Country: " + this.countryName + ", Infant Mortality Rate: " + this.infantMortalityRate + ", CO2 Emissions: " + this.co2Emissions;
    }

}