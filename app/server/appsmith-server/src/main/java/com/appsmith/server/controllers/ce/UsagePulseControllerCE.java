package com.appsmith.server.controllers.ce;

import com.appsmith.server.dtos.ResponseDTO;
import com.appsmith.server.dtos.UsagePulseDTO;
import com.appsmith.server.services.UsagePulseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class UsagePulseControllerCE {

    private final UsagePulseService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<ResponseDTO<Boolean>> create(@RequestBody @Valid UsagePulseDTO usagePulseDTO) {
        return service.createPulse(usagePulseDTO)
                .thenReturn(new ResponseDTO<>(HttpStatus.CREATED.value(), true, null));
    }

}
