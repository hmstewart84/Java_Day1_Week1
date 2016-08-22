import static org.junit.Assert.assertEquals;
import org.junit.*;

public class ManTest{
  Man man;
  Beer beer;  //this is the declaration of this class
  Hamburger hamburger;

  @Before 
  public void before() {
    man = new Man("Robbie");  //this is where we're instantiating the class
    beer = new Beer();
    hamburger = new Hamburger();
  }

  @Test
  public void hasName(){
    assertEquals( "Robbie", man.getName() ); 
  }

  @Test
  public void bellyStartsEmpty() {
    assertEquals(0, man.beerCount() );
  }

  @Test
  public void plateStartsEmpty() {
    assertEquals(0, man.hamburgerCount() );
  }

  @Test
  public void canDrinkBeer() {
    man.drink(beer);
    assertEquals(1, man.beerCount() );
  }

  @Test
  public void canEatHamburger() {
    man.eat(hamburger);
    assertEquals(1, man.hamburgerCount() );
  }

  @Test
  public void cannotDrinkBeerWhenBellyFull() {
    for(int i = 0; i < 21; i++) {
      man.drink(beer);
    }
    assertEquals(20, man.beerCount() );
  }

  @Test
  public void cannotEatHamburgerWhenPlateFull() {
    for(int i = 0; i < 3; i++) {
      man.eat(hamburger);
    }
    assertEquals(2, man.hamburgerCount() );
  }

  @Test
  public void bellyIsFull() {
    for(int i = 0; i < 20; i++) {
      man.drink(beer);
    } 
    assertEquals(true, man.bellyFull() );
  }

  @Test
  public void plateIsFull() {
    for(int i = 0; i < 2; i++) {
      man.eat(hamburger);
    }
    assertEquals(true, man.plateFull() );
  }

  @Test
  public void bellyIsNotFull() {
    for(int i = 0; i < 19; i ++) {
      man.drink(beer);
    }
    assertEquals(false, man.bellyFull() );
  }

  @Test
  public void plateIsNotFull() {
    for(int i = 0; i < 1; i++) {
      man.eat(hamburger);
    }
    assertEquals(false, man.plateFull() );
  }

  @Test
  public void shouldEmptyBellyAfterSleeping() {
    man.drink(beer);
    assertEquals(1, man.beerCount() );
    man.sleep();
    assertEquals(0, man.beerCount() );
  }

}