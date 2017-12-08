import org.junit.Before;
import Guest.Guest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GuestTest {

    Guest guest1;

    @Before
    public void before() {
        guest1 = new Guest("Lacey", 200.0);
    }

    @Test
    public void canGetName() {
        assertEquals("Lacey", guest1.getName());
    }

    @Test
    public void canSetName() {
        guest1.setName("Jenny");
        assertEquals("Jenny", guest1.getName());
    }

    @Test
    public void canGetWallet() {
        assertEquals(200.0, guest1.getWallet(), 0.1);
    }

    @Test
    public void canSetWallet() {
        guest1.setWallet(300.0);
        assertEquals(300.0, guest1.getWallet(), 0.1);
    }

    @Test
    public void canGetCheckedInStatus() {
        assertEquals(false, guest1.getCheckedInStatus());
    }

    @Test
    public void canSetCheckedInStatus() {
        guest1.setCheckedInStatus(true);
        assertEquals(true, guest1.getCheckedInStatus());

    }


}
