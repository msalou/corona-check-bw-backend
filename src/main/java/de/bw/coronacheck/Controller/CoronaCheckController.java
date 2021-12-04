package de.bw.coronacheck.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import de.bw.coronacheck.service.CoronaCheckService;

@RestController
public class CoronaCheckController {

  @Autowired
  private CoronaCheckService coronaCheckService;

  @GetMapping("/")
  public String get() {
    return coronaCheckService.getOptions();
  }

}