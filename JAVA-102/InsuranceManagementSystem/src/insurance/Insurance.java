package insurance;

import java.util.Calendar;
import java.util.Date;

public abstract class Insurance {
    String name;
    Double price;
    Date startDate;
    Date finishDate;

    public abstract double calculate();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    /**
     * sigorta bitiş tarihi, sigortanın başlangıç tarihinden 1 sene sonrasına
     */
    public void setFinishDate() {
        Calendar c = Calendar.getInstance();
        c.setTime(getStartDate());
        c.add(Calendar.YEAR, 1);
        this.finishDate = c.getTime();
    }
}
