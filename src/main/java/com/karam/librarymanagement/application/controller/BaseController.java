package com.karam.librarymanagement.application.controller;

import com.karam.librarymanagement.application.dto.OutputDTO;
import com.karam.librarymanagement.application.dto.response.ApiSuccessResponse;
import com.karam.librarymanagement.application.dto.response.LinksResponse;
import com.karam.librarymanagement.application.dto.response.Message;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

public class BaseController {

    protected ResponseEntity<ApiSuccessResponse> sendCreatedStatus(HttpServletRequest request,
                                                                   OutputDTO outputDTO,
                                                                   Message message) {
        var apiResponse = new ApiSuccessResponse(
                CREATED.value(),
                new LinksResponse(request.getRequestURI(), request.getMethod()),
                List.of(message),
                outputDTO
        );

        return ResponseEntity.status(CREATED.value()).body(apiResponse);
    }
    protected ResponseEntity<ApiSuccessResponse> sendOkStatus(HttpServletRequest request,
                                              OutputDTO outputDTO,
                                              Message message) {
        var apiResponse = new ApiSuccessResponse(
                OK.value(),
                new LinksResponse(request.getRequestURI(), request.getMethod()),
                List.of(message),
                outputDTO
        );

        return ResponseEntity.ok(apiResponse);
    }
}
