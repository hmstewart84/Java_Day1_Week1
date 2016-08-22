import static org.junit.Assert.assertEquals;
import org.junit.*;

public class ManTest{
  Man man;
  Beer beer;  //this is the declaration of this class

  @Before 
  public void before() {
    man = new Man("Robbie");  //this is where we're instantiating the class
    beer = new Beer();
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
  public void canDrinkBeer() {
    man.drink(beer);
    assertEquals(1, man.beerCount() );
  }

  @Test
  public void cannotDrinkBeerWhenBellyFull() {
    for(int i = 0; i < 21; i++) {
      man.drink(beer);
    }
    assertEquals(20, man.beerCount() );

  }

  @Test
  public void bellyIsFull() {
    for(int i = 0; i < 20; i++) {
      man.drink(beer);
    } 
    assertEquals(true, man.bellyFull() );
  }

  @Test
  public void bellyIsNotFull() {
    for(int i = 0; i < 19; i ++) {
      man.drink(beer);
    }
    assertEquals(false, man.bellyFull() );
  }

  @Test
  public void shouldEmptyBellyAfterSleeping() {
    man.drink(beer);
    assertEquals(1, man.beerCount() );
    man.sleep();
    assertEquals(0, man.beerCount() );
  }

}