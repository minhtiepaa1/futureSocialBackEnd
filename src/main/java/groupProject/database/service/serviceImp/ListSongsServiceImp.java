package groupProject.database.service.serviceImp;

import groupProject.database.domain.entity.ListSongs;
import groupProject.database.repository.ListSongsRepository;
import groupProject.database.service.serviceInterface.ListSongsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ListSongsServiceImp implements ListSongsService {
    @Autowired
    ListSongsRepository listSongsRepository;
    public ListSongs create(ListSongs listSongs){
        if (listSongs.getNameSong() == null || listSongs.getNameSong().isEmpty()){
            return null;
        }
        return listSongsRepository.save(listSongs);
    }
}
