package siit.homework03;

public class SalesRepresentativeSorting {

    private SalesRepresentative[] representatives;

    public SalesRepresentativeSorting() {

        representatives = new SalesRepresentative[6];
        representatives[0] = new SalesRepresentative(5, 100);
        representatives[1] = new SalesRepresentative(17, 20);
        representatives[2] = new SalesRepresentative(11, 35);
        representatives[3] = new SalesRepresentative(4, 220);
        representatives[4] = new SalesRepresentative(6, 120);
        representatives[5] = new SalesRepresentative(13, 55);

    }



    public SalesRepresentative[] sortByRevenue() {

        for(int i = 0; i < representatives.length; i++){
            for (int j = 0; j < representatives.length-i-1; j++) {
                if (representatives[j].getValue() > representatives[j + 1].getValue()) {
                    SalesRepresentative temp = representatives[j];
                    representatives[j] = representatives[j + 1];
                    representatives[j + 1] = temp;
                }
            }

        }

        return representatives;
    }

}
