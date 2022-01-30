package logic.control;

/* La classe deve essere resa singleton per gestire il numero degli ID degli utenti*/

import logic.entity.PlayerCache;
import logic.entity.PlayerUser;
import logic.other.SingletonPlayer;

import java.io.FileNotFoundException;


/**
 * Si occupa della gestione del login e della registrazione.
 * Interagisce con l'istanza Singleton per verificare che l'utente sia effettivamente loggato.
 */
public class LoginControl{
    /** Aggiunge un nuovo utente
     * @param name nome utente
     * @param password password
     * @param email email
     * @param owner booleano per indicare se l'utente è un proprietario o no
     * @throws FileNotFoundException
     */
    public void writePlayerUser(String name, String password,String email,boolean owner) throws FileNotFoundException {
        PlayerUser pu = new PlayerUser(name,owner);
        pu.writePlayerUser(password,email);
    }

    /**
     * Cerca l'utente e ne verifica la password
     * @param user nome utente
     * @param password password
     * @param owner booleano per indicare se l'utente è un proprietario o no
     * @return
     * @throws FileNotFoundException
     */
    public boolean searchUser(String user,String password,boolean owner) throws FileNotFoundException {
        PlayerUser pd = new PlayerUser(user,owner);
        boolean b = pd.searchUser(password);
        PlayerCache.setUsername(user);
        PlayerCache.setOwner(owner);
        SingletonPlayer.getLoginInstance();
        return b;
    }


    /**
     * Cerca se l'utente è presente nel sistema
     * @param user nome utente
     * @param owner booleano per indicare se l'utente è un proprietario o no
     * @return
     */
    public boolean searchUserU(String user,boolean owner) throws FileNotFoundException {
        PlayerUser pu = new PlayerUser(user,owner);
        return pu.searchUserU();
    }


    /**
     * @return il nome dell'utente loggato o null
     */
    public String getUsername(){
        SingletonPlayer sp = SingletonPlayer.getLoginInstance();
        String ret = null;
        if(sp != null)
            ret = sp.getUsername();
        return ret;
    }

    public static void logOut(){
        SingletonPlayer.deleteInstance();
    }

}
