package groupProject.database.controller;

import groupProject.database.domain.entity.ListSongs;
import groupProject.database.service.serviceInterface.ListSongsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/listSongs")
public class ListSongsController {
    @Autowired
    ListSongsService listSongsService;
    @PostMapping("/id")
    public ListSongs create(ListSongs listSongs){
        return listSongsService.create(listSongs);
    }
}
