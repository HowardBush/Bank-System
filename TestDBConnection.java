/**
 * Created by damia_000 on 07.06.2016.
 */
import junit.framework.*;
import org.junit.Test;

public class TestDBConnection extends TestCase {
    DBConnection dbc = new DBConnection();
    private String Adres = "test";
    private String Pesel = "test";
    private String Surname = "test";
    private String Name = "test@test";

    /*TestDBConnection(DBConnection dbc)
    {
        this.dbc = dbc;
    }*/

    protected void setUp()
    {

    }
    public void testAdd()
    {

    }
    @Test
    public void testAddUser()
    {
        dbc.add(Name,Surname,Pesel,Adres);
        String result = dbc.getUserByPesel(Pesel);
        assertEquals((dbc.getLastID() + " " + Name + " " + Surname + " " + Pesel + " " + Adres + " " + 0), result);
    }
    @Test
    public void testSetCash()
    {
        dbc.setCashByPesel(9,Pesel);
        String result = dbc.getUserByPesel(Pesel);
        assertEquals(9, (Integer.parseInt(result.charAt(result.length() - 1)+"")));
    }
    @Test
    public void testRemoveUser()
    {
        dbc.removeByPesel(Pesel);
        String result = dbc.getUserByPesel(Pesel);
        assertNull(result);
    }
    @Test
    public void testGetCon()
    {
        assertNotNull(dbc.getConn());
    }

}
