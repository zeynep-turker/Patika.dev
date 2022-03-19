package insurance;

import java.util.Date;

public class ResidenceInsurance extends Insurance{
    public ResidenceInsurance() {
        this.setName("Konut");
        this.setPrice(100.0);
        this.setStartDate(new Date());
        this.setFinishDate();
    }

    @Override
    public double calculate() {
        return getPrice();
    }
}
