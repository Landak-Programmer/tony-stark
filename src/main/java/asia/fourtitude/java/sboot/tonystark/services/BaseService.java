package asia.fourtitude.java.sboot.tonystark.services;

public class BaseService {

    protected boolean isChanged(final Object persistence, final Object changeSet) {
        if (persistence == null && changeSet == null) {
            return false;
        }
        if (persistence == null) {
            return true;
        }
        // If incoming change is NULL, assume no change!
        if (changeSet == null) {
            return false;
        }
        return !persistence.equals(changeSet);
    }
}
