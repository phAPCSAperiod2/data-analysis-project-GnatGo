import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Main application for the Data Analysis Mini‑Project.
 *
 * TODO:
 *  - Update the path to your dataset file
 *  - Read the CSV file using Scanner
 *  - Parse each row and extract the correct columns
 *  - Construct Data objects from each row
 *  - Store them in an array
 *  - Write methods to analyze the dataset (min, max, average, filters, etc.)
 *  - Print insights and answer your guiding question
 *  - Add Javadoc comments for any methods you create
 */
public class App {

    public static void main(String[] args) throws IOException {
        System.out.println("Guiding Question: Do countries with higher CO2 emissions have higher infant mortality rates?");

        // TODO: Update this with your CSV file path
        File file = new File("data/WorldIndicators2000.csv");

        // TODO: Create an array of Data objects to store data
        WorldIndicators2000[] dataList = new WorldIndicators2000[2704];


        // TODO: Read file using Scanner
        Scanner input = new Scanner(file);
        // - Skip header if needed
        input.nextLine();
        // - Loop through rows
        int index = 0;
        while (input.hasNextLine()) {
            String line = input.nextLine();
            String[] data = line.split(",");
            // - Split each line by commas
            // - Convert text to numbers when needed
            String countryName = data[0];
            double infantMortalityRate = Double.parseDouble(data[12]);
            int co2Emissions = Integer.parseInt(data[4]);
            // - Create new Data objects
            WorldIndicators2000 dataObject = new WorldIndicators2000(countryName, infantMortalityRate, co2Emissions);
            dataList[index] = dataObject;
            index++;
        }
        input.close();
        // - Add to your array


        // TODO: Call your analysis methods
        // Example:
        // double maxValue = findMaxValue(dataList);
        // double average = computeAverageValue(dataList);
        double averageHigh = WorldIndicators2000.averageInfantMortalityOfHigh(dataList);
        double averageLow = WorldIndicators2000.averageInfantMortalityOfLow(dataList);
        double difference = WorldIndicators2000.compareAverages(averageHigh, averageLow);



        // TODO: Print insights
        // - Number of rows loaded
        // - Min, max, average, or any other findings
        // - Final answer to your guiding question
        System.out.println("Number of rows loaded: " + index);
        System.out.println("Average infant mortality rate for high CO2 emissions: " + averageHigh);
        System.out.println("Average infant mortality rate for low CO2 emissions: " + averageLow);
        System.out.println("Difference between averages: " + difference);
        if (averageHigh > averageLow) {
            System.out.println("Final Answer: Countries with higher CO2 emissions tend to have higher infant mortality rates.");
        } else if (averageLow > averageHigh) {
            System.out.println("Final Answer: Countries with lower CO2 emissions tend to have higher infant mortality rates.");
        } else {
            System.out.println("Final Answer: There is no difference in infant mortality rates between high and low CO2 emission countries.");
        }


        // OPTIONAL TODO:
        // Add user interaction:
        // Ask the user what kind of analysis they want to see
    }


}