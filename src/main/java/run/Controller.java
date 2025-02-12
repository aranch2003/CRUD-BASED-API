package run;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/runs")//2nd learning
public class Controller {

   private final RunRepo runRepo;
   public Controller(RunRepo runRepo)
   {
        this.runRepo=runRepo;
    }

    @GetMapping("")
    List<Run> findAll(){
   return runRepo.findAll();
   }

    @GetMapping("/{id}")//get
    Run findById(@PathVariable Integer id)
    {
        Optional<Run> run=runRepo.findById(id);
        if(run.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"pehle profile toh bana le bhai");
        return run.get();
    }

    //post
//@ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    void create(@Valid @RequestBody Run run){
       runRepo.create(run);
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    void update(@Valid @RequestBody Run run,@PathVariable Integer id)
    {
        runRepo.update(run,id);
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void delete(@PathVariable Integer id)
    {
        runRepo.delete(id);
    }
}

