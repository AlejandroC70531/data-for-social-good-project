/*
 * Creates a class representing each element in the foods array in UserStory.java
 */
public class Superfood{
 /* 
  * Instance variables representing each data file to be used to create food elements
  */
  private String name;
  private String benefits;
  private double gramsOfProtein;
  private double gramsOfFiber;
  private double milligramsOfVitaminC;
  private int antioxidantScore;
/*
 * A no-argument constructor for a food element with no data
 */
  public Superfood(){
    name = "";
    benefits = "";
    gramsOfProtein = 0.0;
    gramsOfFiber = 0.0;
    milligramsOfVitaminC = 0.0;
    antioxidantScore = 0;
  }
/*
 * A parameterized constructor to create food elements using their given data
 */
  public Superfood(String name, String benefits, double gramsOfProtein, double gramsOfFiber, double milligramsOfVitaminC, int antioxidantScore){
  this.name = name;
  this.benefits = benefits;
  this.gramsOfProtein = gramsOfProtein;
  this.gramsOfFiber = gramsOfFiber;
  this.milligramsOfVitaminC = milligramsOfVitaminC;
  this.antioxidantScore = antioxidantScore;
 }
/*
 * Accessor methods used to access certain data for each food element
 */
  public String getName(){
    return name;
  }
  
  public String getBenefits(){
    return benefits;
  }

  public double getProtein(){
    return gramsOfProtein;
  }

  public double getFiber(){
    return gramsOfFiber;
  }

  public double getVitaminC(){
    return milligramsOfVitaminC;
  }
  
  public int getAntioxidantScore(){
    return antioxidantScore;
  }
/*
 * A toString() method that returns the name, benefit(s), and nutritional values for a certain food element
 */
  public String toString(){
    return name + " includes benefits like " + benefits + " and it has \n" + gramsOfProtein + " grams of protein, \n" + gramsOfFiber + " grams of fiber, \n" + milligramsOfVitaminC + " milligrams of Vitamin C, and \n" + antioxidantScore + " antioxidants.\n";
  }
}
