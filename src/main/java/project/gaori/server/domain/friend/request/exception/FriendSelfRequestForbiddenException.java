package project.gaori.server.domain.friend.request.exception;

import project.gaori.server.domain.friend.request.exception.error.FriendRequestErrorProperty;
import project.gaori.server.global.error.exception.GaoriException;

public class FriendSelfRequestForbiddenException extends GaoriException {
    public final static FriendSelfRequestForbiddenException EXCEPTION = new FriendSelfRequestForbiddenException();

    public FriendSelfRequestForbiddenException() {
        super(FriendRequestErrorProperty.FRIEND_SELF_REQUEST_FORBIDDEN);
    }
}
