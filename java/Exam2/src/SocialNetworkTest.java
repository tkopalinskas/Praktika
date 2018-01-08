import lt.infobalt.itakademija.javalang.exam.socialnetwork.BaseSocialNetworkTest;
import lt.infobalt.itakademija.javalang.exam.socialnetwork.Friend;
import lt.infobalt.itakademija.javalang.exam.socialnetwork.FriendNotFoundException;


import java.util.Collection;

public class SocialNetworkTest extends BaseSocialNetworkTest {

    @Override
    protected SocialNetwork getSocialNetwork() {
        return new SocialNetwork();

    }
}
