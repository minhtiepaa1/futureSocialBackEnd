package groupProject.database.service.serviceInterface;

import groupProject.database.domain.entity.ListSongs;
import org.springframework.stereotype.Service;

@Service
public interface ListSongsService {
    public ListSongs create(ListSongs listSongs);
}
