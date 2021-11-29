package com.sngular.omb.ombapi.controller;

import com.sngular.omb.ombapi.model.Account;
import com.sngular.omb.ombapi.service.AccountsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@Slf4j
public class AccountsController {
        
    @Autowired
    private AccountsService accountsService;

    @GetMapping("/accounts")
    @ResponseBody
    public ResponseEntity<List<Account>> getAccounts() {
       if(!accountsService.getAccounts().isEmpty()){
           log.info("Entrando a Consultar cuentas");
            return new ResponseEntity<>(accountsService.getAccounts(),HttpStatus.OK);
        }
       log.error("No hay informacion de cuentas");
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/accounts/{id}")
    @ResponseBody
    public ResponseEntity<Account> getAccounts(@PathVariable String id) {
        if(!accountsService.getAccountsById(id).isEmpty()) {
            log.info("Consultando cuenta" + id);
            return new ResponseEntity(accountsService.getAccountsById(id),HttpStatus.OK);
        } else {
            log.error("No hay informacion de la cuenta" + id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping("/accounts")
        public ResponseEntity<HttpStatus> postAccounts (@RequestBody(required = true) Account account) {

        if(account != null) {
            accountsService.postAccounts(account);
            log.info("Insertando Registro"+ account);
            return ResponseEntity.ok(HttpStatus.ACCEPTED);
        } else {
            log.error("No hay datos en el request");
            return ResponseEntity.badRequest().body(HttpStatus.BAD_REQUEST);
        }
        }
}
