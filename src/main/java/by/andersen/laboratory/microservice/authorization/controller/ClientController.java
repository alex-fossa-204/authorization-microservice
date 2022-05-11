package by.andersen.laboratory.microservice.authorization.controller;

import by.andersen.laboratory.microservice.authorization.model.ClientDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
public class ClientController extends ErrorControllerHandler {

    @GetMapping("/client/get/list")
    public ResponseEntity<List<ClientDto>> getAllClients() {
        return new ResponseEntity<>(null, OK);
    }

    @GetMapping("/client/get/by/uid/{uid}")
    public ResponseEntity<ClientDto> getClientByUid(@PathVariable("uid") Long uid) {
        return new ResponseEntity<>(null, OK);
    }

    @PostMapping("/client/register")
    public ResponseEntity<ClientDto> registerNewClient(@RequestBody ClientDto newClient) {
        return new ResponseEntity<>(null, OK);
    }

    @PatchMapping("/client/update")
    public ResponseEntity<ClientDto> updateNewClient(@RequestBody ClientDto updateClient) {
        return new ResponseEntity<>(null, OK);
    }

    @DeleteMapping("/client/delete")
    public ResponseEntity<ClientDto> deleteClient(@RequestBody ClientDto deleteClient) {
        return new ResponseEntity<>(null, OK);
    }

}
