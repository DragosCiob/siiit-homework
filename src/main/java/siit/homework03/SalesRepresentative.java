package siit.homework03;

public class SalesRepresentative {
    private  int  NoOfSales;
    private  int QoutaPerSale;

    //constructor
    public SalesRepresentative(int NoOfSales, int QuotaPerSale) {
        this.NoOfSales=NoOfSales;
        this.QoutaPerSale=QuotaPerSale;
    }



    public int getNoOfSales(){
        return NoOfSales;
    }


    public int getQuotaPerSale(){
        return QoutaPerSale;
    }

    public int getValue() {
        return getNoOfSales() * getQuotaPerSale();
    }

    @Override
    public String toString() {
        return Integer.toString(this.getValue());
    }


}
