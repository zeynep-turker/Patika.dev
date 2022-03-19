package account;

import insurance.Insurance;

public class Enterprise extends Account {
    public Enterprise() {
        this.user = new User();
        this.setType("Kurumsal");
    }

    /**
     * Sigorta ücreti Kurumsal hesaba göre ayarlanır
     * @param insurance Sigorta nesnesi
     */
    @Override
    public void addInsurance(Insurance insurance) {
        switch (insurance.getName()) {
            case "Sağlık":
                insurance.setPrice(200.0);
                break;
            case "Seyahat":
                insurance.setPrice(300.0);
                break;
            case "Otomobil":
                insurance.setPrice(400.0);
                break;
            case "Konut":
                insurance.setPrice(500.0);
                break;
        }
        getInsuranceList().add(insurance);
    }
}
