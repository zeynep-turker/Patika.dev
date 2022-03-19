package insurance;

import java.util.Date;

public class TravelInsurance extends Insurance{
    public TravelInsurance() {
        this.setName("Seyahat");
        this.setPrice(100.0);
        this.setStartDate(new Date());
        this.setFinishDate();
    }

    @Override
    public double calculate() {
        return getPrice();
    }
}
