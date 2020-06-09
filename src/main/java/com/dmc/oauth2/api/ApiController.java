package com.dmc.oauth2.api;

import com.dmc.oauth2.domain.event.Event;
import com.dmc.oauth2.domain.event.EventRepository;
import com.dmc.oauth2.domain.event.dto.EventListResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ApiController {

    private final EventRepository eventRepository;

    @GetMapping("/v1/event")
    public List<Event> findAll(){
        return eventRepository.findAll();
    }

}
