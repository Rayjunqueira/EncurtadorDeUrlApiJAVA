package com.example.encurterlinkapi.controllers;

import com.example.encurterlinkapi.dtos.EncurterDto;
import com.example.encurterlinkapi.mappers.EncurterMapper;
import com.example.encurterlinkapi.models.EncurterModel;
import com.example.encurterlinkapi.services.EncurterService;
import com.example.encurterlinkapi.utils.GenerateEncurterCode;
import com.example.encurterlinkapi.utils.VerifyLink;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/en")
public class EncurterController {
    final EncurterService encurterService;
    final EncurterMapper encurterMapper;
    final VerifyLink verifyLink;
    final GenerateEncurterCode generateEncurterCode;

    public EncurterController(EncurterService encurterService, EncurterMapper encurterMapper, VerifyLink verifyLink, GenerateEncurterCode generateEncurterCode) {
        this.encurterService = encurterService;
        this.encurterMapper = encurterMapper;
        this.verifyLink = verifyLink;
        this.generateEncurterCode = generateEncurterCode;
    }

    @PostMapping
    public ResponseEntity<Object> saveEncurter(@RequestBody @Valid EncurterDto encurterDto) {
        try {
            EncurterModel encurterModel = encurterMapper.toEncurterModel(encurterDto);
            Boolean resultLink = verifyLink.verify(encurterDto.getUrl());

            if (resultLink == false) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Url invalid!");
            }
            Integer code;
            do {
                code = generateEncurterCode.generateCode();
            } while (encurterService.existsByEncurterCode(code));

            encurterModel.setEncurterCode(code);

            return ResponseEntity.status(HttpStatus.CREATED).body(encurterService.save(encurterModel));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e);
        }
    }

    @GetMapping("/{code}")
    public ResponseEntity<Void> redirectUrl(@PathVariable String code, HttpServletResponse response) {
        Integer intCode = Integer.valueOf(code);
        Optional<EncurterModel> encurterModelOptional = encurterService.findByEncurterCode(intCode);

        if (encurterModelOptional.isPresent()) {
            EncurterModel encurterModel = encurterModelOptional.get();
            String url = encurterModel.getUrl();

            response.setHeader("Location", url);
            return new ResponseEntity<>(HttpStatus.MOVED_PERMANENTLY);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
