package Resources;

import Model.Profile;
import Service.ProfileService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("profiles")
@Consumes(MediaType.APPLICATION_JSON) //how it accepts the body
@Produces(MediaType.APPLICATION_JSON)

public class ProfileResource {
    private ProfileService profileService =new ProfileService();

    @GET
        public List<Profile> getProfiles() {
        return profileService.getProfiles();
    }

    @POST
        public Profile addProfile(Profile profile) {
        return profileService.addProfile(profile);
    }
    @PUT
    @Path("/{profileName}")
    public Profile updateProfile(@PathParam("profileName") String profileName, Profile profile) {
        return profileService.updateProfile(profile);
    }

    @DELETE
    @Path("/{profileName}")
    public void deleteProfile(@PathParam("profileName") String profileName) {
        profileService.removeProfile(profileName);
    }
}
