package com.example.bookmyshow.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "User was not found")
public class NoUserFound extends RuntimeException{
}
