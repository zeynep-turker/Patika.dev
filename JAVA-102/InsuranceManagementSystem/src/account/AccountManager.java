package account;

import exception.InvalidAuthenticationException;

import java.util.TreeSet;

public class AccountManager {
    TreeSet<Account> accounts = new TreeSet<>();

    /**
     * kullanıcının girmiş olduğu email ve şifrei kayıtlı hesaplar
     * içinde kontrol edilir. Email ve şifreyle eşleşen hesap var ise
     * kullanıcı giriş yapmış olur
     * @param email email
     * @param password şifre
     */
    public void login(String email, String password, String accountType) {
        boolean isLogin = false;
        try {
            for(Account account : accounts){
                if(account.getUser().getEmail().equals(email) && account.getUser().getPassword().equals(password) && account.getType().equals(accountType)){
                    account.login(email, password);
                    isLogin = true;
                }
            }
            if(!isLogin) {
                throw new InvalidAuthenticationException("Email ve/veya şifre yanlış");
            }
        } catch (InvalidAuthenticationException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Kullanıcın girmiş olduğu bilgiler ile kayıtlı kullanıcı varsa
     * kayıt olma işlemi başarısız olur
     * @param account bireysel veya kurumsal hesap
     */
    public void register(Account account) {
        for (Account acc : accounts) {
            if(account.getUser().getEmail().equals(acc.getUser().getEmail())){
                System.out.println("Bu emaile sahip kullanıcı zaten bulunmakta!");
                return;
            }
        }
        this.accounts.add(account);
        System.out.println("Kayıt işlemi başarılı!\n");
    }
}
