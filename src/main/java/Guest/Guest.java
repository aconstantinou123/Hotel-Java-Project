package Guest;

public class Guest {

    protected String name;
    private Double wallet;
    protected boolean checkedIn;


    public Guest(String name, Double wallet) {
        this.name = name;
        this.wallet = wallet;
        checkedIn = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getWallet() {
        return wallet;
    }

    public void setWallet(double wallet) {
        this.wallet = wallet;
    }

    public boolean getCheckedInStatus() {
        return checkedIn;
    }

    public void setCheckedInStatus() {
        this.checkedIn = true;
    }
}
