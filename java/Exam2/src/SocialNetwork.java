import lt.infobalt.itakademija.javalang.exam.socialnetwork.Friend;
import lt.infobalt.itakademija.javalang.exam.socialnetwork.FriendNotFoundException;


import java.util.*;



public class SocialNetwork implements lt.infobalt.itakademija.javalang.exam.socialnetwork.SocialNetwork {

    private List<Friend> friendList = new ArrayList<>();



    @Override
    public void addFriend(Friend friend) {

        if (friend == null) {
            throw new IllegalArgumentException();
        }

        if (this.getNumberOfFriends() == 0) {
            this.friendList.add(friend);

            return;
        }

        if (this.CheckIfFriendInList(friend) == false) {
            this.friendList.add(friend);
        }
    }

    @Override
    public int getNumberOfFriends() {
        return friendList.size();
    }

    @Override
    public Friend findFriend(String name, String lastname) throws FriendNotFoundException {
        if (name == null)
            throw new IllegalArgumentException();
        if (lastname == null)
            throw new IllegalArgumentException();
       for (Friend friend: friendList){
           if(friend.getFirstName().equals(name) && friend.getLastName().equals(lastname)){
               return friend;
           }
       }
        throw new FriendNotFoundException(name,lastname);
    }

    @Override
    public Collection<Friend> findByCity(String city) {
        if (city == null){
            throw new IllegalArgumentException();
        }
        Collection<Friend> simCity = new ArrayList<>();
        for (Friend friend : friendList){
            if (friend.getCity().equals(city)){
                simCity.add(friend);
            }
        }
        return simCity;
    }

    @Override
    public Collection<Friend> getOrderedFriends() {


            friendList.sort((Comparator<Friend>) (o1, o2) -> {
                int result = o1.getCity().compareTo(o2.getCity());
                    if (result == 0)
                        result = o1.getFirstName().compareTo(o2.getFirstName());
                    if (result == 0)
                        result = o1.getLastName().compareTo(o2.getLastName());
                    return result;
                });

        return friendList;
    }

    private boolean CheckIfFriendInList(Friend friend) {
        boolean isFriendInList = false;

        for (Friend friendInList : this.friendList) {
            if (friendInList.getFirstName().equals(friend.getFirstName())) {
                isFriendInList = true;
            }
        }

        return isFriendInList;
    }
}
