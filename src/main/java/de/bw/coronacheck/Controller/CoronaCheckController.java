package de.bw.coronacheck.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoronaCheckController {

  @GetMapping("/")
  public String get() {
    return "Hello World";
  }

}