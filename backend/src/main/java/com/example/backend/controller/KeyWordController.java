package com.example.backend.controller;

import com.example.backend.data.dto.KeywordDto;
import com.example.backend.service.KeywordService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/keyword")
@RequiredArgsConstructor
public class KeyWordController {
    private final KeywordService keyWordService;

    @Operation(
            summary = "Create keyword",
            description = "Create keyword"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Successfully retrieved"),
            @ApiResponse(responseCode = "400", description = "Invalid parameters or other bad request"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PostMapping("")
    public void createKeyword(@RequestBody KeywordDto keyWordDto) {
        keyWordService.createKeyword(keyWordDto);
    }
}
