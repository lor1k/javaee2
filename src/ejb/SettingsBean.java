package ejb;

import javax.ejb.Singleton;

@Singleton(name = "SettingsEJB")
public class SettingsBean {
    public boolean isGodMode = true;

    public SettingsBean() {
    }
}
