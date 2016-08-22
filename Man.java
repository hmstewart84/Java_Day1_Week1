public class Man{
  private String name;
  private Beer[] belly;
  private Hamburger[] plate;

  public Man(String name){
    this.name = name;
    this.belly = new Beer[20]; //populated with 20 null entries
    this.plate = new Hamburger[2]; // populated with 2 null entries
  }
  public String getName(){
    return this.name;
  }

  public int beerCount() {
    int counter = 0;        //make a counter = 0

    for(Beer beer : belly) {        //iterate over salmon array
      if (beer != null) {           //check if it's not null 
        counter++;                  //=> add one to counter
      }
    }
    return counter;               //return the counter
  }

  public int hamburgerCount() {
    int counter = 0;

    for(Hamburger hamburger : plate) {
      if (hamburger != null) {
        counter++;
      }
    }
    return counter;
  }

  public void drink(Beer beer) {  //add drink method
    if(bellyFull() ) return;
    int beerCount = beerCount();  // keep count everytime we add beer
    belly[beerCount] = beer;
  }

  public void eat(Hamburger hamburger) {
    if(plateFull() ) return;
    int hamburgerCount = hamburgerCount();
    plate[hamburgerCount] = hamburger;
  }

  public boolean bellyFull() {
    return beerCount() == belly.length;
  }

  public boolean plateFull() {
    return hamburgerCount() == plate.length;
  }

  public void sleep() {
    for(int i = 0; i < belly.length; i++) {
      belly[i] = null;
    } 
  }
  
}
