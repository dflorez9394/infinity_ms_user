package com.infinity.user.controller.doc;

import com.infinity.user.dto.UserDTO;
import com.infinity.user.model.UserEntity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name="User controller" ,description = "Api para el CRUD de usuarios")
public interface IUserDoc {

    @Operation(
            summary = "create user",
            description = "this operation is for creating users"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "201",description = "user created",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)
                    ),
                    @ApiResponse(
                            responseCode = "400",description = "bad request",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)
                    )
            }
    )
    ResponseEntity<UserEntity> create(
            @RequestBody UserDTO user
    );
}
