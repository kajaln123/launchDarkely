import com.launchdarkly.client.LDClient;
import com.launchdarkly.client.LDUser;

import java.io.IOException;

import static java.util.Collections.singletonList;

public class Hello {

 public static void main(String... args) throws IOException {
   LDClient client = new LDClient("sdk-c44d0268-5af2-430a-b0c2-52fb43d89f9a");

   LDUser user = new LDUser.Builder("kajal@example.com")
                           .firstName("Bob")
                           .lastName("Loblaw")
                           .customString("groups", singletonList("beta_testers"))
                           .build();

   boolean showFeature = client.boolVariation("user-view", user, false);

   if (showFeature) {
    System.out.println("Showing your feature");
   } else {
    System.out.println("Not showing your feature");
   }

   client.flush();
   client.close();
 }
}
