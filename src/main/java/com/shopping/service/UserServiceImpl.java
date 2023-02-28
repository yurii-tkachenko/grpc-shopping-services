package com.shopping.service;

import com.shopping.db.User;
import com.shopping.db.UserDao;
import com.shopping.stubs.user.*;
import io.grpc.stub.StreamObserver;

public class UserServiceImpl extends UserServiceGrpc.UserServiceImplBase{
    private UserDao userDao = new UserDao();

    @Override
    public void getUserDetails(UserRequest request, StreamObserver<UserResponse> responseObserver) {
        User user = userDao.getDetails(request.getUsername());

        UserResponse.Builder userResponseBuilder =
                UserResponse.newBuilder()
                        .setId(user.getId())
                        .setUsername(user.getUsername())
                        .setName(user.getName())
                        .setAge(user.getAge())
                        .setGender(Gender.valueOf(user.getGender()));

        UserResponse userResponse = userResponseBuilder.build();

        responseObserver.onNext(userResponse);
        responseObserver.onCompleted();
    }
}
