import java.io.File;

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

    public static void main(String[] args) {

        // TODO: Update this with your CSV file path
        File file = new File("WorldIndicators2000.csv");

        // TODO: Create an array of Data objects to store data
        String[] dataList = new String[2704];


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
            int lifeExpectancy = Integer.parseInt(data[2]);
            int co2Emissions = Integer.parseInt(data[4]);
            // - Create new Data objects
            WorldIndicators2000 dataObject = new WorldIndicators2000(countryName, infantMortalityRate, lifeExpectancy, co2Emissions);
            dataList[index] = dataObject.toString();
            index++;
        }
        // - Add to your array


        // TODO: Call your analysis methods
        // Example:
        // double maxValue = findMaxValue(dataList);
        // double average = computeAverageValue(dataList);


        // TODO: Print insights
        // - Number of rows loaded
        // - Min, max, average, or any other findings
        // - Final answer to your guiding question


        // OPTIONAL TODO:
        // Add user interaction:
        // Ask the user what kind of analysis they want to see
    }


}