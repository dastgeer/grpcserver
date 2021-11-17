package net.techtter.service;

import io.grpc.stub.StreamObserver;
import net.techtter.grpc.*;

public class UserService extends userGrpc.userImplBase {
    @Override
    public void login(LoginRequest request, StreamObserver<APIResponse> responseObserver) {

        String username = request.getUsername();
        String password = request.getPassword();

        APIResponse.Builder response = APIResponse.newBuilder();

        if(username.equals(password)){
            //success message
            response.setResponseCode(1).setResponseMessage("Success");

        } else  {
            //failure message
            response.setResponseCode(0).setResponseMessage("Invalid username or password");
        }

        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }

    @Override
    public void logout(Empty request, StreamObserver<APIResponse> responseObserver) {

    }
}
