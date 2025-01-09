package com.iliyas.rps.demo;

import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class ScoreController {

    static Score score = new Score(30, 20, 10);

    @GetMapping("/score")
    public Score getScore(){
        return score;
    }

    @GetMapping("/health-check")
    public String getHealthCheck(){
        return "Situation normal all fired up";
    }

    @GetMapping("/score/{winslossesorties}")
    public int getWinsLossesOrTies(@PathVariable String winslossesorties){
        if(winslossesorties.equals("wins")) return score.getWins();
        if(winslossesorties.equals("ties")) return score.getTies();
        return score.getLosses();
    }

    @PostMapping("/score/wins")
    public Score increaseWins(){
        score.setWins(score.getWins()+1);
        return score;
    }

    @PostMapping("/score/ties")
    public Score increaseTies(){
        score.setTies(score.getTies()+1);
        return score;
    }

    @PostMapping("/score/losses")
    public Score increaseLosses(){
        score.setLosses(score.getLosses()+1);
        return score;
    }


    @PatchMapping("/score/wins")
    public Score updateWins(@RequestParam(name = "new-value")int newValue){
        score.setWins(newValue);
        return score;
    }

    @PatchMapping("/score/ties")
    public Score updateTies(@RequestParam(name = "new-value")int newValue){
        score.setTies(newValue);
        return score;
    }

    @PatchMapping("/score/losses")
    public Score updateLosses(@RequestParam(name = "new-value")int newValue){
        score.setLosses(newValue);
        return score;
    }

    @PutMapping("/score")
    public Score replaceScore(@RequestBody Score newScore){
        score = newScore;
        return score;
    }

    @DeleteMapping("/score")
    public void deleteScore(){
        score = null;
    }


}
