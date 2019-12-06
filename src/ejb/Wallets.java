package ejb;

import classes.Wallet;

import javax.ejb.Remove;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;
import java.util.List;

public class Wallets {
    @PersistenceContext(unitName = "wallet-unit", type = PersistenceContextType.EXTENDED)
    private EntityManager entityManager;
    public void addWallet(Wallet wallet) throws Exception {
        entityManager.persist(wallet);
    }
    @Remove
    public void deleteWallet(Wallet wallet) throws Exception {
        entityManager.remove(wallet);
    }

    public List<Wallet> getWallets() throws Exception {
        Query query = null;
        //query = entityManager.createQuery("SELECT w from wallets as w");
        return query.getResultList();
    }
}
