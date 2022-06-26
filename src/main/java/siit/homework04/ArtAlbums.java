package siit.homework04;

public class ArtAlbums extends Books{

    int paperQuality;

    //paperQuality can take value from 1 to 5, 5 means a very good quality and 1 very poor quality

    public ArtAlbums(String name, int noOfPages, int paperQuality) {
        super(name, noOfPages);
        this.paperQuality=paperQuality;
    }


    /*
     the paper quality rate system will be implemented in the upcoming updates
     */
    public void setPaperQuality(int paperQuality) {
        if(paperQuality<=5 && paperQuality>=1){
            this.paperQuality = paperQuality;
        }else{
            System.out.println("the paper quality should be rated from 1  to 5 ");
        }

    }

    public int getPaperQuality() {
        return paperQuality;
    }

    @Override
    public String toString() {
        {
            return "Nume Art album: " + getName()+ " "+ " " + "Number of pages:  " + getNoOfPages() + " " +"Paper Quality: " + getPaperQuality();
        }
    }
}
