package insurance;

import java.util.Date;

public class CarInsurance extends Insurance{
    public CarInsurance() {
        this.setName("Otomobil");
        this.setPrice(100.0);
        this.setStartDate(new Date());
        this.setFinishDate();
    }

    @Override
    public double calculate() {
        return getPrice();
    }
}
