package sg.edu.np.mad.practical4;

public class User {
    private String userName;
    private String userDescription;
    private int userID;
    private boolean userFollowed;

    public User(String userName, String userDescription, int userID, boolean userFollowed){
        this.userName = userName;
        this.userDescription = userDescription;
        this.userID = userID;
        this.userFollowed = userFollowed;
    }
    public User(){

    }

    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserDescription() {
        return userDescription;
    }
    public void setUserDescription(String userDescription) {
        this.userDescription = userDescription;
    }

    public int getUserID() {
        return userID;
    }
    public void setUserID(int userID) {
        this.userID = userID;
    }

    public boolean isUserFollowed() {
        return userFollowed;
    }
    public void setUserFollowed(boolean userFollowed) {
        this.userFollowed = userFollowed;
    }
}
