package com.example.reportservice.controller;

import com.example.reportservice.data.Statistic;
import com.example.reportservice.service.StatisticService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/statistic")
public class StatisticController {

    private final StatisticService statisticService;

    @Operation(
          summary = "Get statistic",
          description = "Get statistic for user with username"
    )
    @ApiResponses({
          @ApiResponse(responseCode = "200", description = "Successfully retrieved"),
          @ApiResponse(responseCode = "400", description = "Invalid parameters or other bad request"),
          @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    @GetMapping("/{username}")
    public Statistic getStatisticByUsername(
          @Parameter(description = "User's username", required = true) @PathVariable String username) {
        log.info("Get statistic by user username {}", username);
        return statisticService.getStatisticByUsername(username);
    }
}
