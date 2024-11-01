public class DataRunner {
  public static void main(String[] args) {
// Creates the object with the respective text files to create the food elements  
UserStory dietician = new UserStory("names.txt", "benefits.txt", "protein(g).txt", "fiber(g).txt", "vitaminc(mg).txt", "antioxidants.txt");
/*
 * Test cases for each method
 */
    System.out.println(dietician.findDuplicateBenefits("Natto"));
    System.out.println(dietician.findDuplicateBenefits("Red Bell Peppers"));
    System.out.println(dietician.findDuplicateBenefits("Big Mac"));
    System.out.println(dietician.nutritionValuesInMultipleServings("Tempeh", 7));
    System.out.println(dietician.nutritionValuesInMultipleServings("Natto", 5));
    System.out.println(dietician.findHealthiestFoods());
    System.out.print(dietician.toString());
  }
}
