package com.example.controller;

import java.util.Collection;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.exception.ResourceNotFoundException;
import com.example.model.Beer;
import com.example.repository.BeerRepository;


@RestController
public class HomeController {

	@Autowired
	private BeerRepository repository;
	
	@RequestMapping("/all")
	public Collection<Beer> findAll(){
		return repository.findAll().stream().collect(Collectors.toList());
	}
	
	@GetMapping("/beer/{id}")
	public Beer getNoteById(@PathVariable(value = "id") Long beerId) {
	    return repository.findById(beerId)
	            .orElseThrow(() -> new ResourceNotFoundException("Beer", "id", beerId));
	}
	
	@DeleteMapping("/beer/{id}")
	public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Long noteId) {
	    Beer note = repository.findById(noteId)
	            .orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));

	    repository.delete(note);

	    return ResponseEntity.ok().build();
	}
	
	@PutMapping("/beer/{id}")
	public Beer updateBeer(@PathVariable(value = "id") Long beerId,
	                                        @Valid @RequestBody Beer beerDetails) {

	    Beer beer = repository.findById(beerId)
	            .orElseThrow(() -> new ResourceNotFoundException("Beer", "id", beerId));

	    BeanUtils.copyProperties(beerDetails, beer);

	    Beer updatedNote = repository.save(beer);
	    return updatedNote;
	}
	
}
