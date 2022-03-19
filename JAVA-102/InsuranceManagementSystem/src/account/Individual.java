package account;

import insurance.Insurance;

public class Individual extends Account{
    public Individual() {
        this.user = new User();
        this.setType("Bireysel");
    }

    /**
     * Sigorta ücreti Bireysel hesaba göre ayarlanır
     * @param insurance Sigorta nesnesi
     */
    @Override
    public void addInsurance(Insurance insurance) {
        switch (insurance.getName()){
            case "Sağlık":  insurance.setPrice(100.0);
                            break;
            case "Seyahat": insurance.setPrice(200.0);
                            break;
            case "Otomobil":insurance.setPrice(300.0);
                break;
            case "Konut":   insurance.setPrice(400.0);
                            break;
        }
        getInsuranceList().add(insurance);
    }
}
