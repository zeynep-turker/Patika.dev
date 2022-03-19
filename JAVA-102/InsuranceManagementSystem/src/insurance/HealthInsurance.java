package insurance;

import java.util.Date;

public class HealthInsurance extends Insurance{
    public HealthInsurance() {
        this.setName("Sağlık");
        this.setPrice(100.0);
        this.setStartDate(new Date());
        this.setFinishDate();
    }

    @Override
    public double calculate() {
        return getPrice();
    }
}
