package com.app.controller.room;

import com.app.entity.Rooms;
import com.app.models.AddRoomForm;
import com.app.models.Response;
import com.app.services.room.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RoomController {
    @Autowired
    RoomService roomService;

    @RequestMapping(value = "/room/id/{id}", method = RequestMethod.GET)
    public ResponseEntity<Rooms> findRoomByID(@PathVariable("id") int id){
        Rooms room = roomService.findRoomByID(id);
        if (room!=null) {
            return new ResponseEntity<Rooms>(room, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<Rooms>(HttpStatus.NO_CONTENT);
        }
    }

    @RequestMapping(value = "/room/name/{name}", method = RequestMethod.GET)
    public ResponseEntity<Rooms> findRoomByID(@PathVariable("name") String name){
        Rooms room = roomService.findRoomByName(name);
        if (room!=null) {
            return new ResponseEntity<Rooms>(room, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<Rooms>(HttpStatus.NO_CONTENT);
        }
    }

    @RequestMapping(value = "/rooms", method = RequestMethod.GET)
    public ResponseEntity<List<Rooms>> findAllRooms(){
        List<Rooms> rooms = roomService.findAllroom();
        if (!rooms.isEmpty()) {
            return new ResponseEntity<List<Rooms>>(rooms, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<List<Rooms>>(HttpStatus.NO_CONTENT);
        }
    }

    @RequestMapping(value = "/room/remove/{id}", method = RequestMethod.GET)
    public ResponseEntity<Response> removeRoomByID(@PathVariable("id") int id){
        return new ResponseEntity<Response>( new Response("Remove room "+id,roomService.removeRoomByID(id),""),HttpStatus.OK);
    }

    @RequestMapping(value = "/room/add", method = RequestMethod.POST)
    public ResponseEntity<Rooms> addRoom(@RequestBody AddRoomForm input){
        String result = roomService.addRoom(input.getName(),input.getFloor());
        Rooms room = roomService.findLastRoom();
        if (room.getName().equalsIgnoreCase(input.getName()) && result.equalsIgnoreCase("succeeded")){
            return new ResponseEntity<Rooms>(room, HttpStatus.OK);
        }
        return new ResponseEntity<Rooms>(HttpStatus.CONFLICT);
    }
}
