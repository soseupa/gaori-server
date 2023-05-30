package project.gaori.server.domain.friend.request.exception;

import project.gaori.server.domain.friend.request.exception.error.FriendRequestErrorProperty;
import project.gaori.server.global.error.exception.GaoriException;

public class FriendRequestForbiddenException extends GaoriException {
    public final static FriendRequestForbiddenException EXCEPTION = new FriendRequestForbiddenException();

    public FriendRequestForbiddenException() {
        super(FriendRequestErrorProperty.FRIEND_REQUEST_FORBIDDEN);
    }
}
