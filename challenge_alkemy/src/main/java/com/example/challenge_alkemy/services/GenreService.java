package com.example.challenge_alkemy.services;

import com.example.challenge_alkemy.dto.GenreDTO;
import com.example.challenge_alkemy.mappers.GenreMapper;
import com.example.challenge_alkemy.models.Genre;
import com.example.challenge_alkemy.repositories.IGenreRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenreService implements IGenreService {

    @Autowired
    private IGenreRepository genreRepository;

    @Autowired
    private GenreMapper genreMapper;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public GenreDTO saveGenre(GenreDTO genreDTO) {
        Genre genre = genreMapper.converterToGenero(genreDTO);
        Genre genreSave = genreRepository.save(genre);
        GenreDTO result = genreMapper.converterToGeneroDTO(genreSave);
        return result;
    }

    @Override
    public List<GenreDTO> getAll() {
        // =================== OPCION 1 ======================
        List<Genre> genres = genreRepository.findAll();
        List<GenreDTO> generosDTO = genreMapper.convertListToDTO(genres);
        /*// ====================== OPCION 2 ================
        // UTILIZO EL FOR PARA RECORRER MIS LISTAS Y CONVERTIR A "GenerosDTO.class"
        // SIN NECESIDAD DE CREAR UNA FUNCION DENTRO DE "GenreMapper.class"
        List<Genre> genres = generoRepository.findAll();
        List<GenreDTO> generosDTO = new ArrayList<>();
        // ==================== CONVIERTE LOS GENEROS EN GENEROSDTO Y LOS AÑADE A SU RESPECTIVA LISTA =================
        for (int i = 0; i < genres.size(); i++) {
            generosDTO.add(genreMapper.converterToGeneroDTO(genres.get(i)));
        }*/
        return generosDTO;
    }


    @Override
    public GenreDTO findByName(String nombre) {
        return null;
    }

    @Override
    public GenreDTO findById(Long id) {
        Optional<Genre> genreFound = genreRepository.findById(id);
        Genre genre = genreMapper.convertOptionalToGenre(genreFound);
        GenreDTO genreDTO = modelMapper.map(genre, GenreDTO.class);
        return   genreDTO;
    }

    @Override
    public void delete(Long id) {
        genreRepository.deleteById(id);
    }

    @Override
    public GenreDTO update(Long id, GenreDTO genreDTO) {
        // TODO: ARREGLAR -> NO ACTUALIZA GENEROS SINO QUE CREA NUEVOS GENEROS
        //
        /*Optional<Genre> genreFound = genreRepository.findById(id);
        Genre genre = genreMapper.convertOptionalToGenre(genreFound);
        GenreDTO genreDTO1 = genreMapper.converterToGeneroDTO(genre);
        GenreDTO result = null;
        if(genreFound.isPresent()){
            genreDTO1.setId(id);
            result = saveGenre(genreDTO1);
        }else{
            System.out.println("NO FOUND GENRE! ");
        }*/
        // TODO: SE ELIMINO EL GENRE CON ID DADO POR PATH PERO EL ID NO SE PUDO MODIFICAR, DEBE DARSE PORQUE LA ENTIDAD TIENE LA ANOTACION "strategy = GenerationType.IDENTITY" -> INTENTAR QUITARLA
        delete(id);
        Genre genre = genreMapper.converterToGenero(genreDTO);
        Genre genreSaved = genreRepository.save(genre);
        GenreDTO result = genreMapper.converterToGeneroDTO(genreSaved);
        return result;
    }
}
