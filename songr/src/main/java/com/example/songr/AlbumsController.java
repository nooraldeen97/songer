package com.example.songr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
public class AlbumsController {

    @Autowired
    albumRepository albumRepository;

    @Autowired
    SongRepository songRepository;

    @GetMapping("/albums")
    public String getAlbums(Model model){
//        List <Album> allAlbums =new ArrayList<Album>();
//        Album b1 = new Album("English album","steve kekana",3,1400,"https://w7.pngwing.com/pngs/1004/317/png-transparent-digital-audio-compact-disc-computer-icons-album-sound-music-font-album-logo-sound.png");
//        Album b2= new Album("French Montana","david jax",4,4000,"https://www.davibemag.com/wp-content/uploads/2013/05/french-montana-excuse-my-french-album-snippets-preview.jpg");
//        Album b3 = new Album("Italian Album","Dean Martin",6,8000,"https://m.media-amazon.com/images/I/41SJ7JWCCBL._SY580_.jpg");
//        allAlbums.add(b1);
//        allAlbums.add(b2);
//        allAlbums.add(b3);
//        model.addAttribute("allAlbum",allAlbums);
        List<Album> albums = (List<Album>) albumRepository.findAll();
        model.addAttribute("albumClass", new Album());
        model.addAttribute("addedAlbum",albums);
//        model.addAttribute("addedAlbum",albumRepository.findAll());
        return "album.html";
    }


    @PostMapping("/albums")
    public RedirectView addAlbums(@ModelAttribute Album album, Model model){
        albumRepository.save(album);

//List<Album> albums = (List<Album>) albumRepository.findAll();
       model.addAttribute("albumClass", new Album());
//        model.addAttribute("addedAlbum",albums);
         return new RedirectView("/albums");
    }

    @GetMapping("/albums/{id}")
    public  String  getSpecificAlbum(Model model, @PathVariable("id") Integer id){
        System.out.println(id);
        model.addAttribute("theAlbum",albumRepository.findById(id).get());



        List<Song> theSong = (List<Song>) songRepository.findAllByAlbumId(id);
        model.addAttribute("songClass", new Song());
        model.addAttribute("addedSongs",theSong);
        return  "specificAlbum.html";
    }

//    @GetMapping("/albums")
//    public String getSong(Model model){
//
//        return "specificAlbum.html";
//    }


    @PostMapping("/albums/{id}")
    public RedirectView addSongs(  Model model, @RequestParam String title ,Integer length, Integer trackNumber, @PathVariable("id") Integer id){
        Album album=albumRepository.findById(id).get();

        Song song= new Song(title,length,trackNumber,album);
        songRepository.save(song);
        model.addAttribute("album",album);
        model.addAttribute("songClass",new Song());
        return new RedirectView("/albums/{id}");
    }


}
