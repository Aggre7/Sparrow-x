package com.distributedx.user.users.features.createuser;

import com.distributedx.user.users.dtos.UserDto;
import com.distributedx.user.users.features.Mappings;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import buildingblocks.mediator.abstractions.IMediator;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.access.prepost.PreAuthorize;


@RestController
@RequestMapping(path = "api/v1/user")
@Tag(name = "user")
public class UserController {

    private final IMediator mediator;

    public UserController(IMediator mediator) {
        this.mediator = mediator;
    }

    @PostMapping()
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<UserDto> createUser(@RequestBody CreateUserRequestDto createUserRequestDto) {
        CreateUserCommand command = Mappings.toCreateUserCommand(createUserRequestDto);
        var result = this.mediator.send(command);
        return ResponseEntity.ok().body(result);
    }
}

