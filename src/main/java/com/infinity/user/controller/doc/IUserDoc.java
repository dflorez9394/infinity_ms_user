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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

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

    @Operation(
            summary = "listar por nombre",
            description = "api que permite listar todos los usuairos por nombre"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",description = "user list",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)
                    ),
                    @ApiResponse(
                            responseCode = "400",description = "bad request",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)
                    )
            }
    )
    ResponseEntity<?> listByName(
            @RequestParam("name") String name
    );

    @Operation(
            summary = "listar nombre por coincidencias",
            description = "api que permite listar todos los usuairos por una coincidencia"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",description = "user list",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)
                    ),
                    @ApiResponse(
                            responseCode = "400",description = "bad request",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)
                    )
            }
    )
    ResponseEntity<?> listByNameConsidents(
            @RequestParam("name") String name
    );


}
