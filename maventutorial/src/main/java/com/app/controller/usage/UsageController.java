package com.app.controller.usage;

import com.app.entity.User_Room;
import com.app.models.RegisterUsageForm;
import com.app.services.usage.UsageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class UsageController {
    @Autowired
    UsageService usageService;

    @RequestMapping(value = "/usage/all", method = RequestMethod.GET)
    public ResponseEntity<List<User_Room>> getAllUsage() {
        return new ResponseEntity<List<User_Room>>(usageService.getAllUsage(), HttpStatus.OK);
    }

    @RequestMapping(value = "/usage/register", method = RequestMethod.POST)
    public ResponseEntity<Map<String, User_Room>> registerUsage(@RequestBody RegisterUsageForm input) {
        int id = input.getId();
        String email = input.getEmail();
        return new ResponseEntity<Map<String, User_Room>>(usageService.registerUsage(id, email), HttpStatus.OK);
    }
}
