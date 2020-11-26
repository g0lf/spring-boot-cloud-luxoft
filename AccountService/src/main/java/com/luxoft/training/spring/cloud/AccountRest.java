package com.luxoft.training.spring.cloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class AccountRest {

    @Autowired
    private AccountDAO dao;

    @Autowired
    private AccountRepository repo;

    @RequestMapping("/create")
    @PreAuthorize("hasAuthority('ACCOUNT_WRITE')")
    public void create(@RequestParam("client_id") Integer clientId) {
        dao.create(clientId);
    }

    @RequestMapping("/fund/{id}")
    @PreAuthorize("hasAuthority('ACCOUNT_PROCESS')")
    public boolean fund(@PathVariable Integer id, @RequestParam BigDecimal sum) {
        return dao.addBalance(id, sum.abs());
    }

    @RequestMapping("/checkout/{id}")
    @PreAuthorize("hasAuthority('ACCOUNT_PROCESS')")
    public boolean checkout(@PathVariable Integer id, @RequestParam BigDecimal sum) {
        return dao.addBalance(id, sum.abs().negate());
    }

    @RequestMapping("/get/{clientId}")
    @PreAuthorize("hasAuthority('ACCOUNT_READ')")
    public List<? extends Account> getByClient(@PathVariable Integer clientId) {
        return repo.findByClientId(clientId);
    }
}

