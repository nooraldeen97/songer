package com.example.songr;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AlbumsController {

    @GetMapping("/albums")
    public String getAlbums(Model model){
        List <Album> allAlbums =new ArrayList<Album>();
        Album b1 = new Album("English album","steve kekana",3,1400,"https://w7.pngwing.com/pngs/1004/317/png-transparent-digital-audio-compact-disc-computer-icons-album-sound-music-font-album-logo-sound.png");
        Album b2= new Album("French Montana","david jax",4,4000,"https://www.davibemag.com/wp-content/uploads/2013/05/french-montana-excuse-my-french-album-snippets-preview.jpg");
        Album b3 = new Album("Italian Album","Dean Martin",6,8000,"https://m.media-amazon.com/images/I/41SJ7JWCCBL._SY580_.jpg");
        allAlbums.add(b1);
        allAlbums.add(b2);
        allAlbums.add(b3);
        model.addAttribute("allAlbum",allAlbums);
        return "album.html";
    }
}