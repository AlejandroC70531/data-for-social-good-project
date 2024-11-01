/*
 * ArrayList imported for use in later methods
 */
import java.util.ArrayList;
/* 
 * Creates a class to represent the scenario and some methods to solve the problem
 */
public class UserStory {

private Superfood[] foods; // An array of superfoods and their assorted information

/*
 * Initializes the files that will be used to provide the information for each food element
 */

public UserStory(String namesFile, String benefitsFile, String proteinFile, String fiberFile, String vitaminCFile, String antioxidantsFile){
  foods = createFoods(namesFile, benefitsFile, proteinFile, fiberFile, vitaminCFile, antioxidantsFile);
}
/*
 * Turns the files into the data that will be used, then starts creating the elements
 * in the Superfood.java class
 */
  public Superfood[] createFoods(String namesFile, String benefitsFile, String proteinFile, String fiberFile, String vitaminCFile, String antioxidantsFile) {
    String[] namesData = FileReader.toStringArray(namesFile);
    String[] benefitsData = FileReader.toStringArray(benefitsFile);
    double[] proteinData = FileReader.toDoubleArray(proteinFile);
    double[] fiberData = FileReader.toDoubleArray(fiberFile);
    double[] vitaminCData = FileReader.toDoubleArray(vitaminCFile);
    int[] antioxidantData = FileReader.toIntArray(antioxidantsFile);
    Superfood[] newFoods = new Superfood[namesData.length];

    for (int i = 0; i < newFoods.length; i++) {
      newFoods[i] = new Superfood(namesData[i], benefitsData[i], proteinData[i], fiberData[i], vitaminCData[i], antioxidantData[i]);
    }
    return newFoods;
  }
  /*
   * Returns a certain food element given its index
   */
    public Superfood getFood(int position) {
    return foods[position];
  }
  
/*
 * Returns all foods that have similar benefits to those of a chosen food
 * by first finding the index the food is located and its respective benefits
 * then searches for matches in the benefits and returns those respective foods
 */
public String findDuplicateBenefits(String chosenFood){
  int chosenI = 0;
  String chosenBenefit = "";
  boolean foundFood = false;
  int similarityCounter = 0;
  // Finds if the food exists in the foods array
  for (int i = 0; i < foods.length; i++){
    if (foods[i].getName().equals(chosenFood)){
      chosenI = i;
      foundFood = true;
   }
  }
  // Returns an error message signaling that the chosen food isn't on the list
   if (foundFood == false){
     return "Sorry, the food you requested can't be found";
   }
  // Creates the variable to be returned detailing the chosen food, benefit(s), and similar foods
  String similarFoods = chosenFood + " has benefits including: " + foods[chosenI].getBenefits() + ", which are similar to those of \n";
  /*
   * Finds foods with similar benefits
   */
  for(int index = 0; index < foods.length; index++){
    if(foods[index].getName().equals(foods[chosenI].getName())){
        index++;
      }
    if (foods[index].getBenefits().equals(foods[chosenI].getBenefits())){
      similarFoods = similarFoods + foods[index].getName() + "\n";
      similarityCounter = similarityCounter + 1;
  }
}
  /*
   * If no similar benefits are found, the return statement ends with the following String
   */
  if (similarityCounter == 0){
    similarFoods = similarFoods + "nothing else here.";
  }
  // Returns the report of the similar foods
   return similarFoods;
 }
  
/*
 * Multiplies the nutrition values for a chosen food by a specifided # of servings
 * and returns the new values for the amount of servings
 */
  public String nutritionValuesInMultipleServings(String chosenFood, int numServings){
   int chosenI = 0;
   int tempCalories = 0;
   double tempProtein = 0.0;
   double tempFiber = 0.0;
   double tempVitaminC = 0.0;
   int tempAntioxidants = 0;
    for (int i = 0; i < foods.length; i++){
    if (foods[i].getName().equals(chosenFood)){
      chosenI = i;
   }  
  }
    tempProtein = foods[chosenI].getProtein() * numServings;
    tempFiber = foods[chosenI].getFiber() * numServings;
    tempVitaminC = foods[chosenI].getVitaminC() * numServings;
    tempAntioxidants = foods[chosenI].getAntioxidantScore() * numServings;
    return "The nutritional value for " + chosenFood + " after " + numServings + " servings: \n" + tempProtein + " grams of protein, \n" + tempFiber + " grams of fiber, \n" + tempVitaminC + " milligrams of Vitamin C, and \n" + tempAntioxidants + " antioxidants.";
 }
 /*
  * Given the array of foods, it finds the most overall beneficial foods using
  * metrics comparing the nutrition values in one serving to the optimal amount per meal
  * and stores those applicable in an array list, which is then traversed to find and
  * add those that were added multiple times to the final list, which is then returned
  */
  public ArrayList<String> findHealthiestFoods(){
    ArrayList<Superfood> tempHealthiestFoods = new ArrayList<Superfood>();    
    int indexCounter = 0;
    for (int i = 0; i < foods.length; i++){
     if(foods[i].getProtein() >= 5.0 && foods[i].getProtein() <= 10.0){
       tempHealthiestFoods.add(indexCounter, foods[i]);
       indexCounter = indexCounter + 1;
     }
     if (foods[i].getFiber() >= 8.0 && foods[i].getFiber() <= 10.0){
       tempHealthiestFoods.add(indexCounter, foods[i]);
       indexCounter = indexCounter + 1;
     }
     if (foods[i].getVitaminC() >= 25.0 && foods[i].getVitaminC() <= 40.0){
       tempHealthiestFoods.add(indexCounter, foods[i]);
       indexCounter = indexCounter + 1;
     }
     if (foods[i].getAntioxidantScore() >= 2700 && foods[i].getAntioxidantScore() <= 3700){
       tempHealthiestFoods.add(indexCounter, foods[i]);
       indexCounter = indexCounter + 1;
     }
    }
    ArrayList<Superfood> healthiestFoods = new ArrayList<Superfood>();    
    for(int i = 0; i < tempHealthiestFoods.size(); i++){
      for(int index = 1; index < tempHealthiestFoods.size(); index++){
      if(tempHealthiestFoods.get(i).getName() == null){
        tempHealthiestFoods.remove(i);
      }
      if(tempHealthiestFoods.get(i).getName() == tempHealthiestFoods.get(index).getName()){
        healthiestFoods.add(tempHealthiestFoods.get(i));
        tempHealthiestFoods.remove(index);
      }
     }
    }
    ArrayList<String> resultList = new ArrayList<String>();
    for (int i = 0; i < healthiestFoods.size(); i++) {
      resultList.add(healthiestFoods.get(i).getName());
    }
    
    return resultList;   
   }
/*
 * A toString method returning all of the elements' names, benefit(s), and nutritional values
 */
    public String toString() {
    String result = "";

    for (Superfood food : foods) {
      result += food + "\n----------\n";
    }

    return result;
  }
}
