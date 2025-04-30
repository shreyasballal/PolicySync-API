package com.shreyas.policysync.controller;

import com.shreyas.policysync.entities.Policy;
import com.shreyas.policysync.repositories.PolicyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/policies")
public class PolicyController {

    @Autowired
    private PolicyRepository policyRepository;

    // POST /policies - Create a new policy
    @PostMapping
    public ResponseEntity<Policy> createPolicy(@RequestBody Policy policy) {
        Policy savedPolicy = policyRepository.save(policy);
        return ResponseEntity.ok(savedPolicy);
    }

    // GET /policies - List all policies
    @GetMapping
    public ResponseEntity<List<Policy>> getAllPolicies() {
        List<Policy> policies = policyRepository.findAll();
        return ResponseEntity.ok(policies);
    }

    // GET /policies/{id} - Get a policy by ID
    @GetMapping("/{id}")
    public ResponseEntity<Policy> getPolicyById(@PathVariable Long id) {
        Optional<Policy> policy = policyRepository.findById(id);
        return policy.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}