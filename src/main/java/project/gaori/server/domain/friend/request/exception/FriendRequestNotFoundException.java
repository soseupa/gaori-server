package project.gaori.server.domain.friend.request.exception;

import project.gaori.server.domain.friend.request.exception.error.FriendRequestErrorProperty;
import project.gaori.server.global.error.exception.GaoriException;

public class FriendRequestNotFoundException extends GaoriException {
    public final static FriendRequestNotFoundException EXCEPTION = new FriendRequestNotFoundException();

    public FriendRequestNotFoundException() {
        super(FriendRequestErrorProperty.FRIEND_REQUEST_NOT_FOUND);
    }
}
