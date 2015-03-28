package ohtu.verkkokauppa;

public class ViiteGeneraattori implements ViiteGeneraattoriIO {
    
    private int seuraava;
    
    public void Viitegeneraattori(){
        seuraava = 1;    
    }
    
    @Override
    public int uusi(){
        return seuraava++;
    }
}
