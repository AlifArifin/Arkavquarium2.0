import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

  Account a = new Account();

  @Test
  void addMoney() {
    a.addMoney(10);
    assertTrue(a.getMoney()==20010);
  }

  @Test
  void moneyEnough() {
    a.setMoney(2000);
    int value = 3000;
    assertTrue(!a.moneyEnough(3000));
  }

  @Test
  void buyGuppy() {
    a.setMoney(500);
    a.buyGuppy();
    assertTrue(a.getMoney() == 500 - Guppy.getValueGuppy());
  }

  @Test
  void buyPiranha() {
    a.setMoney(500);
    a.buyPiranha();
    assertTrue(a.getMoney() == 500 - Piranha.getValuePiranha());
  }

  @Test
  void buyFood() {
    a.setMoney(500);
    a.buyFood();
    assertTrue(a.getMoney() == 500 - Food.getValueFood());
  }

  @Test
  void buyEgg() {
    a.setMoney(1500);
    a.buyEgg();
    assertTrue(a.getMoney() == 1500 - Account.getValueEgg());
  }
}