package com.sparrowx.profile.grpcserver;

import buildingblocks.mediator.abstractions.IMediator;
import com.sparrowx.profile.dtos.ProfileDto;
import com.sparrowx.profile.features.profile.queries.GetProfileByIdQuery;
import com.sparrowx.profile.grpc.ProfileRequestDto;
import com.sparrowx.profile.grpc.ProfileResponseDto;
import com.sparrowx.profile.grpc.ProfileServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

import java.util.UUID;

import static com.sparrowx.profile.features.Mappings.toProfileResponseDtoGrpc;

@GrpcService
public class ProfileServiceGrpcImpl extends ProfileServiceGrpc.ProfileServiceImplBase {

    private final IMediator mediator;

    public ProfileServiceGrpcImpl(IMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void getProfileById(ProfileRequestDto request,
                               StreamObserver<ProfileResponseDto> responseObserver) {

        ProfileDto result = mediator.send(new GetProfileByIdQuery(UUID.fromString(request.getId())));
        ProfileResponseDto response = toProfileResponseDtoGrpc(result);

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
