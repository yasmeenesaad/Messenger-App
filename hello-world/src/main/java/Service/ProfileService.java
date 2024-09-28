package Service;

import Model.Profile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProfileService {

    private Map<String, Profile> profiles = new HashMap<String, Profile>();

    public ProfileService() {
        profiles.put("key1",new Profile("yasmeena","yasmeen","saad"));
        profiles.put("key2",new Profile("maro","marwan","amgad"));
    }

    public List<Profile> getProfiles() {
        return new ArrayList<Profile>(profiles.values());
    }

    public Profile getProfile(String profileName) {
        return profiles.get(profileName);
    }
public Profile addProfile(Profile profile) {
        profile.setId(profiles.size()+1);
        profiles.put(profile.getProfileName(), profile);
        return profile;
}
public Profile updateProfile(Profile profile) {
        if(profile.getProfileName().isEmpty())
        {
            return null;
        }
        profiles.put(profile.getProfileName(), profile);
        return profile;
}
public Profile removeProfile(String profileName) {
        return profiles.remove(profileName);
}

}
