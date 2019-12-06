package classes;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//import javax.validation.constraints.NotNull
@Entity
@Table(name = "wallets")
public class Wallet {

    @Id
    @Column(name = "id")
    private int user_id;
    public String currency;
    @MoreThanZero//my own annotation classes.MoreThanZero.class
    public double balance;
    public int id;

    Wallet(int user_id, String currency, double balance, int id) {
        this.user_id = user_id;
        this.balance = balance;
        this.id = id;
        this.currency = currency;
    }

    public Wallet() {

    }

    public int getUser_id() {
        return user_id;
    }

    @Override
    public String toString() {
        return "Wallet{" +
                "user_id=" + user_id +
                ", currency='" + currency + '\'' +
                ", balance=" + balance +
                ", id=" + id +
                '}';
    }

    public Wallet(int user_id, int currency) {
        this.user_id = user_id;
        this.balance = 0;
        switch (currency){
            case 1:{
                this.currency = "UAH";
                break;
            }
            case 2:{
                this.currency = "USD";
                break;
            }
            case 3:{
                this.currency = "EUR";
            }

        }
    }
}
