package Rooms;

public class Restaurant extends Room {

    protected int tablesBooked;
    protected String currentMenu;

    public Restaurant(int capacity, String currentMenu) {
        super(capacity);
        this.tablesBooked = 0;
        this.currentMenu = currentMenu;
    }

    public String getCurrentMenu() {
        return currentMenu;
    }

    public void setMenu(String menu) {
        this.currentMenu = menu;
    }

    public int getTablesBooked() {
        return tablesBooked;
    }

    public void setTablesBooked(int tablesBooked) {
        this.tablesBooked += tablesBooked;
    }

    public void cancelTablesBooked(int tablesBooked) {
        this.tablesBooked -= tablesBooked;
    }
}
